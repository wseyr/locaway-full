package com.sopra.LocAway.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sopra.LocAway.model.PointOfInterest;

public interface IPointOfInterestRepository extends JpaRepository<PointOfInterest, Long> {

}
