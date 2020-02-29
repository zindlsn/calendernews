package de.stefanzindl.calendernews.configuration;

import de.stefanzindl.calendernews.control.ActionDayService;
import de.stefanzindl.calendernews.control.CountryService;
import de.stefanzindl.calendernews.control.TopicService;
import de.stefanzindl.calendernews.control.impl.ActionDayServiceImpl;
import de.stefanzindl.calendernews.control.impl.CountryServiceImpl;
import de.stefanzindl.calendernews.control.impl.TopicServiceImpl;
import de.stefanzindl.calendernews.repository.ActionDayRepository;
import de.stefanzindl.calendernews.repository.CountryRepository;
import de.stefanzindl.calendernews.repository.TopicRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ControlServiceConfiguration {

    @Bean
    public ActionDayService actionDayService(ActionDayRepository actionDayRepository) {
        return new ActionDayServiceImpl(actionDayRepository);
    }

    @Bean
    public TopicService topicService(TopicRepository topicRepository) {
        return new TopicServiceImpl(topicRepository);
    }

    @Bean
    public CountryService countryService(CountryRepository countryRepository){
        return new CountryServiceImpl(countryRepository);
    }
}
