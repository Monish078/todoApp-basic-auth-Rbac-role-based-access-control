package com.beginner_level.TodoApp.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MapperConfig {

    @Bean // easy conversion of entity todo to Dto
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }
}
