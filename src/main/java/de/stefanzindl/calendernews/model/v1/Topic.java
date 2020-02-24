package de.stefanzindl.calendernews.model.v1;

import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.UUID;

/**
 * Each {@link Event} is categorisied in different subject like
 * food days, fancy day, etc...
 */
@Entity
public class Topic extends AbstractPersistable<Long> implements Serializable {

    @Column(unique = true, nullable = false)
    private UUID subjectIdentifier;

    @Column
    private String name;

    @ManyToMany(mappedBy = "topics", fetch = FetchType.LAZY)
    List<Event> events;

    public UUID getSubjectIdentifier() {
        return subjectIdentifier;
    }

    public void setSubjectIdentifier(UUID subjectIdentifier) {
        this.subjectIdentifier = subjectIdentifier;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Event> getEvents() {
        return events;
    }

    public void setEvents(List<Event> events) {
        this.events = events;
    }
}
