package com.spacefinance.spacefinance.service.impl;

import com.spacefinance.spacefinance.model.Travel;
import com.spacefinance.spacefinance.repository.TravelDao;
import com.spacefinance.spacefinance.service.TravelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class TravelServiceImpl implements TravelService {

    @Autowired
    private TravelDao travelRepository;

    @Override
    public List<Travel> allTravel() {
        return this.travelRepository.findAll();
    }

    @Override
    public void addTravel(Travel travel) {
        this.travelRepository.save(travel);
    }

    @Override
    public void removeTravel(Travel travel) {
        this.travelRepository.delete(travel);
    }
}
