package de.stefanzindl.calendernews;

import de.stefanzindl.calendernews.control.ActionDayService;
import de.stefanzindl.calendernews.control.TopicService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import static org.mockito.Mockito.mock;

/**
 * Configuration class to create mocked controler-services for use in tests.
 */
@Configuration
@Profile({"test"})
public class MockedControlServiceConfiguration {

    /**
     * Create the mocked {@link ActionDayService}.
     *
     * @return the mocked connectionService
     */
    @Bean
    public ActionDayService connectionService() {
        return mock(ActionDayService.class);
    }

    /**
     * Create the mocked {@link TopicService}.
     *
     * @return the mocked portService
     */
    @Bean
    public TopicService portService() {
        return mock(TopicService.class);
    }
}
