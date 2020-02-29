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

    @NotNull
    @Column
    private LocalDate date;

    @NotNull
    @Column
    private String name;

    @Column
    private String description;

//    private List<Country> countries;

//    private List<Topic> topics;

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
