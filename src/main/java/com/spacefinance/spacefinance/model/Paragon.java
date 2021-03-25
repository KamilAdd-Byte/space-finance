package com.spacefinance.spacefinance.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

import javax.persistence.*;
import java.io.Serializable;

@Setter
@Getter
@ToString
@Document(collection = "Paragon")
@NoArgsConstructor
public class Paragon implements Serializable {

    @MongoId
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_paragon")
    private String id;

    @Column(name = "price")
    private double price;

    @Column(name = "shop_name")
//    @Enumerated(EnumType.STRING)
    private ShopName shopName;

    @Column(name = "user")
    private User user;

    @Embedded
    private Audit audit = new Audit();


}

