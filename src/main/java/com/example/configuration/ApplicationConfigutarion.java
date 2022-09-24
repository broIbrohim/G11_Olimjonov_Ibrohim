package com.example.configuration;


import jdk.internal.vm.annotation.Contended;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

import java.util.jar.JarEntry;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.example")
public class ApplicationConfigutarion  implements WebMvcConfigurer {


    @Bean
    public JdbcTemplate jdbcTemplate () {
        JdbcTemplate jdbcTemplate = new JdbcTemplate();;
        DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();

        driverManagerDataSource.setUrl("jdbc:postgresql://localhost:5432/EXAM_FAIL");
        driverManagerDataSource.setDriverClassName("org.postgresql.Driver");
        driverManagerDataSource.setUsername("postgresql");
        driverManagerDataSource.setPassword("ibrohim20061");
        jdbcTemplate.setDataSource(driverManagerDataSource);
        return jdbcTemplate;
    }


    @Bean

    public ViewResolver getViewResolver () {
        InternalResourceViewResolver internalResourceViewResolver = new InternalResourceViewResolver();
        internalResourceViewResolver.setViewClass(JstlView.class);
        internalResourceViewResolver.setPrefix("/WEB-INF/");
        internalResourceViewResolver.setSuffix(".jsp");

        return internalResourceViewResolver;
    }
}
