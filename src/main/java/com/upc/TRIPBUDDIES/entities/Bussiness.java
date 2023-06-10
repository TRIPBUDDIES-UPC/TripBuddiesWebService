package com.upc.TRIPBUDDIES.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name = "bussiness")
@Data
@NoArgsConstructor
public class Bussiness extends users{
    private String ruc;
    private String owner;
    private String name;
    private String address;
    private String country;
    private String city;

    public Bussiness(Long id, String firstName, String lastName, String email, String phone, String password, String role, String description, String image, String ruc, String owner, String name, String address, String country, String city, List<users> users) {
        super(id, firstName, lastName, email, phone, password, role, description, image, users);
        this.ruc = ruc;
        this.owner = owner;
        this.name = name;
        this.address = address;
        this.country = country;
        this.city = city;
    }
}
