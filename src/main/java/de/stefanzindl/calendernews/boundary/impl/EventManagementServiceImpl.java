package de.stefanzindl.calendernews.boundary.impl;

import de.stefanzindl.calendernews.boundary.EventManagementService;
import de.stefanzindl.calendernews.control.CategoryService;
import de.stefanzindl.calendernews.control.EventService;
import de.stefanzindl.calendernews.model.v1.Event;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

public class EventManagementServiceImpl implements EventManagementService {

    final EventService eventService;
    final CategoryService categoryService;

    public EventManagementServiceImpl(EventService eventService, CategoryService categoryService){
        this.eventService = eventService;
        this.categoryService =categoryService;
    }

    @Override
    @Transactional
    public UUID saveEvent(Event event) {
        if(!event.isNew()) {
            event.setEventIdentifier(UUID.randomUUID());
        }
        Event persistedEvent = eventService.save(event);
        categoryService.save(persistedEvent.getCategory());
        return persistedEvent.getEventIdentifier();
    }

    @Override
    public List<Event> saveAll(List<Event> events) {
        events.forEach(event -> {
            if(event.isNew()){
                event.setEventIdentifier(UUID.randomUUID());
            }
        });
        return eventService.saveAll(events);
    }

    @Override
    public List<Event> findAll() {
        return eventService.findAll();
    }
}
