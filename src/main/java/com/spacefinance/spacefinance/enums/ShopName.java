package com.spacefinance.spacefinance.enums;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
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

    /**
     * @param description It's polish shop name.
     */
    ShopName(final String description) {
        this.description = description;
    }

}
