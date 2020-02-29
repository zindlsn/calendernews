package de.stefanzindl.calendernews.configuration;

import de.stefanzindl.calendernews.control.ActionDayService;
import de.stefanzindl.calendernews.control.impl.ActionDayServiceImpl;
import de.stefanzindl.calendernews.repository.ActionDayRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ControlServiceConfiguration {

    @Bean
    public ActionDayService actionDayService(ActionDayRepository actionDayRepository) {
        return new ActionDayServiceImpl(actionDayRepository);
    }
}