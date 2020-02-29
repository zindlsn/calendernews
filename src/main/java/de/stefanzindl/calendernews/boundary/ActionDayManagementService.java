package de.stefanzindl.calendernews.boundary;

import de.stefanzindl.calendernews.dto.ActionDayDto;
import de.stefanzindl.calendernews.model.v1.ActionDay;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

public interface ActionDayManagementService {

    UUID saveActionDay(ActionDayDto actionDay);

    List<ActionDay> findAll();

    List<ActionDay> getToday();

    List<ActionDay> getTomorrow();

    ActionDayDto findActionDayByActionDayIdentifier(UUID fromString);
}
