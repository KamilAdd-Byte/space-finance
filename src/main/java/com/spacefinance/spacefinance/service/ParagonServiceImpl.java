package com.spacefinance.spacefinance.service;

import com.spacefinance.spacefinance.model.Paragon;
import com.spacefinance.spacefinance.repository.ParagonDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ParagonServiceImpl implements ParagonService {

    @Autowired
    ParagonDao paragonRepository;

    @Override
    public List<Paragon> allParagons() {
        return paragonRepository.findAll();
    }

    @Override
    public void saveParagon(Paragon paragon) {
        this.paragonRepository.save(paragon);
    }

    @Override
    public void removeParagon(Paragon paragon) {
        this.paragonRepository.delete(paragon);
    }

//    @Override
//    public double sumAllParagon() {
//        return 0;
//    }
//
//    @Override
//    public double getSumUserParagon() {
//        return 0;
//    }
//
//    @Override
//    public double getSumUserKasiaParagon() {
//        return 0;
//    }

}
