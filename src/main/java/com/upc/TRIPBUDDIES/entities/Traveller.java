package com.upc.TRIPBUDDIES.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "travellers")
@Data
@NoArgsConstructor
public class Traveller extends users{
    public Traveller(Long id, String firstName, String lastName, String email, String phone, String password, String role, String description, String image) {
        super(id, firstName, lastName, email, phone, password, role, description, image);
    }
}
