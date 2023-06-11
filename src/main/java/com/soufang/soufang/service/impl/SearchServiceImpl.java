package com.soufang.soufang.service.impl;

import com.soufang.soufang.base.BusinessException;
import com.soufang.soufang.base.Status;
import com.soufang.soufang.dto.HouseDTO;
import com.soufang.soufang.dto.HouseSearchParams;
import com.soufang.soufang.entity.House;
import com.soufang.soufang.entity.es.HouseDocument;
import com.soufang.soufang.repository.HouseRepository;
import com.soufang.soufang.service.SearchService;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.sort.SortBuilders;
import org.elasticsearch.search.sort.SortOrder;
import org.elasticsearch.search.suggest.SuggestBuilder;
import org.elasticsearch.search.suggest.SuggestBuilders;
import org.elasticsearch.search.suggest.completion.CompletionSuggestionBuilder;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.elasticsearch.core.ElasticsearchRestTemplate;
import org.springframework.data.elasticsearch.core.SearchHits;
import org.springframework.data.elasticsearch.core.query.FetchSourceFilter;
import org.springframework.data.elasticsearch.core.query.NativeSearchQuery;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.data.elasticsearch.core.suggest.response.Suggest;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SearchServiceImpl implements SearchService {
    private final ElasticsearchRestTemplate template;
    private final HouseRepository houseRepository;

    public SearchServiceImpl(ElasticsearchRestTemplate template, HouseRepository houseRepository) {
        this.template = template;
        this.houseRepository = houseRepository;
    }

    @Override
    public List<String> autocompletion(String prefix) {
        CompletionSuggestionBuilder builder = SuggestBuilders.completionSuggestion("suggest")
                .prefix(prefix)
                .skipDuplicates(true)
                .size(10);
        SuggestBuilder sb = new SuggestBuilder();
        sb.addSuggestion("autocomplete", builder);
        NativeSearchQuery query = new NativeSearchQueryBuilder().withSuggestBuilder(sb).build();
        SearchHits<HouseDocument> search = template.search(query, HouseDocument.class);
        Suggest suggest = search.getSuggest();
        return suggest.getSuggestion("autocomplete").getEntries().stream()
                .flatMap(e -> e.getOptions().stream().map(Suggest.Suggestion.Entry.Option::getText))
                .collect(Collectors.toList());
    }

    @Override
    public Page<HouseDTO> search(HouseSearchParams params) {
        if (!StringUtils.hasText(params.getCityEnName())) {
            throw new BusinessException(Status.ERROR_CITY_NOT_FOUND);
        }
        PageRequest p = PageRequest.of(params.getPage(), params.getSize());
        if (!StringUtils.hasText(params.getKeywords())) {
            return houseRepository.findAllByCityEnName(params.getCityEnName(), p).map(h -> {
                HouseDTO dto = new HouseDTO();
                BeanUtils.copyProperties(h, dto);
                return dto;
            });
        }
        BoolQueryBuilder boolQuery = QueryBuilders.boolQuery();
        boolQuery.filter(QueryBuilders.termQuery("cityEnName", params.getCityEnName()));
        boolQuery.must(QueryBuilders.multiMatchQuery(params.getKeywords(), "title", "street"));
        NativeSearchQuery query = new NativeSearchQueryBuilder()
                .withQuery(boolQuery)
                .withSorts(SortBuilders.fieldSort("lastUpdateTime").order(SortOrder.DESC))
                .withSourceFilter(new FetchSourceFilter(new String[]{"id"}, null))
                .withPageable(p)
                .build();
        SearchHits<HouseDocument> results = template.search(query, HouseDocument.class);
        List<Long> ids = results.getSearchHits().stream().map(h -> h.getContent().getId())
                .collect(Collectors.toList());
        List<House> houses = houseRepository.findAllById(ids);
        return new PageImpl<>(houses.stream().map(h -> {
            HouseDTO dto = new HouseDTO();
            BeanUtils.copyProperties(h, dto);
            return dto;
        }).collect(Collectors.toList()), p, results.getTotalHits());
    }
}
