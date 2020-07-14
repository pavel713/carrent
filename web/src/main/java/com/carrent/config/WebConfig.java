package com.carrent.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;


@Configuration
@EnableWebMvc
@ComponentScan(basePackages = { "com.carrent.controller" })
@Import(value = {com.carrent.config.InternationalizationConfig.class, ThymeleafConfig.class})
public class WebConfig {
}
