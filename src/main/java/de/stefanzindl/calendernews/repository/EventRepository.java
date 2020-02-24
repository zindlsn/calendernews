package de.stefanzindl.calendernews.repository;

import de.stefanzindl.calendernews.model.v1.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventRepository extends JpaRepository<Event,Long> {
}
