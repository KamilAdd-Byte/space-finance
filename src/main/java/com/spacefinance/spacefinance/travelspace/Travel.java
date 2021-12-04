package com.spacefinance.spacefinance.travelspace;

import com.spacefinance.spacefinance.travelspace.type.ThingsToTake;
import com.spacefinance.spacefinance.travelspace.type.TravelCategory;
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
import java.util.ArrayList;
import java.util.List;
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

    @Column(name = "things_to_take")
    private List<ThingsToTake> thingsToTakes;


    public void addToThingsList(ThingsToTake thingsToTake){
        if (thingsToTakes==null)
            thingsToTakes = new ArrayList<>();
        thingsToTakes.add(thingsToTake);
    }

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
