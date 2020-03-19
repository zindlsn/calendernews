package de.stefanzindl.calendernews.boundary;

import de.stefanzindl.calendernews.dto.v1.TopicDto;
import de.stefanzindl.calendernews.model.v1.Topic;

import java.util.List;
import java.util.UUID;

/**
 * ManagementService for {@link Topic}.
 */
public interface TopicManagementService {

    /**
     * Saves a new topic.
     * @param topic toSave
     * @return its uniqueIdentifier
     */
    UUID saveTopic(TopicDto topic);

    /**
     * find all saved topics.
     * @return list of topics
     */
    List<TopicDto> findAll();

    /**
     * Finds a Topic by its identifier.
     *
     * @param uuid identifier
     * @return dto
     */
    TopicDto findTopicByTopicIdentifier(UUID uuid);
}
