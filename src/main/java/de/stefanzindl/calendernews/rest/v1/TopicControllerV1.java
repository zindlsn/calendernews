package de.stefanzindl.calendernews.rest.v1;

import de.stefanzindl.calendernews.boundary.TopicManagementService;
import de.stefanzindl.calendernews.model.v1.Topic;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.UUID;

/**
 * REST controller for topics.
 */
@RestController
@RequestMapping(path = TopicControllerV1.CONTROLLER_PATH)
public class TopicControllerV1 {

    static final String CONTROLLER_PATH = "/v1/topics";

    private final TopicManagementService delegate;

    public TopicControllerV1(TopicManagementService delegate) {
        this.delegate = delegate;
    }

    /**
     * Creates a new topic.
     *
     * @param topic to set
     * @return url of new topic
     */
    @RequestMapping(method = {RequestMethod.POST, RequestMethod.PUT})
    public ResponseEntity<String> createTopic(@RequestBody Topic topic) {

        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(delegate.saveTopic(topic))
                .toUri();

        return ResponseEntity.created(uri).build();
    }

    /**
     * Gets all saved topics.
     *
     * @return list of topics
     */
    @GetMapping(path = "/")
    public List<Topic> getAll() {
        return delegate.findAll();
    }

    /**
     * Gets a {@link Topic} by topicIdentifier.
     *
     * @param id to set
     * @return topic
     */
    @GetMapping("/{id}")
    public Topic get(@PathVariable String id) {
        return delegate.findTopicByTopicIdentifier(UUID.fromString(id));
    }
}
