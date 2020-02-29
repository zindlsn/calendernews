package de.stefanzindl.calendernews.configuration;

import de.stefanzindl.calendernews.boundary.ActionDayManagementService;
import de.stefanzindl.calendernews.boundary.impl.ActionDayManagementServiceImpl;
import de.stefanzindl.calendernews.control.ActionDayService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ManagementServiceConfiguration {

    @Bean
    public ActionDayManagementService actionDayManagementService(ActionDayService actionDayService) {
        return new ActionDayManagementServiceImpl(actionDayService);
    }
}
