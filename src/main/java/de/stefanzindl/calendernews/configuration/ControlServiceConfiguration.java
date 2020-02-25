package de.stefanzindl.calendernews.configuration;

import de.stefanzindl.calendernews.control.CategoryService;
import de.stefanzindl.calendernews.control.ActionDayService;
import de.stefanzindl.calendernews.control.TopicService;
import de.stefanzindl.calendernews.control.impl.CategoryServiceImpl;
import de.stefanzindl.calendernews.control.impl.ActionDayServiceImpl;
import de.stefanzindl.calendernews.control.impl.TopicServiceImpl;
import de.stefanzindl.calendernews.repository.CategoryRepository;
import de.stefanzindl.calendernews.repository.ActionDayRepository;
import de.stefanzindl.calendernews.repository.TopicRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ControlServiceConfiguration {

    @Bean
    public CategoryService categoryService(CategoryRepository categoryRepository) {
        return new CategoryServiceImpl(categoryRepository);
    }

    @Bean
    public ActionDayService eventService(ActionDayRepository actionDayRepository) {
        return new ActionDayServiceImpl(actionDayRepository);
    }

    @Bean
    public TopicService topicService(TopicRepository topicRepository) {
        return new TopicServiceImpl(topicRepository);
    }
}
