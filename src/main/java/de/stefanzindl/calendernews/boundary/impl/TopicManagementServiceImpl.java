package de.stefanzindl.calendernews.boundary.impl;

import de.stefanzindl.calendernews.boundary.TopicManagementService;
import de.stefanzindl.calendernews.boundary.converter.TopicConverter;
import de.stefanzindl.calendernews.control.TopicService;
import de.stefanzindl.calendernews.dto.v1.TopicDto;
import de.stefanzindl.calendernews.model.v1.Topic;

import java.util.List;
import java.util.Objects;
import java.util.UUID;

/**
 * Impelementation for {@link TopicManagementService}.
 */
public class TopicManagementServiceImpl implements TopicManagementService {

    private final TopicService topicService;
    private final TopicConverter topicConverter;

    public TopicManagementServiceImpl(TopicConverter topicConverter, TopicService topicService) {
        this.topicConverter = topicConverter;
        this.topicService = topicService;
    }

    @Override
    public UUID saveTopic(TopicDto topic) {
        if (Objects.isNull(topic)) {
            throw new IllegalArgumentException("Can not create a topic from a null object.");
        }
        Topic foundTopic = topicService.findOneByUuid(topic.getTopicIdentifier());
        if (Objects.isNull(foundTopic) || foundTopic.isNew()) {
            foundTopic = new Topic();
        }
        foundTopic.setTopicIdentifier(topic.getTopicIdentifier());
        foundTopic.setName(topic.getName());
        Topic persistedTopic = topicService.save(foundTopic);
        return persistedTopic.getTopicIdentifier();
    }

    @Override
    public List<TopicDto> findAll() {
        return topicConverter.convertToDtos(topicService.findAll());
    }

    @Override
    public TopicDto findTopicByTopicIdentifier(UUID identifier) {
        return topicConverter.convertToDto(topicService.findOneByUuid(identifier));
    }
}
