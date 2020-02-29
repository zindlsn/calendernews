package de.stefanzindl.calendernews.boundary.impl;

import de.stefanzindl.calendernews.boundary.ActionDayManagementService;
import de.stefanzindl.calendernews.control.ActionDayService;
import de.stefanzindl.calendernews.control.TopicService;
import de.stefanzindl.calendernews.dto.ActionDayDto;
import de.stefanzindl.calendernews.model.v1.ActionDay;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

public class ActionDayManagementServiceImpl implements ActionDayManagementService {

    final ActionDayService actionDayService;
    final TopicService topicService;

    public ActionDayManagementServiceImpl(ActionDayService actionDayService, TopicService topicService) {
        this.actionDayService = actionDayService;
        this.topicService = topicService;
    }

    @Override
    public UUID saveActionDay(ActionDayDto actionDayDto) {
        if(Objects.isNull(actionDayDto)){
            throw new IllegalArgumentException("Can not create an actionDay from a null dto.");
        }
        ActionDay actionDay = actionDayService.findOneByUuid(actionDayDto.getActionDayIdentifier());
        if(Objects.isNull(actionDay)|| actionDay.isNew()){
            actionDay = new ActionDay();
            actionDay.setActionDayIdentifier(actionDayDto.getActionDayIdentifier());
            actionDay.setName(actionDayDto.getName());
            actionDay.setDescription(actionDayDto.getDescription());
            ActionDay persistedActionDay = actionDayService.save(actionDay);
            return persistedActionDay.getActionDayIdentifier();
        }
        return actionDay.getActionDayIdentifier();
    }

    @Override
    public List<ActionDay> findAll() {
        return actionDayService.findAll();
    }

    @Override
    public List<ActionDay> getToday() {
        return actionDayService.loadByDate(LocalDate.now());
    }

    @Override
    public List<ActionDay> getTomorrow() {
        return actionDayService.loadByDate(LocalDate.now().plusDays(1));
    }

    @Override
    @Transactional
    public ActionDayDto findActionDayByActionDayIdentifier(UUID fromString) {
        ActionDay actionDay =  actionDayService.findOneByUuid(fromString);
        ActionDayDto actionDayDto = new ActionDayDto();
        actionDayDto.setActionDayIdentifier(actionDay.getActionDayIdentifier());
        actionDayDto.setName(actionDay.getName());
        actionDayDto.setDescription(actionDay.getDescription());
        return actionDayDto;
    }
}
