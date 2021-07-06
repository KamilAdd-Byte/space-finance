package com.spacefinance.spacefinance.valid.impl;

import com.spacefinance.spacefinance.service.valid.Validation;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import javax.validation.Validator;

@ComponentScan
@Configuration
public class ParagonValidImpl implements Validation {


    @Override
    @Bean
    public Validator validator() {
        return new LocalValidatorFactoryBean();
    }
}
