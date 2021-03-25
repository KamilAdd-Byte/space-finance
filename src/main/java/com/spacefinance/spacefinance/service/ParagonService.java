package com.spacefinance.spacefinance.service;

import com.spacefinance.spacefinance.model.Paragon;
import com.spacefinance.spacefinance.model.User;
import org.springframework.stereotype.Service;

@Service
public interface ParagonService {
    void saveParagon(User user, Paragon paragon);
//    double sumAllParagon();
//    double getSumUserParagon();
//    double getSumUserKasiaParagon();
}
