package com.upc.TRIPBUDDIES.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "destinations")
public class Destination {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false, length = 50)
    private String name;

    @Column(name = "description", nullable = false, length = 500)
    private String description;

    @Column(name = "image", nullable = false, length = 500)
    private String image;

    @Column(name = "rating", nullable = false)
    private Integer rating;

    @Column(name = "price", nullable = false)
    private Float price;

    @Column(name = "location", nullable = false, length = 50)
    private String location;

    @Column(name = "country", nullable = false, length = 50)
    private String country;

}
