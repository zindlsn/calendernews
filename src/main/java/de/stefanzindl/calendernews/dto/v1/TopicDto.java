package de.stefanzindl.calendernews.dto.v1;

import java.io.Serializable;
import java.util.UUID;

/**
 * Each {@link ActionDayDto} is categorisied in different subject like
 * food days, fancy day, etc...
 */
public class TopicDto implements Serializable {

    /**
     * UniqueIdentifier for this topic.
     */
    private UUID topicIdentifier;

    /**
     * Name of the topic.
     */
    private String name;

    public UUID getTopicIdentifier() {
        return topicIdentifier;
    }

    public void setTopicIdentifier(UUID subjectIdentifier) {
        this.topicIdentifier = subjectIdentifier;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
