package de.stefanzindl.calendernews.boundary;

import de.stefanzindl.calendernews.boundary.impl.ActionDayManagementServiceImpl;
import de.stefanzindl.calendernews.dto.v1.ActionDayDto;

import java.util.List;
import java.util.UUID;

/**
 * Interface for {@link ActionDayManagementServiceImpl}
 */
public interface ActionDayManagementService {

    /**
     * Saves an action-day.
     *
     * @param actionDay to save
     * @return its identifier
     */
    UUID saveActionDay(ActionDayDto actionDay);

    /**
     * Finds all saved action-days
     *
     * @return a list of action-days
     */
    List<ActionDayDto> findAll();

    /**
     * Finds all action-days form today.
     *
     * @return a list of action-days
     */
    List<ActionDayDto> getToday();

    /**
     * Finds all action-days form tomorrow.
     *
     * @return a list of action-days
     */
    List<ActionDayDto> getTomorrow();

    /**
     * Finds an action-day by its identifier
     *
     * @param fromString its identifier
     * @return the action-day
     */
    ActionDayDto findActionDayByActionDayIdentifier(UUID fromString);
}
