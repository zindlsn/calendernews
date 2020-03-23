package de.stefanzindl.calendernews.repository;

import de.stefanzindl.calendernews.model.v1.ActionDay;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

/**
 * Repository for {@link ActionDay}.
 */
@Repository
public interface ActionDayRepository extends JpaRepository<ActionDay, Long> {

    /**
     * Find all Action-days from a specific date.
     *
     * @param date of action-day
     * @return found action-days
     */
    List<ActionDay> findByDate(LocalDate date);

    /**
     * Find the action-day by its identifier.
     *
     * @param actionDayIdentifier of action-day
     * @return found action-day
     */
    ActionDay findByActionDayIdentifier(UUID actionDayIdentifier);
}
