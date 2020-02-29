package de.stefanzindl.calendernews.boundary;

import de.stefanzindl.calendernews.model.v1.ActionDay;
import de.stefanzindl.calendernews.model.v1.Country;

import java.time.LocalDate;
import java.util.List;
import java.util.Locale;
import java.util.UUID;

public interface CountryManagementService {

    UUID saveCountry(Country country);

    List<Country> saveAll(List<Country> countries);

    List<Country> findAll();

    List<Country> getCountryByCountryCode(Locale countryCode);
}
