package com.upc.TRIPBUDDIES.repository;

import com.upc.TRIPBUDDIES.entities.users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface IUsersRepository extends JpaRepository<users, Long> {

    users findByEmail(String email);

    List<users> findByFirstName(String firstName);

    List<users> findByRole(String role);

}
