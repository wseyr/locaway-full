package com.sopra.LocAway.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import com.sopra.LocAway.model.Accomodation;
import com.sopra.LocAway.model.BookedDay;
import com.sopra.LocAway.model.Booking;

public interface IBookingRepository extends JpaRepository<Booking, Long> {
	
//	List<Accomodation> findByBookedDays(@Param("bookedDay") BookedDay bookedDay);
	

}
