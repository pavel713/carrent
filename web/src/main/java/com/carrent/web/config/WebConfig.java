package com.carrent.web.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;


@Configuration
@EnableWebMvc
@ComponentScan(basePackages = { "com.carrent.web.controller" })
@Import(value = {InternationalizationConfig.class, ThymeleafConfig.class})
public class WebConfig {
}
