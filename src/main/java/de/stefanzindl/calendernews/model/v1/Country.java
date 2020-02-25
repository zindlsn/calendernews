package de.stefanzindl.calendernews.model.v1;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.UUID;

/**
 * It is used to specify the {@link ActionDay} in which country its happening.
 * Like national event.
 */
@Entity
public class Country {

    @Column(unique = true, nullable = false)
    private UUID countryIdentifier;

    @NotNull
    @Column
    private String name;

    @ManyToMany(fetch = FetchType.LAZY)
    List<ActionDay> actionDays;

    @Column
    CountryCode countryCode;
}
