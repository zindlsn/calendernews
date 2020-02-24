package de.stefanzindl.calendernews.model.v1;

import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

/**
 * It represents a day of the year and contains all {@link Event} which are happening
 * on that day.
 */
@Entity
public class Day extends AbstractPersistable<Long> implements Serializable {

    @Column(unique = true, nullable = false,updatable = false)
    private UUID dayIdentifier;

    @Column
    private String title;

    @OneToMany(mappedBy = "dayOfEvent", fetch = FetchType.LAZY)
    private List<Event> events;

    @Column
    private LocalDate date;

    public UUID getDayIdentifier() {
        return dayIdentifier;
    }

    public void setDayIdentifier(UUID dayIdentifier) {
        this.dayIdentifier = dayIdentifier;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }


}
