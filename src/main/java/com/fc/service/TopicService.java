package com.fc.service;

import com.fc.entity.TopicEnum;
import com.fc.model.TopicDTO;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class TopicService {

    public List<TopicDTO> listTopic() {
        List<TopicDTO> topicDTOList = new ArrayList<>();
        for (TopicEnum te :TopicEnum.values()) {
            topicDTOList.add(TopicDTO.buildTopic(te.getName(), te.getContent(), te.getImage()));
        }
        return topicDTOList;
    }
}

