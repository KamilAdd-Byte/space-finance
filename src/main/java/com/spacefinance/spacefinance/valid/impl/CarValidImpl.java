package com.spacefinance.spacefinance.valid.impl;

import com.spacefinance.spacefinance.service.valid.Validation;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import javax.validation.Validator;

@ComponentScan
@Configuration
public class CarValidImpl implements Validation {

    @Bean
    @Override
    public Validator validator() {
        return new LocalValidatorFactoryBean();
    }
}
