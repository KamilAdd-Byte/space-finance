package com.spacefinance.spacefinance.service.impl;

import com.spacefinance.spacefinance.model.Car;
import com.spacefinance.spacefinance.service.CarService;
import org.hibernate.type.LocalDateType;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class CarServiceImplTest {

    @Autowired
    private CarService carService;

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void allMyCars() {
//        //given
//        Car newCar = new Car();
//        newCar.setOilCheck(LocalDate.now());
//        newCar.setReview(LocalDate.MAX);
//        newCar.setMark("Test");
//        newCar.setModel("Model test000");
//        newCar.setMileage(347.5);
//        //when
//        carService.addCar(newCar);
        Date date = new Date();
        System.out.println("Biblioteka Date: " + date);

        LocalDate now = LocalDate.now();
        System.out.println("Biblioteka LocalDate: " + now);

        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println("Biblioteka LocalDateTime: " + localDateTime);
//        //then
//        assertThat(newCar.getMark()).isEqualTo("test");

    }

    @Test
    void addCar() {
    }

    @Test
    void removeCar() {
    }

    @Test
    void findById() {
    }

    @Test
    void updateCar() {
    }
}
