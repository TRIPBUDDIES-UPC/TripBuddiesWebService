package com.upc.TRIPBUDDIES.repository;

import com.upc.TRIPBUDDIES.entities.Review;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IReviewRepository extends JpaRepository<Review, Long> {
}
