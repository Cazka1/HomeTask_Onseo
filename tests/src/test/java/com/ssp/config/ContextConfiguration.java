package com.ssp.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@ComponentScan({"com.ssp.*"})
@Import({WebSpringContext.class})
public class ContextConfiguration {
}
