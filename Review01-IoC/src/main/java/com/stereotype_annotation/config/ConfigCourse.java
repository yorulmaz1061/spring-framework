package com.stereotype_annotation.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
//What is the purpose of @ComponentScan? It searches which package involves components
@ComponentScan(basePackages = "com.stereotype_annotation")
public class ConfigCourse {

}
