package com.spacefinance.spacefinance.service.impl;

import com.spacefinance.spacefinance.model.Paragon;
import com.spacefinance.spacefinance.repository.ParagonDao;
import com.spacefinance.spacefinance.service.ParagonService;
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

    @Override
    public Paragon findById(String id) {
        return this.paragonRepository.findById(id).orElseThrow(IllegalArgumentException::new);
    }

    @Override
    public Paragon updateParagon(String id) {
        Paragon update = paragonRepository.findById(id).orElseThrow(IllegalArgumentException::new);
        return this.paragonRepository.save(update);
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
        for (Paragon paragon : paragons) {
            price += paragon.getPrice();
        }
        return price;
    }

}
