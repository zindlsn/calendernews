package de.stefanzindl.calendernews.repository;

import de.stefanzindl.calendernews.model.v1.ActionDay;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Repository
public interface ActionDayRepository extends JpaRepository<ActionDay,Long> {
    List<ActionDay> findByDate(LocalDate date);
    List<ActionDay> findAllByTopicIdentifiers(List<UUID> topicIdentifiers);
}
