package de.stefanzindl.calendernews.boundary;

import de.stefanzindl.calendernews.model.v1.Category;

import java.util.List;
import java.util.UUID;

public interface CategoryManagementService {

    UUID saveCategory(Category category);

    List<Category> findAll();
}
