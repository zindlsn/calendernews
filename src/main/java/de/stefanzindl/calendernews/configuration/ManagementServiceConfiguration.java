package de.stefanzindl.calendernews.configuration;

import de.stefanzindl.calendernews.boundary.ActionDayManagementService;
import de.stefanzindl.calendernews.boundary.TopicManagementService;
import de.stefanzindl.calendernews.boundary.converter.ActionDayConverter;
import de.stefanzindl.calendernews.boundary.converter.TopicConverter;
import de.stefanzindl.calendernews.boundary.impl.ActionDayManagementServiceImpl;
import de.stefanzindl.calendernews.boundary.impl.TopicManagementServiceImpl;
import de.stefanzindl.calendernews.control.ActionDayService;
import de.stefanzindl.calendernews.control.TopicService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Configuration for all ManagmentServices.
 */
@Configuration
public class ManagementServiceConfiguration {

    /**
     * ManagementService for action-days.
     *
     * @param actionDayService action day service
     * @param topicService     topic service
     * @param topicConverter   topic converter
     * @return implementation
     */
    @Bean
    public ActionDayManagementService actionDayManagementService(ActionDayService actionDayService, TopicService topicService, TopicConverter topicConverter, ActionDayConverter actionDayConverter) {
        return new ActionDayManagementServiceImpl(actionDayService, topicService, actionDayConverter);
    }

    /**
     * ManagementService for topics.
     *
     * @param topicConverter converter for topic
     * @param topicService   service
     * @return implementation
     */
    @Bean
    public TopicManagementService topicManagementService(TopicConverter topicConverter, TopicService topicService) {
        return new TopicManagementServiceImpl(topicConverter, topicService);
    }
}
