package com.spacefinance.spacefinance.service;

import com.spacefinance.spacefinance.model.Paragon;
import org.springframework.stereotype.Service;

import java.time.Month;
import java.util.List;
import java.util.Optional;

@Service
public interface ParagonService {
    List<Paragon> allParagons();

    void saveParagon(Paragon paragon);

    void removeParagon(Paragon paragon);

    Optional<Paragon> findById(String id);

    void updateParagon(String id, Paragon paragon);

    int sizeParagon();

    double getSumAllParagon();
}
