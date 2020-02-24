package de.stefanzindl.calendernews.control.impl;

import de.stefanzindl.calendernews.control.EventService;
import de.stefanzindl.calendernews.model.v1.Event;
import de.stefanzindl.calendernews.repository.EventRepository;

import java.util.List;
import java.util.UUID;

public class EventServiceImpl implements EventService {

    EventRepository eventRepository;

    public EventServiceImpl(EventRepository eventRepository){
        this.eventRepository = eventRepository;
    }

    @Override
    public Event save(Event toSave) {
        return eventRepository.save(toSave);
    }

    @Override
    public List<Event> saveAll(List<Event> toSaveList) {
        return eventRepository.saveAll(toSaveList);
    }

    @Override
    public List<Event> loadByIdentifier(UUID identifier) {
        return null;
    }

    @Override
    public List<Event> findAll() {
        return eventRepository.findAll();
    }
}
