package com.spacefinance.spacefinance.carspace;

import com.spacefinance.spacefinance.carspace.cars.type.TypeCarExpenses;
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
@Document(collection = "CarExpenses")
@NoArgsConstructor
public class CarExpenses {

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
    @NotNull(message = "Set fields type car expenses on this operation!")
    private TypeCarExpenses typeCarExpenses;

    @Column(name = "description")
    private String description;

    @Column(name = "date")
    private LocalDate date = LocalDate.now();

    @Column(name = "time")
    private LocalTime time = LocalTime.now();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CarExpenses)) return false;
        CarExpenses carExpenses = (CarExpenses) o;
        return Double.compare(carExpenses.price, price) == 0 && id.equals(carExpenses.id) && user.equals(carExpenses.user) && typeCarExpenses == carExpenses.typeCarExpenses && Objects.equals(description, carExpenses.description) && Objects.equals(date, carExpenses.date) && Objects.equals(time, carExpenses.time);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, user, price, typeCarExpenses, description, date, time);
    }
}
