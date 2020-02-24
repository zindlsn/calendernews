package de.stefanzindl.calendernews.rest.v1;

import de.stefanzindl.calendernews.boundary.DaysManagementService;
import de.stefanzindl.calendernews.model.v1.Day;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

/**
 * REST controller for days.
 */
@RestController
@RequestMapping(path = DayControllerV1.CONTROLLER_PATH)
public class DayControllerV1 {


    public static final String CONTROLLER_PATH = "/v1/days";


    private final DaysManagementService delegate;

    public DayControllerV1(DaysManagementService delegate) {
        this.delegate = delegate;
    }

    /**
     * Save or update a day.
     * @param day
     * @return
     */
    @RequestMapping(method = {RequestMethod.POST, RequestMethod.PUT})
    public ResponseEntity<String> createDay(@RequestBody Day day) {
        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(delegate.saveDay(day))
                .toUri();

        return ResponseEntity.created(uri).build();
    }

    /**
     * Get all provided days.
     * @return
     */
    @GetMapping(path = "/")
    public List<Day> getDays() {
        return delegate.findAll();
    }
}
