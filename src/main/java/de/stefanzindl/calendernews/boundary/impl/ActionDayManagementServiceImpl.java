package de.stefanzindl.calendernews.boundary.impl;

import de.stefanzindl.calendernews.boundary.ActionDayManagementService;
import de.stefanzindl.calendernews.control.ActionDayService;
import de.stefanzindl.calendernews.model.v1.ActionDay;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

public class ActionDayManagementServiceImpl implements ActionDayManagementService {

    final ActionDayService actionDayService;

    public ActionDayManagementServiceImpl(ActionDayService actionDayService){
        this.actionDayService = actionDayService;
    }

    @Override
    @Transactional
    public UUID saveActionDay(ActionDay actionDay) {
        if(!actionDay.isNew()) {
            actionDay.setActionDayIdentifier(UUID.randomUUID());
        }
        ActionDay persistedActionDay = actionDayService.save(actionDay);
        return persistedActionDay.getActionDayIdentifier();
    }

    @Override
    public List<ActionDay> saveAll(List<ActionDay> actionDays) {
        actionDays.forEach(event -> {
            if(event.isNew()){
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
    public List<ActionDay> getEventsByDate(LocalDate date){
        return actionDayService.loadByDate(date);
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
