package de.stefanzindl.calendernews.model.v1;

import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.UUID;

/**
 * Each {@link ActionDay} is categorisied in different subject like
 * food days, fancy day, etc...
 */
@Entity
public class Topic extends AbstractPersistable<Long> implements Serializable {

    @Column(unique = true, nullable = false)
    private UUID topicIdentifier;

    @Column
    private String name;

//    List<ActionDay> actionDays;

    public UUID getTopicIdentifier() {
        return topicIdentifier;
    }

    public void setTopicIdentifier(UUID subjectIdentifier) {
        this.topicIdentifier = subjectIdentifier;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
