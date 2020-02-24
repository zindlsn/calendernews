package de.stefanzindl.calendernews.model.v1;

import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.Column;
import javax.persistence.Entity;
import java.io.Serializable;
import java.util.UUID;

/**
 * It represents the category of an {@link Event} like
 * name day, national holiday, etc...
 */
@Entity
public class Category extends AbstractPersistable<Long> implements Serializable {

    @Column(unique = true, nullable = false)
    private UUID categoryIdentifier;
    private String name;

    public UUID getCategoryIdentifier() {
        return categoryIdentifier;
    }

    public void setCategoryIdentifier(UUID categoryIdentifier) {
        this.categoryIdentifier = categoryIdentifier;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
