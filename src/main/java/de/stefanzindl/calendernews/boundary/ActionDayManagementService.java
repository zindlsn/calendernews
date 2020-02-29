package de.stefanzindl.calendernews.boundary;

import de.stefanzindl.calendernews.dto.v1.ActionDayDto;
import de.stefanzindl.calendernews.model.v1.ActionDay;

import java.util.List;
import java.util.UUID;

/**
 * Interface for {@link de.stefanzindl.calendernews.boundary.impl.ActionDayManagementServiceImpl}
 */
public interface ActionDayManagementService {

    UUID saveActionDay(ActionDayDto actionDay);

    List<ActionDay> findAll();

    List<ActionDay> getToday();

    List<ActionDay> getTomorrow();

    ActionDayDto findActionDayByActionDayIdentifier(UUID fromString);
}
