package de.stefanzindl.calendernews.control;

import java.util.List;
import java.util.UUID;

public interface Service<T> {

    T save(T toSave);
    List<T> saveAll(List<T> toSaveList);
    List<T>loadByIdentifier(UUID identifier);
    List<T>findAll();
}
