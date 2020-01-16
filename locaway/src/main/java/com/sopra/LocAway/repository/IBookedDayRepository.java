package com.sopra.LocAway.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sopra.LocAway.model.BookedDay;

public interface IBookedDayRepository extends JpaRepository<BookedDay, Long> {

}
