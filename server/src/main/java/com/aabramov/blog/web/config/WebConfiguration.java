package com.aabramov.blog.web.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * @author Andrii Abramov on 2/25/17.
 */
@Configuration
public class WebConfiguration extends WebMvcConfigurerAdapter {
    
    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }
    
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/blog/api/**")
                .allowedMethods("GET", "POST", "PUT", "DELETE");
    }
}
