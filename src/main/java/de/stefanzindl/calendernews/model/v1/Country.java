package de.stefanzindl.calendernews.model.v1;

import javax.persistence.Entity;
import java.util.UUID;

/**
 * It is used to specify the {@link Event} in which country its happening.
 * Like national event.
 */
@Entity
public class Country {
    private UUID countryIdentifier;
    private String name;
}
