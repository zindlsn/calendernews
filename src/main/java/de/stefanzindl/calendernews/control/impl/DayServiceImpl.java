package de.stefanzindl.calendernews.control.impl;

import de.stefanzindl.calendernews.control.DayService;
import de.stefanzindl.calendernews.model.Day;
import de.stefanzindl.calendernews.repository.DayRepository;

import java.util.List;
import java.util.UUID;

public class DayServiceImpl implements DayService {

    private  final DayRepository dayRepository;

    public DayServiceImpl(DayRepository dayRepository){
        this.dayRepository = dayRepository;
    }

    @Override
    public Day save(Day toSave) {
        return toSave;//dayRepository.saveAndFlush(toSave);
    }

    @Override
    public List<Day> saveAll(List<Day> toSaveList) {
        return null;
    }

    @Override
    public List<Day> loadByIdentifier(UUID identifier) {
        return null;
    }
}
