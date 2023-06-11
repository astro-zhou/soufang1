package com.soufang.soufang.service.impl;

import com.soufang.soufang.base.BusinessException;
import com.soufang.soufang.dto.HouseIndexMessage;
import com.soufang.soufang.dto.HouseParams;
import com.soufang.soufang.entity.House;
import com.soufang.soufang.entity.es.HouseDocument;
import com.soufang.soufang.repository.HouseRepository;
import com.soufang.soufang.repository.es.HouseDocumentRepository;
import com.soufang.soufang.service.HouseService;
import org.springframework.beans.BeanUtils;
import org.springframework.data.elasticsearch.core.suggest.Completion;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

@Service
public class HouseServiceImpl implements HouseService {
    private final HouseDocumentRepository houseDocumentRepository;
    private final HouseRepository houseRepository;
    private final KafkaTemplate<String, HouseIndexMessage> template;

    public HouseServiceImpl(HouseDocumentRepository houseDocumentRepository,
                            HouseRepository houseRepository, KafkaTemplate<String, HouseIndexMessage> template) {
        this.houseDocumentRepository = houseDocumentRepository;
        this.houseRepository = houseRepository;
        this.template = template;
    }

    @KafkaListener(topics = "house")
    public void listenUpdate(HouseIndexMessage msg) {
        if (msg.getOperation() == HouseIndexMessage.Operation.INDEX) {
            updateIndex(houseRepository.findById(msg.getId()).orElseThrow(() ->
                    new BusinessException(String.format("更新索引失败，未找到数据: %s", msg.getId()))));
        } else {
            removeIndex(msg.getId());
        }
    }

    @Override
    public void updateIndex(House house) {
        HouseDocument d = new HouseDocument();
        BeanUtils.copyProperties(house, d);
        Completion completion = new Completion();
        completion.setInput(new String[]{house.getTitle(), house.getStreet(), house.getCityEnName()});
        d.setSuggest(completion);
        houseDocumentRepository.save(d);
    }

    public void removeIndex(Long id) {
        houseDocumentRepository.deleteById(id);
    }

    @Override
    @Transactional
    public Long create(HouseParams params) {
        House house = new House();
        BeanUtils.copyProperties(params, house);
        house.setAdminId(0L);
        house.setArea(0);
        house.setBathroom(0);
        house.setBaiduMapLatitude(0.0);
        house.setBaiduMapLongitude(0.0);
        house.setBuildYear(2007);
        house.setCover("");
        house.setDirection(0);
        house.setCreateTime(new Date());
        house.setLastUpdateTime(new Date());
        house.setDistanceToSubway(0);
        house.setDistrict("");
        house.setFloor(0);
        house.setPrice(1000);
        house.setStatus(0);
        house.setTotalFloor(5);
        house.setWatchTimes(3);
        house.setParlour(0);
        house.setRegionEnName("");
        house.setRoom(4);
        house = houseRepository.save(house); // 房屋被更新

        // updateIndex(house); // 如果这里有错误，索引没有更新， 如果索引更新失败，主流程应该是成功的，因为[暂时]搜索不到是可以接受的，
        // 最终希望的结果是：一定时间后，能够被搜索到，尽可能不去影响主流程
        // 使用异步的方式去更新，即使更新失败，也不影响主流程

        // Thread: 缺点： 如果更新索引失败或者服务过程中宕机
        // Message Queue：缺点：使用复杂。 优点：自带持久化，不断尝试，最终保证一定时间后，一定能够被搜索到
        template.send("house", HouseIndexMessage.update(house.getId()));
        return house.getId();
    }

    @Override
    public void delete(Long id) {
        houseRepository.deleteById(id);
        template.send("house", HouseIndexMessage.remove(id));
    }
}
