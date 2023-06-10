package com.upc.TRIPBUDDIES.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name = "travellers")
@Data
@NoArgsConstructor
public class Traveller extends users{
    public Traveller(Long id, String firstName, String lastName, String email, String phone, String password, String role, String description, String image, List<users> friends) {
        super(id, firstName, lastName, email, phone, password, role, description, image, friends);
    }
}
