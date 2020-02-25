package de.stefanzindl.calendernews.configuration;

import de.stefanzindl.calendernews.boundary.ActionDayManagementService;
import de.stefanzindl.calendernews.boundary.TopicManagementService;
import de.stefanzindl.calendernews.boundary.impl.ActionDayManagementServiceImpl;
import de.stefanzindl.calendernews.boundary.impl.TopicManagementServiceImpl;
import de.stefanzindl.calendernews.control.ActionDayService;
import de.stefanzindl.calendernews.control.TopicService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ManagementServiceConfiguration {

    @Bean
    public ActionDayManagementService eventManagementService(ActionDayService actionDayService){
        return new ActionDayManagementServiceImpl(actionDayService);
    }

    @Bean
    public TopicManagementService topicManagementService(TopicService topicService){
        return new TopicManagementServiceImpl(topicService);
    }
}
