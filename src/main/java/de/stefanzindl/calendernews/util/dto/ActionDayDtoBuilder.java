package de.stefanzindl.calendernews.util.dto;

import de.stefanzindl.calendernews.dto.v1.ActionDayDto;
import de.stefanzindl.calendernews.dto.v1.TopicDto;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Builder for action-day-dto.
 */
public class ActionDayDtoBuilder {

    private UUID actionDayIdentifier;
    private String name;
    private LocalDate date;
    private String description;
    private List<TopicDto> topics;

    private ActionDayDtoBuilder() {
        this.actionDayIdentifier = UUID.fromString("3e8162a5-c555-4d8b-a6a3-87c7a2ed75ae");
        date = LocalDate.of(2020, 3, 22);
        name = "Wassertag";
        this.topics = new ArrayList<>();
    }

    public static ActionDayDtoBuilder instance() {
        return new ActionDayDtoBuilder();
    }

    public UUID getActionDayIdentifier() {
        return actionDayIdentifier;
    }

    public ActionDayDtoBuilder withActionDayIdentifier(UUID actionDayIdentifier) {
        this.actionDayIdentifier = actionDayIdentifier;
        return this;
    }

    public String getName() {
        return name;
    }

    public ActionDayDtoBuilder withName(String name) {
        this.name = name;
        return this;
    }

    public LocalDate getDate() {
        return date;
    }

    public ActionDayDtoBuilder withDate(LocalDate date) {
        this.date = date;
        return this;
    }

    public List<TopicDto> getTopics() {
        return topics;
    }

    public ActionDayDtoBuilder withTopicDtos(List<TopicDto> topicDtos) {
        this.topics = topicDtos;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public ActionDayDtoBuilder withDescription(String description) {
        this.description = description;
        return this;
    }

    /**
     * Builds to dto.
     *
     * @return dto
     */
    public ActionDayDto build() {
        ActionDayDto actionDayDto = new ActionDayDto();
        actionDayDto.setActionDayIdentifier(this.actionDayIdentifier);
        actionDayDto.setName(this.name);
        actionDayDto.setDate(this.date);
        actionDayDto.setDescription(this.description);
        actionDayDto.setRelatedTopics(topics);
        return actionDayDto;
    }
}
