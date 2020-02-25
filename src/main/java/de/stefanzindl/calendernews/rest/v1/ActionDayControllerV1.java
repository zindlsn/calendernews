package de.stefanzindl.calendernews.rest.v1;

import de.stefanzindl.calendernews.boundary.ActionDayManagementService;
import de.stefanzindl.calendernews.model.v1.ActionDay;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

/**
 * REST controller for events.
 */
@RestController
@RequestMapping(path = ActionDayControllerV1.CONTROLLER_PATH)
public class ActionDayControllerV1 {


    public static final String CONTROLLER_PATH = "/v1/actiondays";


    private final ActionDayManagementService delegate;

    public ActionDayControllerV1(ActionDayManagementService delegate) {
        this.delegate = delegate;
    }

    /**
     * Save or update a day.
     * @param actionDay
     * @return
     */
    @RequestMapping(method = {RequestMethod.POST, RequestMethod.PUT})
    public ResponseEntity<String> createActionDay(@RequestBody ActionDay actionDay) {
        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(delegate.saveActionDay(actionDay))
                .toUri();

        return ResponseEntity.created(uri).build();
    }

    /**
     * Get all provided events.
     * @return
     */
    @GetMapping(path = "/")
    public List<ActionDay> getActionDays() {
        return delegate.findAll();
    }

    @GetMapping(path = "/today")
    public List<ActionDay> getToday(){
        return delegate.getToday();
    }

    @GetMapping(path = "/tomorrow")
    public List<ActionDay> getTomorrow(){
        return delegate.getTomorrow();
    }


}
