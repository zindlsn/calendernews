package de.stefanzindl.calendernews.boundary.impl;

import de.stefanzindl.calendernews.boundary.ActionDayManagementService;
import de.stefanzindl.calendernews.control.ActionDayService;
import de.stefanzindl.calendernews.control.TopicService;
import de.stefanzindl.calendernews.model.v1.ActionDay;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

public class ActionDayManagementServiceImpl implements ActionDayManagementService {

    final ActionDayService actionDayService;
    final TopicService topicService;

    public ActionDayManagementServiceImpl(ActionDayService actionDayService, TopicService topicService) {
        this.actionDayService = actionDayService;
        this.topicService = topicService;
    }

    @Override
    @Transactional
    public UUID saveActionDay(ActionDay actionDay) {
        if (!actionDay.isNew()) {
            actionDay.setActionDayIdentifier(UUID.randomUUID());
        }
        ActionDay persistedActionDay = actionDayService.save(actionDay);
        topicService.saveAll(persistedActionDay.getTopics());
        return persistedActionDay.getActionDayIdentifier();
    }

    @Override
    public List<ActionDay> saveAll(List<ActionDay> actionDays) {
        actionDays.forEach(event -> {
            if (event.isNew()) {
                event.setActionDayIdentifier(UUID.randomUUID());
            }
        });
        return actionDayService.saveAll(actionDays);
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
}
