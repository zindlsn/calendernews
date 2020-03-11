package de.stefanzindl.calendernews.control.impl;

import de.stefanzindl.calendernews.control.TopicService;
import de.stefanzindl.calendernews.model.v1.Topic;
import de.stefanzindl.calendernews.repository.TopicRepository;

import java.util.List;
import java.util.UUID;

/**
 * Implementation of topic-service.
 */
public class TopicServiceImpl implements TopicService {

    private final TopicRepository topicRepository;

    public TopicServiceImpl(TopicRepository topicRepository) {
        this.topicRepository = topicRepository;
    }

    @Override
    public Topic save(Topic toSave) {
        if (toSave.isNew()) {
            toSave.setTopicIdentifier(UUID.randomUUID());
        }
        return topicRepository.saveAndFlush(toSave);
    }

    @Override
    public Topic findOneByUuid(UUID identifier) {
        return topicRepository.findByTopicIdentifier(identifier);
    }

    @Override
    public List<Topic> findAll() {
        return topicRepository.findAll();
    }

}
