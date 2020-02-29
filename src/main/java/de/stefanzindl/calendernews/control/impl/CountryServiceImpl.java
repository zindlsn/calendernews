package de.stefanzindl.calendernews.control.impl;

import de.stefanzindl.calendernews.control.CountryService;
import de.stefanzindl.calendernews.model.v1.Country;
import de.stefanzindl.calendernews.repository.CountryRepository;

import java.util.List;
import java.util.UUID;

public class CountryServiceImpl implements CountryService {

    private final CountryRepository countryRepository;

    public CountryServiceImpl(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    @Override
    public Country save(Country toSave) {
        return countryRepository.save(toSave);
    }

    @Override
    public List<Country> saveAll(List<Country> toSaveList) {
        return countryRepository.saveAll(toSaveList);
    }

    @Override
    public Country loadByIdentifier(UUID identifier) {
        return countryRepository.findByCountryIdentifier(identifier);
    }

    @Override
    public List<Country> findAll() {
        return countryRepository.findAll();
    }
}
