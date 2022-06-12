package com.nhnacademy.projectApiServer.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.ui.ModelMap;

@Configuration
public class RootConfig {

    @Bean
    ModelMapper modelMapper(){
        return new ModelMapper();
    }
}
