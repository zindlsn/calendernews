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
    private List<TopicDto> topics;

    public ActionDayDtoBuilder() {
        this.actionDayIdentifier = UUID.fromString("3685cb0c-2f80-4a6c-83cd-0936b08db13f");
        date = LocalDate.of(2020, 3, 22);
        name = "Wassertag";
        this.topics = new ArrayList<>();
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
        actionDayDto.setRelatedTopics(topics);
        return actionDayDto;
    }
}
