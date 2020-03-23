package de.stefanzindl.calendernews.boundary.converter;

import de.stefanzindl.calendernews.control.ActionDayService;
import de.stefanzindl.calendernews.control.TopicService;
import de.stefanzindl.calendernews.dto.v1.ActionDayDto;
import de.stefanzindl.calendernews.model.v1.ActionDay;
import de.stefanzindl.calendernews.util.dto.ActionDayDtoBuilder;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * Converter for action-days.
 */
public class ActionDayConverter {

    private final TopicService topicService;
    private final TopicConverter topicConverter;
    private final ActionDayService actionDayService;

    public ActionDayConverter(ActionDayService actionDayService, TopicService topicService, TopicConverter topicConverter) {
        this.actionDayService = actionDayService;
        this.topicService = topicService;
        this.topicConverter = topicConverter;
    }

    /**
     * Convert a list of entities to dtos.
     *
     * @param actionDays entities to convert
     * @return dtos
     */
    public List<ActionDayDto> convertToDtos(List<ActionDay> actionDays) {
        return actionDays.stream().map(this::convertToDto).collect(Collectors.toList());
    }

    /**
     * Convert to dto.
     *
     * @param actionDay entity to convert
     * @return dto
     */
    public ActionDayDto convertToDto(ActionDay actionDay) {
        return ActionDayDtoBuilder.instance()
                .withActionDayIdentifier(actionDay.getActionDayIdentifier())
                .withTopicDtos(topicConverter.convertToDtos(actionDay.getRelatedTopics()))
                .withDate(actionDay.getDate())
                .withDescription(actionDay.getDescription())
                .withName(actionDay.getName())
                .build();
    }

    /**
     * Convert from dto.
     *
     * @param actionDayDto dto to convert
     * @return entity
     */
    public ActionDay convertFromDto(ActionDayDto actionDayDto) {
        ActionDay actionDay = actionDayService.findOneByUuid(actionDayDto.getActionDayIdentifier());
        if (Objects.isNull(actionDay) || actionDay.isNew()) {
            actionDay = new ActionDay();
            actionDay.setActionDayIdentifier(actionDayDto.getActionDayIdentifier());
        }
        actionDay.setName(actionDayDto.getName());
        actionDay.setDate(actionDayDto.getDate());
        actionDay.setDescription(actionDayDto.getDescription());
        actionDay.setRelatedTopics(topicConverter.convertFromDtos(actionDayDto.getRelatedTopics()));

        return actionDay;
    }
}
