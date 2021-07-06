package com.spacefinance.spacefinance.enums;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public enum Type {
    GAS_STATION("Gas-Station"),
    MECHANIC("Mechanic"),
    CARE("Care");

    private String description;

    Type(String description) {
        this.description = description;
    }
}
