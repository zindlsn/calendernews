package de.stefanzindl.calendernews.control;

import de.stefanzindl.calendernews.model.v1.Topic;

import java.util.List;
import java.util.UUID;

/**
 * Interface für all services.
 *
 * @param <T>
 */
public interface Service<T> {

    /**
     * Saves T in the database.
     *
     * @param toSave T toSave
     * @return T savedObject
     */
    T save(T toSave);

    /**
     * Find T by its identifier.
     *
     * @param identifier of T
     * @return T found T
     */
    T findOneByUuid(UUID identifier);

    /**
     * Finds all of T.
     *
     * @return a list of T
     */
    List<T> findAll();

    /**
     * Save all T in database.
     * @param toSave List of T
     * @return saved List of T
     */
    List<T> saveAll(List<T> toSave);
}
