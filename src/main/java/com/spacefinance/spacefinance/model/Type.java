package com.spacefinance.spacefinance.model;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public enum Type {
    GAS_STATION("Tankowanie"),
    MECHANIC("Mechanik-naprawa"),
    CARE("Pielęgnacja");

    private String description;

    Type(String description) {
        this.description = description;
    }
}
