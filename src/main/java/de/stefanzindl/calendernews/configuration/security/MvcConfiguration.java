package de.stefanzindl.calendernews.configuration.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.resource.PathResourceResolver;

/**
 * Configuration for serving static content.
 */
@Configuration
@RestController
public class MvcConfiguration implements WebMvcConfigurer {

  private static final String API_PATH_PATTERN = "/**";

  @Override
  public void addResourceHandlers(ResourceHandlerRegistry registry) {
    registry.addResourceHandler(API_PATH_PATTERN)
        .addResourceLocations("classpath:/static/docs/")
        .setCachePeriod(1)
        .resourceChain(true)
        .addResolver(new PathResourceResolver());
  }

}
