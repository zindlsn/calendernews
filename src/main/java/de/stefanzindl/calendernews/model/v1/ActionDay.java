package de.stefanzindl.calendernews.model.v1;

import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.UUID;

/**
 * It represents all information about the event which is happening.
 */
@Entity
public class ActionDay extends AbstractPersistable<Long> {

    @Column(unique = true,nullable = false)
    private UUID actionDayIdentifier;

    /**
     * Day when the action day happens.
     */
    @NotNull
    @Column
    private LocalDate date;

    /**
     * Name of the action-day.
     */
    @NotNull
    @Column
    private String name;

    /**
     * Description of the action-day.
     */
    @Column
    private String description;

    public UUID getActionDayIdentifier() {
        return actionDayIdentifier;
    }

    public void setActionDayIdentifier(UUID actionDayIdentifier) {
        this.actionDayIdentifier = actionDayIdentifier;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
}
