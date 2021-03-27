package com.spacefinance.spacefinance.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

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
}
