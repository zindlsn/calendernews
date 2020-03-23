package de.stefanzindl.calendernews;

import de.stefanzindl.calendernews.boundary.ActionDayManagementService;
import de.stefanzindl.calendernews.boundary.TopicManagementService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import static org.mockito.Mockito.mock;

/**
 * Configuration class to create mocked boundary services for use in tests.
 */
@Configuration
@Profile({"dev"})
public class MockedManagementServiceConfiguration {

    /**
     * Creates the mocked {@link ActionDayManagementService}.
     *
     * @return the mocked ActionDayManagementService
     */
    @Bean
    public ActionDayManagementService actionDayManagementService() {
        return mock(ActionDayManagementService.class);
    }

    /**
     * Creates the mocked {@link de.stefanzindl.calendernews.boundary.TopicManagementService}.
     *
     * @return the mocked TopicManagementService
     */
    @Bean
    public TopicManagementService topicManagementService() {
        return mock(TopicManagementService.class);
    }
}
