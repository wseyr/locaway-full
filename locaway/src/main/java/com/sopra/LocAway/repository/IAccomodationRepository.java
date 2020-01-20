package com.sopra.LocAway.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.sopra.LocAway.model.Accomodation;

public interface IAccomodationRepository extends JpaRepository<Accomodation, Long> {

	List<Accomodation> findByCity(@Param("city") String city);
	
	
}
