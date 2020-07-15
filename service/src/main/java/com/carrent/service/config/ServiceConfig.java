package com.carrent.service.config;

import com.carrent.dao.configuration.ConfigurationDAO;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(value = {ConfigurationDAO.class})
@ComponentScan(basePackages = {"com.carrent"})
public class ServiceConfig {


}


