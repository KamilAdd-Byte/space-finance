package com.spacefinance.spacefinance.model;

import lombok.Getter;
import lombok.ToString;

@ToString
@Getter
public enum ShopName {
    BIEDRONKA("Biedronka"),
    LIDL("Lidl"),
    GROSZEK("Grosik"),
    POLSKA_CHATA("Polska chata"),
    INTERMARCHE("Inter"),
    AUCHAN("Auchan"),
    ZABKA("Żabka"),
    SPOLEM("Społem"),
    MEAT("Nasze mięso"),
    INNY("Inne");

    private final String description;

    ShopName(final String description) {
        this.description = description;
    }

}
