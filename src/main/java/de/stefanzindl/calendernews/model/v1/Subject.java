package de.stefanzindl.calendernews.model.v1;

import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.Column;
import javax.persistence.Entity;
import java.io.Serializable;
import java.util.UUID;

/**
 * Each {@link Event} is categorisied in different subject like
 * food days, fancy day, etc...
 */
@Entity
public class Subject extends AbstractPersistable<Long> implements Serializable {

    @Column(unique = true, nullable = false)
    private UUID subjectIdentifier;

    @Column
    private String name;
}
