package com.spacefinance.spacefinance.service;

import com.spacefinance.spacefinance.model.CarCare;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CarCareService {
    List<CarCare>allCareList();
    void addCare(CarCare carCare);
}
