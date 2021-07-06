package com.spacefinance.spacefinance.model;

import com.spacefinance.spacefinance.enums.ShopName;
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
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Objects;

@Setter
@Getter
@ToString
@Document(collection = "Space")
@NoArgsConstructor
public class Paragon implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_paragon")
    private String id;

    @Column(name = "user")
    @NotNull(message = "Set fields user Kasia or Kamil!")
    private String user;

    @Column(name = "price")
    private double price;

    @Column(name = "shop_name")
    @NotNull(message = "Set fields shop on this operation!")
    private ShopName shopName;

    @Column(name = "date")
    private LocalDate date = LocalDate.now();

    @Column(name = "time")
    private LocalTime time = LocalTime.now();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Paragon)) return false;
        Paragon paragon = (Paragon) o;
        return Double.compare(paragon.price, price) == 0 && id.equals(paragon.id) && user.equals(paragon.user) && shopName == paragon.shopName && Objects.equals(date, paragon.date) && Objects.equals(time, paragon.time);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, user, price, shopName, date, time);
    }
}

