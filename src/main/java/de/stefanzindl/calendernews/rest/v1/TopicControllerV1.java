package de.stefanzindl.calendernews.rest.v1;

import de.stefanzindl.calendernews.boundary.TopicManagementService;
import de.stefanzindl.calendernews.model.v1.Topic;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

/**
 * REST controller for categories.
 */
@RestController
@RequestMapping(path = TopicControllerV1.CONTROLLER_PATH)
public class TopicControllerV1 {


    public static final String CONTROLLER_PATH = "/v1/topics";


    private final TopicManagementService delegate;

    public TopicControllerV1(TopicManagementService delegate) {
        this.delegate = delegate;
    }

    @RequestMapping(method = {RequestMethod.POST, RequestMethod.PUT})
    public ResponseEntity<String> createCategory(@RequestBody Topic topic) {

        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(delegate.saveTopic(topic))
                .toUri();

        return ResponseEntity.created(uri).build();
    }

    @GetMapping(path = "/")
    public List<Topic> getTopics() {
        return delegate.findAll();
    }

    @GetMapping(path = "/{countryCode}")
    public List<Topic> getTopics(@PathVariable String countryCode) {
        return delegate.findEventsByCountryCode(countryCode);
    }
}
