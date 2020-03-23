package de.stefanzindl.calendernews.configuration;

import de.stefanzindl.calendernews.boundary.converter.ActionDayConverter;
import de.stefanzindl.calendernews.boundary.converter.TopicConverter;
import de.stefanzindl.calendernews.control.ActionDayService;
import de.stefanzindl.calendernews.control.TopicService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Configuration to create all converters.
 */
@Configuration
public class ConverterConfiguration {


    /**
     * Singelton for Action-day converter.
     *
     * @param actionDayService to set
     * @param topicService     to set
     * @param topicConverter   to set
     * @return the converter
     */
    @Bean
    ActionDayConverter actionDayConverter(ActionDayService actionDayService, TopicService topicService, TopicConverter topicConverter) {
        return new ActionDayConverter(actionDayService, topicService, topicConverter);
    }

    /**
     * Singelton for topic converter.
     *
     * @param topicService to set
     * @return the converter
     */
    @Bean
    TopicConverter topicConverter(TopicService topicService) {
        return new TopicConverter(topicService);
    }

}
