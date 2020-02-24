package de.stefanzindl.calendernews.boundary.impl;

import de.stefanzindl.calendernews.boundary.DaysManagementService;
import de.stefanzindl.calendernews.control.DayService;
import de.stefanzindl.calendernews.model.v1.Day;

import java.util.List;
import java.util.UUID;

public class DaysManagementServiceImpl implements DaysManagementService {
    private final DayService dayService;

    public DaysManagementServiceImpl(DayService dayService) {
        this.dayService = dayService;
    }

    @Override
    public UUID saveDay(Day day) {
        if (day.isNew()) {
            day.setDayIdentifier(UUID.randomUUID());
        }
        Day persistedDay = dayService.save(day);
        return persistedDay.getDayIdentifier();
    }

    @Override
    public List<Day> findAll() {
        return dayService.findAll();
    }
}
