package com.sopra.LocAway.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sopra.LocAway.model.Review;

public interface IReviewRepository extends JpaRepository<Review, Long> {

}
