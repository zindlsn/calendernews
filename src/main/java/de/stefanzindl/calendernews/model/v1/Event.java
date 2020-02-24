package de.stefanzindl.calendernews.model.v1;

import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.UUID;

/**
 * It represents all information about the event which is happening.
 */
@Entity
public class Event extends AbstractPersistable<Long> {

    @Column(unique = true,nullable = false)
    private UUID eventIdentifier;
    @NotNull
    private String name;
    private String description;

    @NotNull
    @OneToOne
    private Category category;

    @OneToOne
    private Country country;

    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Day dayOfEvent;

    public UUID getEventIdentifier() {
        return eventIdentifier;
    }

    public void setEventIdentifier(UUID eventIdentifier) {
        this.eventIdentifier = eventIdentifier;
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

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public Day getDayOfEvent() {
        return dayOfEvent;
    }

    public void setDayOfEvent(Day dayOfEvent) {
        this.dayOfEvent = dayOfEvent;
    }
}
