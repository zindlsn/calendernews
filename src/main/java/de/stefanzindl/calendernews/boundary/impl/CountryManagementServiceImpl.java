package de.stefanzindl.calendernews.boundary.impl;

import de.stefanzindl.calendernews.boundary.ActionDayManagementService;
import de.stefanzindl.calendernews.boundary.CountryManagementService;
import de.stefanzindl.calendernews.control.ActionDayService;
import de.stefanzindl.calendernews.control.CountryService;
import de.stefanzindl.calendernews.control.TopicService;
import de.stefanzindl.calendernews.model.v1.ActionDay;
import de.stefanzindl.calendernews.model.v1.Country;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.Locale;
import java.util.UUID;

public class CountryManagementServiceImpl implements CountryManagementService {

    private final CountryService countryService;

    public CountryManagementServiceImpl(CountryService countryService){
        this.countryService = countryService;
    }

    @Override
    @Transactional
    public UUID saveCountry(Country country) {
        if (!country.isNew()) {
            country.setCountryIdentifier(UUID.randomUUID());
        }
        Country persistedCountry = countryService.save(country);
        return persistedCountry.getCountryIdentifier();
    }

    @Override
    public List<Country> saveAll(List<Country> countries) {
        countries.forEach(event -> {
            if (event.isNew()) {
                event.setCountryIdentifier(UUID.randomUUID());
            }
        });
        return countryService.saveAll(countries);
    }

    @Override
    public List<Country> findAll() {
        return countryService.findAll();
    }

    @Override
    public List<Country> getCountryByCountryCode(Locale countryCode) {
        return null;
    }
}
