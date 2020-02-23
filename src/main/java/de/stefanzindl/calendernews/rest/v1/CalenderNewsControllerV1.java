package de.stefanzindl.calendernews.rest.v1;

import de.stefanzindl.calendernews.boundary.CalenderNewsManagementService;
import de.stefanzindl.calendernews.model.Day;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
public class CalenderNewsControllerV1 {

    private final CalenderNewsManagementService delegate;

    public  CalenderNewsControllerV1(CalenderNewsManagementService delegate){
        this.delegate = delegate;
    }

    @RequestMapping(method = {RequestMethod.POST, RequestMethod.PUT})
    public ResponseEntity<String> createDay(@RequestBody Day day)
    {
        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(delegate.saveDay(day))
                .toUri();

        return  ResponseEntity.created(uri).build();
    }
}
