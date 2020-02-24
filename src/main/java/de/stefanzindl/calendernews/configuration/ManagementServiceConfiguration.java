package de.stefanzindl.calendernews.configuration;

import de.stefanzindl.calendernews.boundary.CategoryManagementService;
import de.stefanzindl.calendernews.boundary.DaysManagementService;
import de.stefanzindl.calendernews.boundary.impl.CategoryManagementServiceImpl;
import de.stefanzindl.calendernews.boundary.impl.DaysManagementServiceImpl;
import de.stefanzindl.calendernews.control.CategoryService;
import de.stefanzindl.calendernews.control.DayService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ManagementServiceConfiguration {

    @Bean
    public DaysManagementService daysManagementService(DayService  dayService)
    {
        return new DaysManagementServiceImpl(dayService);
    }

    @Bean
    public CategoryManagementService categoryManagementService(CategoryService categoryService){
        return new CategoryManagementServiceImpl(categoryService);
    }
}
