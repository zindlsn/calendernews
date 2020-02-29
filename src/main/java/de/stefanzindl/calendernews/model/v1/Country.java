package de.stefanzindl.calendernews.model.v1;

import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;
import java.util.Locale;
import java.util.UUID;

/**
 * It is used to specify the {@link ActionDay} in which country its happening.
 * Like national event.
 */
@Entity
public class Country extends AbstractPersistable<Country> implements Serializable {

    @Column(unique = true, nullable = false)
    private UUID countryIdentifier;

    @NotNull
    @Column
    private String internationalName;

//    List<ActionDay> actionDays;

    @Column
    Locale countryCode;

    public UUID getCountryIdentifier() {
        return countryIdentifier;
    }

    public void setCountryIdentifier(UUID countryIdentifier) {
        this.countryIdentifier = countryIdentifier;
    }

    public String getInternationalName() {
        return internationalName;
    }

    public void setInternationalName(String internationalName) {
        this.internationalName = internationalName;
    }

    public Locale getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(Locale countryCode) {
        this.countryCode = countryCode;
    }
}
