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
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Objects;

@Setter
@Getter
@ToString
@Document(collection = "Travel")
@NoArgsConstructor
public class Travel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_travel")
    private String id;

    @Column(name = "name")
    private String name;

    @Column(name = "category_travel")
    private TravelCategory category;

    @Column(name = "days")
    private int numberDays;

    @Column(name = "date")
    private LocalDate date = LocalDate.now();

    @Column(name = "time")
    private LocalTime time = LocalTime.now();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Travel)) return false;
        Travel travel = (Travel) o;
        return numberDays == travel.numberDays && Objects.equals(id, travel.id) && Objects.equals(name, travel.name) && category == travel.category && Objects.equals(date, travel.date) && Objects.equals(time, travel.time);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, category, numberDays, date, time);
    }
}
