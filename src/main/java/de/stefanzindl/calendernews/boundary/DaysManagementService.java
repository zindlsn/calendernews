package de.stefanzindl.calendernews.boundary;

import de.stefanzindl.calendernews.model.v1.Day;

import java.util.List;
import java.util.UUID;

public interface DaysManagementService {

    UUID saveDay(Day day);
    List<Day> findAll();
}
