package com.spacefinance.spacefinance.valid;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import javax.validation.Validator;

@ComponentScan
@Configuration
public class ParagonValidation {

    @Bean
    Validator validator(){
        return new LocalValidatorFactoryBean();
    }
}
