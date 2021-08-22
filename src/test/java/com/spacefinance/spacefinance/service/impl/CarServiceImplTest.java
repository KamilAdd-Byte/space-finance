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
        //given
        Car newCar = new Car();
        newCar.setMark("Test");
        newCar.setModel("Model test000");
        newCar.setMileage(347.5);
        //when
        carService.addCar(newCar);

        //then
        assertNotNull(newCar);
        assertThat(newCar.getMark()).isEqualTo("Test");

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
