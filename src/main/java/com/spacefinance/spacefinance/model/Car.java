package com.spacefinance.spacefinance.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
    private Date review;

    @Column(name = "car_mileage")
    private double mileage;

    @Column(name = "car_oilCheck")
    private Date oilCheck;
}
