package de.stefanzindl.calendernews.boundary;

import de.stefanzindl.calendernews.control.Service;
import de.stefanzindl.calendernews.model.Category;
import de.stefanzindl.calendernews.model.Day;

import java.util.List;
import java.util.UUID;

public interface CategoryManagementService {

    UUID saveCategory(Category category);

    List<Category> findAll();
}
