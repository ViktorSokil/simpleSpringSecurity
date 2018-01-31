package com.sokil.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@ComponentScan(basePackages = "com.sokil")
@EnableJpaRepositories(basePackages = "com.sokil.repository")
public class AppConfig {


}
