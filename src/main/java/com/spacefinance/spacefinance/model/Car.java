package com.spacefinance.spacefinance.model;

import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;
import java.util.Date;

@Getter
@Setter
@ToString
@NoArgsConstructor
@Document(collection = "my_car")
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "car_id")
    private String id;

    @Column(name = "car_mark")
    private String mark;

    @Column(name = "car_model")
    private String model;

    private String carRegistration;

    @Column(name = "car_review")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate review = LocalDate.now();

    @Column(name = "car_mileage")
    private double mileage;

    @Column(name = "car_oilCheck")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate oilCheck = LocalDate.now();
}
