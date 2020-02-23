package de.stefanzindl.calendernews.boundary;

import de.stefanzindl.calendernews.model.Day;

import java.util.UUID;

public interface CalenderNewsManagementService {

    UUID saveDay(Day day);
}
