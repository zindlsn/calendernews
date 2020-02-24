package de.stefanzindl.calendernews.model.v1;

 import org.springframework.data.jpa.domain.AbstractPersistable;

 import javax.persistence.*;
 import javax.validation.constraints.NotNull;
 import java.io.Serializable;
 import java.util.List;
 import java.util.UUID;

/**
 * It represents the category of an {@link Event} like
 * name day, national holiday, etc...
 */
@Entity
public class Category extends AbstractPersistable<Long> implements Serializable {

    @Column(unique = true, nullable = false)
    private UUID categoryIdentifier;

    @NotNull
    @Column
    private String name;

    @OneToMany(mappedBy = "category",fetch = FetchType.LAZY)
    private List<Event> events;

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

    public List<Event> getEvents() {
        return events;
    }

    public void setEvents(List<Event> events) {
        this.events = events;
    }
}
