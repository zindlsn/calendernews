package de.stefanzindl.calendernews.configuration;

import de.stefanzindl.calendernews.boundary.CalenderNewsManagementService;
import de.stefanzindl.calendernews.boundary.impl.CalenderNewsManagementServiceImpl;
import de.stefanzindl.calendernews.control.DayService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ManagementServiceConfiguration {

    @Bean
    public CalenderNewsManagementService calenderNewsManagementService(DayService  dayService)
    {
        return new CalenderNewsManagementServiceImpl(dayService);
    }
}
