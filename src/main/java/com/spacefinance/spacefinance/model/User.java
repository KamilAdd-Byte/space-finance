package com.spacefinance.spacefinance.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

import javax.persistence.*;
import java.util.Objects;


@Getter
@Setter
@ToString
@Document(collection = "User")
@NoArgsConstructor
public class User  {
    @MongoId
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_user")
    private String id;

    @Column(name = "user_name")
    private String name;

    @Column(name = "paragon")
    private Paragon paragon;
}
