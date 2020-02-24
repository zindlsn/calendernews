package de.stefanzindl.calendernews.control.impl;

import de.stefanzindl.calendernews.control.CategoryService;
import de.stefanzindl.calendernews.model.Category;
import de.stefanzindl.calendernews.repository.CategoryRepository;
import de.stefanzindl.calendernews.repository.DayRepository;

import java.util.List;
import java.util.UUID;

public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository dayRepository) {
        this.categoryRepository = dayRepository;
    }

    @Override
    public Category save(Category toSave) {
        return categoryRepository.saveAndFlush(toSave);
    }

    @Override
    public List<Category> saveAll(List<Category> toSaveList) {
        return null;
    }

    @Override
    public List<Category> loadByIdentifier(UUID identifier) {
        return null;
    }

    @Override
    public List<Category> findAll() {
        return categoryRepository.findAll();
    }
}
