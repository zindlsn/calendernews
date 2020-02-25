package de.stefanzindl.calendernews.control.impl;

import de.stefanzindl.calendernews.control.CategoryService;
import de.stefanzindl.calendernews.control.TopicService;
import de.stefanzindl.calendernews.model.v1.Category;
import de.stefanzindl.calendernews.model.v1.Topic;
import de.stefanzindl.calendernews.repository.CategoryRepository;
import de.stefanzindl.calendernews.repository.TopicRepository;

import java.util.List;
import java.util.UUID;

public class TopicServiceImpl implements TopicService {

    private final TopicRepository topicRepository;

    public TopicServiceImpl(TopicRepository topicRepository) {
        this.topicRepository = topicRepository;
    }

    @Override
    public Topic save(Topic toSave) {
        return topicRepository.saveAndFlush(toSave);
    }

    @Override
    public List<Topic> saveAll(List<Topic> toSaveList) {
        return null;
    }

    @Override
    public List<Topic> loadByIdentifier(UUID identifier) {
        return null;
    }

    @Override
    public List<Topic> findAll() {
        return topicRepository.findAll();
    }
}
