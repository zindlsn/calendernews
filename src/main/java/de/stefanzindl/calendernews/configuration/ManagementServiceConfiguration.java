package de.stefanzindl.calendernews.configuration;

import de.stefanzindl.calendernews.boundary.CategoryManagementService;
import de.stefanzindl.calendernews.boundary.ActionDayManagementService;
import de.stefanzindl.calendernews.boundary.TopicManagementService;
import de.stefanzindl.calendernews.boundary.impl.CategoryManagementServiceImpl;
import de.stefanzindl.calendernews.boundary.impl.ActionDayManagementServiceImpl;
import de.stefanzindl.calendernews.boundary.impl.TopicManagementServiceImpl;
import de.stefanzindl.calendernews.control.CategoryService;
import de.stefanzindl.calendernews.control.ActionDayService;
import de.stefanzindl.calendernews.control.TopicService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ManagementServiceConfiguration {

    @Bean
    public CategoryManagementService categoryManagementService(CategoryService categoryService){
        return new CategoryManagementServiceImpl(categoryService);
    }

    @Bean
    public ActionDayManagementService eventManagementService(ActionDayService actionDayService, CategoryService categoryService){
        return new ActionDayManagementServiceImpl(actionDayService,categoryService);
    }

    @Bean
    public TopicManagementService topicManagementService(TopicService topicService){
        return new TopicManagementServiceImpl(topicService);
    }
}
