package de.stefanzindl.calendernews.rest.v1;

import de.stefanzindl.calendernews.boundary.ActionDayManagementService;
import de.stefanzindl.calendernews.dto.v1.ActionDayDto;
import de.stefanzindl.calendernews.model.v1.ActionDay;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.UUID;

/**
 * REST controller for action-days.
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
     * Save or update a action-day.
     * @param actionDayDto to save action-day
     * @return url of saved action-day
     */
    @RequestMapping(method = {RequestMethod.POST, RequestMethod.PUT})
    public ResponseEntity<String> createActionDay(@RequestBody ActionDayDto actionDayDto) {
        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(delegate.saveActionDay(actionDayDto))
                .toUri();

        return ResponseEntity.created(uri).build();
    }

    /**
     * Gets a {@link ActionDayDto} by actonDayIdentifier.
     *
     * @param id to set
     * @return action-day
     */
    @GetMapping("/{id}")
    public ActionDayDto get(@PathVariable String id) {
        return delegate.findActionDayByActionDayIdentifier(UUID.fromString(id));
    }

    /**
     * Get all provided actionDays.
     * @return found action-days
     */
    @GetMapping(path = "/")
    public List<ActionDay> getAll() {
        return delegate.findAll();
    }

    /**
     * Get all action-days from today.
     * @return found action-days
     */
    @GetMapping(path = "/today")
    public List<ActionDay> getAllFromToday(){
        return delegate.getToday();
    }

    /**
     * Get all action-days from tomorrow.
     * @return found action-days
     */
    @GetMapping(path = "/tomorrow")
    public List<ActionDay> getAllFromTomorrow(){
        return delegate.getTomorrow();
    }


}
