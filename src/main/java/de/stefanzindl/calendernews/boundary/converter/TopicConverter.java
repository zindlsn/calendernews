package de.stefanzindl.calendernews.boundary.converter;

import de.stefanzindl.calendernews.control.TopicService;
import de.stefanzindl.calendernews.dto.v1.TopicDto;
import de.stefanzindl.calendernews.model.v1.Topic;
import de.stefanzindl.calendernews.util.dto.TopicDtoBuilder;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * Converter for topics
 */
public class TopicConverter {

    private final TopicService topicService;

    public TopicConverter(TopicService topicService) {
        this.topicService = topicService;
    }


    /**
     * Convert to dto.
     *
     * @param topic to covert
     * @return dto
     */
    public TopicDto convertToDto(Topic topic) {
        return TopicDtoBuilder.instance()
                .withTopicIdentifier(topic.getTopicIdentifier())
                .withName(topic.getName())
                .build();
    }

    /**
     * Convert from dto.
     *
     * @param topicDto to covert to
     * @return entity
     */
    private Topic convertFromDto(TopicDto topicDto) {
        Topic topic = topicService.findOneByUuid(topicDto.getTopicIdentifier());
        if (Objects.isNull(topic) || topic.isNew()) {
            topic = new Topic();
            topic.setTopicIdentifier(topicDto.getTopicIdentifier());
        }
        topic.setName(topicDto.getName());
        return topic;
    }

    /**
     * Convert a list to dtos.
     *
     * @param relatedTopics entities
     * @return dtos
     */
    public List<TopicDto> convertToDtos(List<Topic> relatedTopics) {
        return relatedTopics.stream().map(this::convertToDto).collect(Collectors.toList());
    }

    /**
     * Convert dtos to entities.
     *
     * @param relatedTopics dtos
     * @return entities
     */
    List<Topic> convertFromDtos(List<TopicDto> relatedTopics) {
        return relatedTopics.stream().map(this::convertFromDto).collect(Collectors.toList());
    }
}
