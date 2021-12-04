package com.spacefinance.spacefinance.travelspace.type;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.mongodb.core.mapping.Document;

@ToString
@Getter
@Setter
@Document(collection = "Travel")
@NoArgsConstructor
public class ThingsToTake {
    private String name;
    private int quantity;
    private boolean toTake;
    private boolean toBuy;

    public ThingsToTake(String name, int quantity, boolean toTake, boolean toBuy) {
        this.name = name;
        this.quantity = quantity;
        this.toTake = toTake;
        this.toBuy = toBuy;
    }
}
