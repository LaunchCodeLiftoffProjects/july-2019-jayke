package com.aplaygroundreviewer.config;

import nz.net.ultraq.thymeleaf.LayoutDialect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.Validator;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.thymeleaf.extras.springsecurity4.dialect.SpringSecurityDialect;


@Configuration
public class WebConfig implements WebMvcConfigurer
{

    @Autowired
    private MessageSource messageSource;

    //Set login page for spring security
    @Override
    public void addViewControllers(ViewControllerRegistry registry)
    {
        registry.addViewController("/login").setViewName("login");
    }

    @Override
    public Validator getValidator() {
        LocalValidatorFactoryBean factory = new LocalValidatorFactoryBean();
        factory.setValidationMessageSource(messageSource);
        return factory;
    }

    //The Spring Security dialect display content based on user roles,permissions or other security expressions.
    //Attributes Spring Security Dialect: sec:authorize and sec:authentication.
    @Bean
    public SpringSecurityDialect securityDialect() {
        return new SpringSecurityDialect();
    }

    //To create custom sections in our layout or reusable templates that can be replaced by sections which share the same name,
    //use fragment attribute inside our template.html body
    @Bean
    public LayoutDialect layoutDialect() {
        return new LayoutDialect();
    }
}
