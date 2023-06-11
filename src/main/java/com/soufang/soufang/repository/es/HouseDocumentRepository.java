package com.soufang.soufang.repository.es;

import com.soufang.soufang.entity.es.HouseDocument;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface HouseDocumentRepository extends ElasticsearchRepository<HouseDocument, Long> {
}
