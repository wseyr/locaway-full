package com.sopra.LocAway.repository;

import java.util.Date;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sopra.LocAway.model.Option;
import com.sopra.LocAway.repository.IOptionRepository;


@SpringBootTest
class LocAwayApplicationTestsData {

	@Test
	void one() {
		ClassPathXmlApplicationContext spring = new ClassPathXmlApplicationContext("application.properties");

		IOptionRepository optionRepo = spring.getBean(IOptionRepository.class);

		Option fireplace = new Option("Cheminée", false);

		optionRepo.save(fireplace);

		spring.close();
	}

}
