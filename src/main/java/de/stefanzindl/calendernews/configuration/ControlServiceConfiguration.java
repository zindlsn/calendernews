package de.stefanzindl.calendernews.configuration;

import de.stefanzindl.calendernews.control.CategoryService;
import de.stefanzindl.calendernews.control.DayService;
import de.stefanzindl.calendernews.control.impl.CategoryServiceImpl;
import de.stefanzindl.calendernews.control.impl.DayServiceImpl;
import de.stefanzindl.calendernews.repository.CategoryRepository;
import de.stefanzindl.calendernews.repository.DayRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ControlServiceConfiguration {

    @Bean
    public DayService dayService(DayRepository dayRepository) {
        return new DayServiceImpl(dayRepository);
    }

    @Bean
    public CategoryService categoryService(CategoryRepository categoryRepository) {
        return new CategoryServiceImpl(categoryRepository);
    }
}
