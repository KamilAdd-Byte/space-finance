package com.spacefinance.spacefinance.enums;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public enum TypeCarExpenses {
    GAS_STATION("Gas-Station"),
    MECHANIC("Mechanic"),
    CARE("Care");

    private final String description;

    TypeCarExpenses(final String description) {
        this.description = description;
    }
}
