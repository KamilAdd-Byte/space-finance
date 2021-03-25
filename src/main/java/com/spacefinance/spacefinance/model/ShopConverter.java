package com.spacefinance.spacefinance.model;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.util.stream.Stream;

@Converter(autoApply = true)
public class ShopConverter implements AttributeConverter<ShopName,String> {

    @Override
    public String convertToDatabaseColumn(ShopName shopName) {
        if (shopName == null){
            return null;
        }
        return shopName.getDescription();
    }

    @Override
    public ShopName convertToEntityAttribute(String description) {
        if (description == null){
            return null;
        }
        return Stream.of(ShopName.values())
                .filter(d -> d.getDescription().equals(description))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }
}
