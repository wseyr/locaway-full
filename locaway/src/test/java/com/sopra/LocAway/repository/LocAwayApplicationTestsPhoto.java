package com.sopra.LocAway.repository;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sopra.LocAway.model.Photo;


@SpringBootTest
class LocAwayApplicationTestsPhoto {

	@Test
	void one() {
		ClassPathXmlApplicationContext spring = new ClassPathXmlApplicationContext("application-properties.xml");

		IPhotoRepository photoRepo = spring.getBean(IPhotoRepository.class);

		Photo mainPhoto = new Photo();

		photoRepo.save(mainPhoto);

		spring.close();
	}

}
