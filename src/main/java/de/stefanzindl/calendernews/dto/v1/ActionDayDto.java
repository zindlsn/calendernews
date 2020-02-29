package de.stefanzindl.calendernews.dto.v1;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.UUID;

/**
 * It represents all information about the action-day which is happening.
 */
public class ActionDayDto implements Serializable {

    private UUID actionDayIdentifier;

    private LocalDate date;

    private String name;

    private String description;

    public UUID getActionDayIdentifier() {
        return actionDayIdentifier;
    }

    public void setActionDayIdentifier(UUID actionDayIdentifier) {
        this.actionDayIdentifier = actionDayIdentifier;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
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
}