package de.stefanzindl.calendernews.model;

import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Entity
public class Day extends AbstractPersistable<Long> implements Serializable {

    public UUID getDayIdentifier() {
        return dayIdentifier;
    }

    public void setDayIdentifier(UUID dayIdentifier) {
        this.dayIdentifier = dayIdentifier;
    }

    @Column(unique = true, nullable = false,updatable = false)
    private UUID dayIdentifier = UUID.randomUUID();

    @Column
    private String title;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    //    private List<Event> events;

    private LocalDate date;
}
