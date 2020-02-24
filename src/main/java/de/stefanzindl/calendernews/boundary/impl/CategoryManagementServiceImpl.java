package de.stefanzindl.calendernews.boundary.impl;

import de.stefanzindl.calendernews.boundary.CategoryManagementService;
import de.stefanzindl.calendernews.boundary.DaysManagementService;
import de.stefanzindl.calendernews.control.CategoryService;
import de.stefanzindl.calendernews.control.DayService;
import de.stefanzindl.calendernews.model.Category;
import de.stefanzindl.calendernews.model.Day;
import de.stefanzindl.calendernews.repository.CategoryRepository;

import java.util.List;
import java.util.UUID;

public class CategoryManagementServiceImpl implements CategoryManagementService {

    final CategoryService categoryService;


    public CategoryManagementServiceImpl(CategoryService categoryService){
        this.categoryService = categoryService;
    }

    @Override
    public UUID saveCategory(Category category) {
        Category persistedCategory =  categoryService.save(category);
        return persistedCategory.getCategoryIdentifier();
    }

    @Override
    public List<Category> findAll() {
        return categoryService.findAll();
    }
}
