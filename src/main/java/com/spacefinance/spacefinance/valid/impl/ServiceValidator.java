package com.spacefinance.spacefinance.valid.impl;

import com.spacefinance.spacefinance.model.Paragon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.HashSet;
import java.util.Set;

@Component
public class ServiceValidator {
    Set<Paragon> paragons;
    private final Validator validator;

    @Autowired
    public ServiceValidator(Set<Paragon> paragons, final Validator validator) {
        this.paragons = new HashSet<>();
        this.validator = validator;
    }
    public void addParagon(Paragon paragon){
       Set<ConstraintViolation<Paragon>> error = validator.validate(paragon);
       if (!error.isEmpty()){
           error.forEach(err -> System.out.println(err.getMessage()));
       }else
           paragons.add(paragon);
    }

    public Set<Paragon> getParagons() {
        return this.paragons;
    }
}
