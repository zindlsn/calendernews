package de.stefanzindl.calendernews.boundary;

import de.stefanzindl.calendernews.dto.v1.ActionDayDto;

import java.util.List;
import java.util.UUID;

/**
 * Interface for {@link de.stefanzindl.calendernews.boundary.impl.ActionDayManagementServiceImpl}
 */
public interface ActionDayManagementService {

    UUID saveActionDay(ActionDayDto actionDay);

    List<ActionDayDto> findAll();

    List<ActionDayDto> getToday();

    List<ActionDayDto> getTomorrow();

    ActionDayDto findActionDayByActionDayIdentifier(UUID fromString);
}
