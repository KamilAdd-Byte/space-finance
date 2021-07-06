package com.spacefinance.spacefinance.model;

import com.spacefinance.spacefinance.enums.Type;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Objects;

@Setter
@Getter
@ToString
@Document(collection = "Car")
@NoArgsConstructor
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private String id;

    @Column(name = "user")
    @NotNull(message = "Set fields user Kasia or Kamil!")
    private String user;

    @Column(name = "price")
    private double price;

    @Column(name = "type")
    @NotNull(message = "Set fields type on this operation!")
    private Type type;

    @Column(name = "description")
    private String description;

    @Column(name = "date")
    private LocalDate date = LocalDate.now();

    @Column(name = "time")
    private LocalTime time = LocalTime.now();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Car)) return false;
        Car car = (Car) o;
        return Double.compare(car.price, price) == 0 && id.equals(car.id) && user.equals(car.user) && type == car.type && Objects.equals(description, car.description) && Objects.equals(date, car.date) && Objects.equals(time, car.time);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, user, price, type, description, date, time);
    }
}
