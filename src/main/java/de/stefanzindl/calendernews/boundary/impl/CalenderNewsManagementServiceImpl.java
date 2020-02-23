package de.stefanzindl.calendernews.boundary.impl;

import de.stefanzindl.calendernews.boundary.CalenderNewsManagementService;
import de.stefanzindl.calendernews.control.DayService;
import de.stefanzindl.calendernews.model.Day;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

public class CalenderNewsManagementServiceImpl implements CalenderNewsManagementService {
    private final DayService dayService;

    public CalenderNewsManagementServiceImpl(DayService dayService)
    {
        this.dayService = dayService;
    }

    @Override
    public UUID saveDay(Day day) {
     Day persistedDay =  dayService.save(day);
     return persistedDay.getDayIdentifier();
    }
}
