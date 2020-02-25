package de.stefanzindl.calendernews.boundary;

import de.stefanzindl.calendernews.model.v1.ActionDay;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

public interface ActionDayManagementService {

    UUID saveActionDay(ActionDay actionDay);

    List<ActionDay> saveAll(List<ActionDay> actionDays);

    List<ActionDay> findAll();

    List<ActionDay> getEventsByDate(LocalDate date);

    List<ActionDay> getToday();

    List<ActionDay> getTomorrow();
}
