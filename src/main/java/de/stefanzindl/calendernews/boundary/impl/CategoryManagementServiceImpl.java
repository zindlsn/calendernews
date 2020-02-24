package de.stefanzindl.calendernews.boundary.impl;

import de.stefanzindl.calendernews.boundary.CategoryManagementService;
import de.stefanzindl.calendernews.control.CategoryService;
import de.stefanzindl.calendernews.model.v1.Category;

import java.util.List;
import java.util.UUID;

public class CategoryManagementServiceImpl implements CategoryManagementService {

    final CategoryService categoryService;


    public CategoryManagementServiceImpl(CategoryService categoryService){
        this.categoryService = categoryService;
    }

    @Override
    public UUID saveCategory(Category category) {
        if(category.isNew()){
            category.setCategoryIdentifier(UUID.randomUUID());
        }
        Category persistedCategory =  categoryService.save(category);
        return persistedCategory.getCategoryIdentifier();
    }

    @Override
    public List<Category> findAll() {
        return categoryService.findAll();
    }
}
