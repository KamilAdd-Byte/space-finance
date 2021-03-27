package com.spacefinance.spacefinance.service;

import com.spacefinance.spacefinance.model.Travel;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TravelService {
    List<Travel>allTravel();
}
