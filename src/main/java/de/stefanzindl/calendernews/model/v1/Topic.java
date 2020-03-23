package de.stefanzindl.calendernews.model.v1;

import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import java.util.UUID;

/**
 * Each {@link ActionDay} is categorisied in different subject like
 * food days, fancy day, etc...
 */
@Entity
public class Topic extends AbstractPersistable<Long> {

    /**
     * UniqueIdentifier for this topic.
     */
    @Column(unique = true, nullable = false)
    private UUID topicIdentifier;

    /**
     * Name of the topic.
     */
    @Column
    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    private ActionDay relatedDay;

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

    public ActionDay getRelatedDay() {
        return relatedDay;
    }

    public void setRelatedDay(ActionDay relatedDay) {
        this.relatedDay = relatedDay;
    }
}
