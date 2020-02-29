package de.stefanzindl.calendernews.boundary;

import de.stefanzindl.calendernews.model.v1.Topic;

import java.util.List;
import java.util.UUID;

public interface TopicManagementService {

    UUID saveTopic(Topic topic);
    List<Topic> findAll();
}
