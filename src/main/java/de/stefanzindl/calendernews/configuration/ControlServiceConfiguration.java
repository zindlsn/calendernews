package de.stefanzindl.calendernews.configuration;

import de.stefanzindl.calendernews.control.ActionDayService;
import de.stefanzindl.calendernews.control.TopicService;
import de.stefanzindl.calendernews.control.impl.ActionDayServiceImpl;
import de.stefanzindl.calendernews.control.impl.TopicServiceImpl;
import de.stefanzindl.calendernews.repository.ActionDayRepository;
import de.stefanzindl.calendernews.repository.TopicRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Configuration for all services.
 */
@Configuration
public class ControlServiceConfiguration {

    /**
     * Service for action-days.
     *
     * @param actionDayRepository repository
     * @return Implementation
     */
    @Bean
    public ActionDayService actionDayService(ActionDayRepository actionDayRepository) {
        return new ActionDayServiceImpl(actionDayRepository);
    }

    /**
     * Service for topics.
     *
     * @param topicRepository topicRepository
     * @return implementation
     */
    @Bean
    public TopicService topicService(TopicRepository topicRepository) {
        return new TopicServiceImpl(topicRepository);
    }
}