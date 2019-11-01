package com.SpringDeneme.SpringDemo.enums;


import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.util.stream.Stream;

@Converter(autoApply = true)
public class CategoryConverter implements AttributeConverter<Category,String> {

    @Override
    public String convertToDatabaseColumn(Category attribute) {
        if (attribute == null)
            return null;
        return attribute.getCode();
    }

    @Override
    public Category convertToEntityAttribute(String dbData) {
        if(dbData==null)
            return null;
        return Stream.of(Category.values())
                .filter(c-> c.getCode().equals(dbData))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);

    }
}
