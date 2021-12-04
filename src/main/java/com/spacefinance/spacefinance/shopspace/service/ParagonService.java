package com.spacefinance.spacefinance.shopspace.service;

import com.spacefinance.spacefinance.shopspace.Paragon;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public interface ParagonService {
    List<Paragon> allParagons();

    void saveParagon(Paragon paragon);

    void removeParagon(String idParagon);

    Paragon findById(String id);

    Paragon updateParagon(String id);

    int sizeParagon();

    double getSumAllParagon();
}
