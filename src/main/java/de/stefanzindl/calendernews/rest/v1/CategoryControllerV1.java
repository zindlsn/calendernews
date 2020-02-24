package de.stefanzindl.calendernews.rest.v1;

import de.stefanzindl.calendernews.boundary.CategoryManagementService;
import de.stefanzindl.calendernews.boundary.DaysManagementService;
import de.stefanzindl.calendernews.model.Category;
import de.stefanzindl.calendernews.model.Day;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(path = CategoryControllerV1.CONTROLLER_PATH)
public class CategoryControllerV1 {


    public static final String CONTROLLER_PATH = "/v1/categories";


    private final CategoryManagementService delegate;

    public CategoryControllerV1(CategoryManagementService delegate) {
        this.delegate = delegate;
    }

    @RequestMapping(method = {RequestMethod.POST, RequestMethod.PUT})
    public ResponseEntity<String> createCategory(@RequestBody Category category) {

        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(delegate.saveCategory(category))
                .toUri();

        return ResponseEntity.created(uri).build();
    }

    @GetMapping(path = "/")
    public List<Category> getCategories() {
        return delegate.findAll();
    }
}
