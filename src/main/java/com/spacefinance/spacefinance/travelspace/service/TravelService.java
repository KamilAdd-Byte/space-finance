package com.spacefinance.spacefinance.travelspace.service;

import com.spacefinance.spacefinance.travelspace.Travel;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TravelService {
    List<Travel> allTravel();

    void addTravel(Travel travel);

    void removeTravel(Travel travel);
}
