package com.spacefinance.spacefinance.service;

import com.spacefinance.spacefinance.model.Paragon;
import com.spacefinance.spacefinance.repository.ParagonDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

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

    //TODO poprawić update i find!!!

    @Override
    public Optional<Paragon> findById(String id) {
        return this.paragonRepository.findById(id);
    }
    @Override
    public void updateParagon(String id,Paragon paragon) {
       this.paragonRepository.findById(id);
    }

    @Override
    public int sizeParagon() {
        List<Paragon> paragons = paragonRepository.findAll();
        return paragons.size();
    }

    @Override
    public double getSumAllParagon() {
        double price = 0.0;
        List<Paragon> paragons = paragonRepository.findAll();
        for (int i = 0; i < paragons.size(); i++) {
            Paragon paragon = paragons.get(i);
            price += paragon.getPrice();
        }
        return price;
    }
}
