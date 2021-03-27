package com.spacefinance.spacefinance.service;

import com.spacefinance.spacefinance.model.CarCare;
import com.spacefinance.spacefinance.repository.CarCareDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarCareServiceImpl implements CarCareService{
    @Autowired
    private CarCareDao careDao;


    @Override
    public List<CarCare> allCareList() {
        return this.careDao.findAll();
    }

    @Override
    public void addCare(CarCare carCare) {
        this.careDao.save(carCare);
    }
}
