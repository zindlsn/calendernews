package de.stefanzindl.calendernews.boundary;

import de.stefanzindl.calendernews.model.v1.Event;

import java.util.List;
import java.util.UUID;

public interface EventManagementService {

    UUID saveEvent(Event event);
    List<Event> saveAll(List<Event> events);

    List<Event> findAll();
}
