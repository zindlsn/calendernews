package de.stefanzindl.calendernews.repository;

import de.stefanzindl.calendernews.model.v1.Topic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface TopicRepository extends JpaRepository<Topic, Long> {
}
