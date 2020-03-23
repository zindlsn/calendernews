package de.stefanzindl.calendernews.repository;

import de.stefanzindl.calendernews.model.v1.Topic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

/**
 * Repository for {@link Topic}.
 */
@Repository
public interface TopicRepository extends JpaRepository<Topic, Long> {

    /**
     * Find the topic by its identifier.
     *
     * @param topicIdentifier of action-day
     * @return found topic
     */
    Topic findByTopicIdentifier(UUID topicIdentifier);
}
