package de.stefanzindl.calendernews.model.v1;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.UUID;

/**
 * It is used to specify the {@link Event} in which country its happening.
 * Like national event.
 */
@Entity
public class Country {

    @Column(unique = true, nullable = false)
    private UUID countryIdentifier;

    @NotNull
    @Column
    private String name;

    @OneToMany(mappedBy = "country",fetch = FetchType.LAZY)
    List<Event> events;
}
