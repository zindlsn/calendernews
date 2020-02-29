package de.stefanzindl.calendernews.control;

import de.stefanzindl.calendernews.model.v1.ActionDay;

import java.util.List;
import java.util.UUID;

/**
 * Interface für all services.
 * @param <T>
 */
public interface Service<T> {

    /**
     * Saves T in the database.
     * @param toSave T
     * @return T
     */
    T save(T toSave);

    /**
     * find T by its identifier.
     * @param identifier of T
     * @return T
     */
    T findOneByUuid(UUID identifier);

    /**
     * finds all of T
     * @return List<T>
     */
    List<T>findAll();
}
