package com.spacefinance.spacefinance.service;

import com.spacefinance.spacefinance.model.Paragon;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public interface ParagonService {
    List<Paragon> allParagons();

    void saveParagon(Paragon paragon);

    void removeParagon(Paragon paragon);

    Paragon findById(String id);

    void updateParagon(String id);

    int sizeParagon();

    double getSumAllParagon();
}
