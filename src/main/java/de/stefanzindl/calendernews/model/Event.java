package de.stefanzindl.calendernews.model;

import java.util.UUID;

public class Event {
    private UUID eventIdentifier = UUID.randomUUID();
    private String name;
    private String description;
    private Category category;
    private Country country;
}
