package com.carrent.service.config;

import com.carrent.dao.configuration.ConfigDAO;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(value = {ConfigDAO.class})
@ComponentScan(basePackages = {"com.carrent"})
public class ServiceConfig {


}


