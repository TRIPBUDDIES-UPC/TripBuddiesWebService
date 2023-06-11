package com.upc.TRIPBUDDIES.repository;

import com.upc.TRIPBUDDIES.entities.Destination;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IDestinationRepository extends JpaRepository<Destination, Long> {
}
