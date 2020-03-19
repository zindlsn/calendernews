package de.stefanzindl.calendernews.boundary.impl;

import de.stefanzindl.calendernews.boundary.ActionDayManagementService;
import de.stefanzindl.calendernews.boundary.converter.ActionDayConverter;
import de.stefanzindl.calendernews.control.ActionDayService;
import de.stefanzindl.calendernews.control.TopicService;
import de.stefanzindl.calendernews.dto.v1.ActionDayDto;
import de.stefanzindl.calendernews.model.v1.ActionDay;
import de.stefanzindl.calendernews.model.v1.Topic;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

/**
 * Managementservice for {@link de.stefanzindl.calendernews.rest.v1.ActionDayControllerV1}.
 */
public class ActionDayManagementServiceImpl implements ActionDayManagementService {

    private final ActionDayService actionDayService;
    private final TopicService topicService;
    private final ActionDayConverter actionDayConverter;

    public ActionDayManagementServiceImpl(ActionDayService actionDayService, TopicService topicService, ActionDayConverter actionDayConverter) {
        this.actionDayService = actionDayService;
        this.topicService = topicService;
        this.actionDayConverter = actionDayConverter;
    }

    @Override
    @Transactional
    public UUID saveActionDay(ActionDayDto actionDayDto) {
        if (Objects.isNull(actionDayDto)) {
            throw new IllegalArgumentException("Can not create an actionDay from a null dto.");
        }

        final ActionDay persistedActionDay = actionDayService.save(actionDayConverter.convertFromDto(actionDayDto));
        final List<Topic> topics = persistedActionDay.getRelatedTopics();
        topics.forEach(topic -> topic.setRelatedDay(persistedActionDay));
        topicService.saveAll(persistedActionDay.getRelatedTopics());

        return persistedActionDay.getActionDayIdentifier();
    }

    @Override
    @Transactional
    public List<ActionDayDto> findAll() {
        return actionDayConverter.convertToDtos(actionDayService.findAll());
    }

    @Override
    @Transactional
    public List<ActionDayDto> getToday() {
        return actionDayConverter.convertToDtos(actionDayService.loadByDate(LocalDate.now()));
    }

    @Override
    @Transactional
    public List<ActionDayDto> getTomorrow() {
        return actionDayConverter.convertToDtos(actionDayService.loadByDate(LocalDate.now().plusDays(1)));
    }

    @Override
    @Transactional
    public ActionDayDto findActionDayByActionDayIdentifier(UUID fromString) {
        ActionDay actionDay = actionDayService.findOneByUuid(fromString);
        if (Objects.nonNull(actionDay)) {
            return actionDayConverter.convertToDto(actionDay);
        } else {
            throw new IllegalArgumentException("Actionday not found");
        }
    }
}
