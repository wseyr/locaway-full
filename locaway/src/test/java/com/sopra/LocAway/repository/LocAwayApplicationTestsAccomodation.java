package com.sopra.LocAway.repository;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sopra.LocAway.model.Accomodation;


@SpringBootTest
class LocAwayApplicationTestsAccomodation {

	@Test
	void one() {
		ClassPathXmlApplicationContext spring = new ClassPathXmlApplicationContext("application-properties.xml");

		IAccomodationRepository photoRepo = spring.getBean(IAccomodationRepository.class);

		Accomodation mainPhoto = new Accomodation();

		photoRepo.save(mainPhoto);

		spring.close();
	}

}
