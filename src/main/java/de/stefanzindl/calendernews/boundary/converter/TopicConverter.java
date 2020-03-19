package de.stefanzindl.calendernews.boundary.converter;

import de.stefanzindl.calendernews.control.TopicService;
import de.stefanzindl.calendernews.dto.v1.TopicDto;
import de.stefanzindl.calendernews.model.v1.Topic;

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
        TopicDto topicDto = new TopicDto();
        topicDto.setTopicIdentifier(topic.getTopicIdentifier());
        topicDto.setName(topic.getName());
        return topicDto;
    }

    /**
     * Convert from dto.
     *
     * @param topicDto to covert to
     * @return entity
     */
    Topic convertFromDto(TopicDto topicDto) {
        Topic topic = topicService.findOneByUuid(topicDto.getTopicIdentifier());
        if (Objects.isNull(topic) || topic.isNew()) {
            topic = new Topic();
            topic.setTopicIdentifier(topic.getTopicIdentifier());
        }
        topic.setName(topic.getName());
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
