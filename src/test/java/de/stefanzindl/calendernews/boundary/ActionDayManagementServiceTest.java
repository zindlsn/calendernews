package de.stefanzindl.calendernews.boundary;

import de.stefanzindl.calendernews.dto.v1.ActionDayDto;
import de.stefanzindl.calendernews.dto.v1.TopicDto;
import de.stefanzindl.calendernews.util.dto.ActionDayDtoBuilder;
import de.stefanzindl.calendernews.util.dto.TopicDtoBuilder;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Collections;
import java.util.UUID;

/**
 * Test class for {@link ActionDayManagementService}.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ActionDayManagementServiceTest {

    @Autowired
    private ActionDayManagementService actionDayManagementService;

    private ActionDayDto actionDay;
    private TopicDto topicDto;

    /**
     * Initializes the test.
     */
    @Before
    public void init() {
        this.actionDay = ActionDayDtoBuilder.instance().build();
        this.topicDto = TopicDtoBuilder.instance().build();
    }

    /**
     * Saves and loads a action-day-dto without topics.
     */
    @Test
    public void createActionDayDtoWithoutTopicSuccessfully() {
        UUID identifier = this.actionDayManagementService.saveActionDay(actionDay);
        ActionDayDto loadedActionDay = actionDayManagementService.findActionDayByActionDayIdentifier(identifier);
        Assert.assertNotNull(loadedActionDay);
    }

    /**
     * Saves and loads a action-day-dto without topics.
     */
    @Test
    public void createActionDayDtoWithTopicSuccessfully() {
        ActionDayDto actionDay = ActionDayDtoBuilder.instance().withTopicDtos(Collections.singletonList(this.topicDto)).build();
        UUID identifier = this.actionDayManagementService.saveActionDay(actionDay);
        ActionDayDto loadedActionDay = actionDayManagementService.findActionDayByActionDayIdentifier(identifier);
        Assert.assertNotNull(loadedActionDay);
    }
}
