package de.stefanzindl.calendernews.boundary.impl;

import de.stefanzindl.calendernews.boundary.TopicManagementService;
import de.stefanzindl.calendernews.control.TopicService;
import de.stefanzindl.calendernews.model.v1.Topic;

import java.util.List;
import java.util.UUID;

public class TopicManagementServiceImpl implements TopicManagementService {

    final TopicService topicService;

    public TopicManagementServiceImpl(TopicService topicService) {
        this.topicService = topicService;
    }

    @Override
    public UUID saveTopic(Topic topic) {
        if (topic.isNew()) {
            topic.setTopicIdentifier(UUID.randomUUID());
        }
        Topic persistedTopic = topicService.save(topic);
        return persistedTopic.getTopicIdentifier();
    }

    @Override
    public List<Topic> findAll() {
        return topicService.findAll();
    }
}
