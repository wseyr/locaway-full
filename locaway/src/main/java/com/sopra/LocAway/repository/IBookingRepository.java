package com.sopra.LocAway.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sopra.LocAway.model.Booking;

public interface IBookingRepository extends JpaRepository<Booking, Long> {

}
