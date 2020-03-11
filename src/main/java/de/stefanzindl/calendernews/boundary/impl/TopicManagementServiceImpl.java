package de.stefanzindl.calendernews.boundary.impl;

import de.stefanzindl.calendernews.boundary.TopicManagementService;
import de.stefanzindl.calendernews.control.TopicService;
import de.stefanzindl.calendernews.model.v1.Topic;

import java.util.List;
import java.util.Objects;
import java.util.UUID;

/**
 * Impelementation for {@link TopicManagementService}.
 */
public class TopicManagementServiceImpl implements TopicManagementService {

    private final TopicService topicService;

    public TopicManagementServiceImpl(TopicService topicService) {
        this.topicService = topicService;
    }

    @Override
    public UUID saveTopic(Topic topic) {
        if(Objects.isNull(topic)){
            throw new IllegalArgumentException("Can not create a topic from a null object.");
        }
        Topic foundTopic = topicService.findOneByUuid(topic.getTopicIdentifier());
        if(Objects.isNull(foundTopic) || foundTopic.isNew()){
            foundTopic = new Topic();
        }
        foundTopic.setTopicIdentifier(topic.getTopicIdentifier());
        foundTopic.setName(topic.getName());
        Topic persistedTopic = topicService.save(foundTopic);
        return persistedTopic.getTopicIdentifier();
    }

    @Override
    public List<Topic> findAll() {
        return topicService.findAll();
    }

    @Override
    public Topic findTopicByTopicIdentifier(UUID uuid) {
        return topicService.findOneByUuid(uuid);
    }
}
