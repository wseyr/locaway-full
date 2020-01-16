package com.sopra.LocAway.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sopra.LocAway.model.CustomPriceDay;

public interface ICustomPriceDayRepository extends JpaRepository<CustomPriceDay, Long> {

}
