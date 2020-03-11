package de.stefanzindl.calendernews.configuration;

import de.stefanzindl.calendernews.boundary.ActionDayManagementService;
import de.stefanzindl.calendernews.boundary.TopicManagementService;
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
     * @param actionDayService service
     * @return implementation
     */
    @Bean
    public ActionDayManagementService actionDayManagementService(ActionDayService actionDayService) {
        return new ActionDayManagementServiceImpl(actionDayService);
    }

    /**
     * ManagementService for topics.
     *
     * @param topicService service
     * @return implementation
     */
    @Bean
    public TopicManagementService topicManagementService(TopicService topicService) {
        return new TopicManagementServiceImpl(topicService);
    }
}
