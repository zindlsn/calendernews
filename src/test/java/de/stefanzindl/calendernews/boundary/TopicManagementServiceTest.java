package de.stefanzindl.calendernews.boundary;

import de.stefanzindl.calendernews.dto.v1.TopicDto;
import de.stefanzindl.calendernews.util.dto.TopicDtoBuilder;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.UUID;

/**
 * Test class for {@link ActionDayManagementService}.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class TopicManagementServiceTest {

    @Autowired
    private TopicManagementService topicManagementService;

    private TopicDto topicDto;

    /**
     * Initializes the test.
     */
    @Before
    public void init() {
        this.topicDto = TopicDtoBuilder.instance().build();
    }

    /**
     * Saves and loads a topic-dto.
     */
    @Test
    public void createActionDayDtoWithoutTopicSuccessfully() {
        UUID identifier = this.topicManagementService.saveTopic(topicDto);
        TopicDto loadedTopic = topicManagementService.findTopicByTopicIdentifier(identifier);

        Assert.assertEquals(topicDto.getTopicIdentifier(), loadedTopic.getTopicIdentifier());
        Assert.assertEquals(topicDto.getName(), loadedTopic.getName());
        Assert.assertNotNull(loadedTopic);
    }
}
