package com.upc.TRIPBUDDIES.repository;

import com.upc.TRIPBUDDIES.entities.Friendship;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IFriendRepository extends JpaRepository<Friendship, Long> {
}
