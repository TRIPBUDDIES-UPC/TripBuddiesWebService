package com.upc.TRIPBUDDIES.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "places")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Places implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "tittle", nullable = false, length = 50)
    private String name;
    @Column(name = "description", nullable = false, length = 500)
    private String description;
    @Column(name = "image_url", nullable = false, length = 500)
    private String imageUrl;
    @ManyToOne
    @JoinColumn(name = "bussiness_id", nullable = false)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Bussiness bussiness;
}
