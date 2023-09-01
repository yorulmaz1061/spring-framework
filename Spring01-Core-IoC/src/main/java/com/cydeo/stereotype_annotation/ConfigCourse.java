package com.cydeo.stereotype_annotation;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan  (basePackages = "com.cydeo")
//Spring will look all the component annotation belongs to entire package
//if you mention basePackages, it will look all packages under its.
public class ConfigCourse {

}
