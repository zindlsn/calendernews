package de.stefanzindl.calendernews.util.dto;

import de.stefanzindl.calendernews.dto.v1.TopicDto;

import java.util.UUID;

/**
 * Builder for topic-dto.
 */
public class TopicDtoBuilder {

    private UUID topicIdentifier;
    private String name;

    public TopicDtoBuilder() {
        topicIdentifier = UUID.fromString("d8396034-273f-44da-9551-1ce95977cdcb");
        name = "Umwelt";
    }

    public UUID getTopicIdentifier() {
        return topicIdentifier;
    }

    public TopicDtoBuilder withActionDayIdentifier(UUID actionDayIdentifier) {
        this.topicIdentifier = actionDayIdentifier;
        return this;
    }

    public String getName() {
        return name;
    }

    public TopicDtoBuilder withName(String name) {
        this.name = name;
        return this;
    }

    /**
     * Builds the dto.
     *
     * @return topicDto
     */
    public TopicDto build() {
        TopicDto topicDto = new TopicDto();
        topicDto.setTopicIdentifier(this.topicIdentifier);
        topicDto.setName(this.name);
        return topicDto;
    }
}
