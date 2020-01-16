package com.sopra.LocAway;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.sopra.LocAway.model.Accomodation;
import com.sopra.LocAway.model.EAccomodationType;
import com.sopra.LocAway.model.Option;
import com.sopra.LocAway.model.User;
import com.sopra.LocAway.repository.IAccomodationRepository;
import com.sopra.LocAway.repository.IBookedDayRepository;
import com.sopra.LocAway.repository.IBookingRepository;
import com.sopra.LocAway.repository.IBookmarkRepository;
import com.sopra.LocAway.repository.IContactRepository;
import com.sopra.LocAway.repository.ICustomPriceDayRepository;
import com.sopra.LocAway.repository.IOptionRepository;
import com.sopra.LocAway.repository.IPhotoRepository;
import com.sopra.LocAway.repository.IPointOfInterestRepository;
import com.sopra.LocAway.repository.IReviewRepository;
import com.sopra.LocAway.repository.IUserRepository;

@SpringBootTest
class DataTestCreation {

	@Autowired
	private IUserRepository userRepo;
	@Autowired
	private IAccomodationRepository accomodationRepo;
	@Autowired
	private IBookedDayRepository bookedDayRepo;	
	@Autowired
	private IBookingRepository bookingRepo;	
	@Autowired
	private IBookmarkRepository bookmarkRepo;	
	@Autowired
	private IReviewRepository reviewRepo;	
	@Autowired
	private IContactRepository contactRepo;	
	@Autowired
	private ICustomPriceDayRepository customPriceDayRepo;	
	@Autowired
	private IOptionRepository optionRepo;	
	@Autowired
	private IPointOfInterestRepository pointOfInterestRepo;	
	@Autowired
	private IPhotoRepository photoRepo;	
	
	@Test
	void run() {

		User u = new User();
		u.setAdmin(false);
		u.setEmail("gmail@gmail.com");
		u.setPassword("motdepasse");
		u.setPhoneNumber("0560606060");
		u.setFirstName("Steve");
		u.setLastName("Jobs");

		User u1 = new User();
		u1.setAdmin(true);
		u1.setEmail("yaou@yahoo.com");
		u1.setPassword("topsecret");
		u1.setPhoneNumber("0567891234");
		u1.setFirstName("Super");
		u1.setLastName("Admin");

		User u2 = new User();
		u2.setAdmin(false);
		u2.setEmail("javadev@oracle.com");
		u2.setPassword("azerty");
		u2.setPhoneNumber("012345678");
		u2.setFirstName("Jhon");
		u2.setLastName("Smith");

		u = userRepo.save(u);
		u1 = userRepo.save(u1);
		u2 = userRepo.save(u2);

		Accomodation a = new Accomodation();
		a.setName("residence des residents");
		a.setNumber("25");
		a.setStreet("allée de cherbourg");
		a.setCity("Toulouse");
		a.setPostcode("31000");
		a.setCountry("France");
		a.setLatitudeDeg(43.595282f);
		a.setLongitudeDeg(1.429806f);
		a.setDescription("quatres murs et un plafond");
		a.setNumberOfRooms(12);
		a.setMaxPersons(30);
		a.setDeleted(false);
		a.setAccomodationType(EAccomodationType.APPARTMENT);
		a.setDefaultBasePrice(650f);
		a.setDefaultPersonPrice(100f);

		Accomodation a1 = new Accomodation();
		a1.setName("villa des coeurs brises");
		a1.setNumber("69");
		a1.setStreet("boulevard des airs");
		a1.setCity("Toulouse");
		a1.setPostcode("31000");
		a1.setCountry("France");
		a1.setLatitudeDeg(43.5865373f);
		a1.setLongitudeDeg(1.4385796f);
		a1.setDescription("une desciption a remplir");
		a1.setNumberOfRooms(23445);
		a1.setMaxPersons(876896786);
		a1.setDeleted(false);
		a1.setAccomodationType(EAccomodationType.GUESTHOUSE);
		a1.setDefaultBasePrice(222f);
		a1.setDefaultPersonPrice(31f);

		Accomodation a2 = new Accomodation();
		a2.setName("mysterieux appartement");
		a2.setNumber("221B");
		a2.setStreet("Baker Street");
		a2.setCity("Londres");
		a2.setPostcode("WC2N 5DU");
		a2.setCountry("La perfide albion");
		a2.setLatitudeDeg(4.5f);
		a2.setLongitudeDeg(1.5f);
		a2.setDescription("une desciption a remplir");
		a2.setNumberOfRooms(2);
		a2.setMaxPersons(8);
		a2.setDeleted(false);
		a2.setAccomodationType(EAccomodationType.GUESTHOUSE);
		a2.setDefaultBasePrice(1500f);
		a2.setDefaultPersonPrice(310f);

		
		a = accomodationRepo.save(a);
		a1 = accomodationRepo.save(a1);
		a2 = accomodationRepo.save(a2);
	
		Option o0 = new Option();
		o0.setIsRule(false);
		o0.setName("cheminée");
		Option o1 = new Option();
		o1.setIsRule(false);
		o1.setName("balcon");
		Option o2 = new Option();
		o2.setIsRule(false);
		o2.setName("jardin");
		Option o3 = new Option();
		o3.setIsRule(false);
		o3.setName("piscine");
		Option o4 = new Option();
		o4.setIsRule(false);
		o4.setName("fibre");
		Option o5 = new Option();
		o5.setIsRule(true);
		o5.setName("no smoking");
		Option o6 = new Option();
		o6.setIsRule(true);
		o6.setName("no animals");
		Option o7 = new Option();
		o7.setIsRule(false);
		o7.setName("amenagement PMR");
		Option o8 = new Option();
		o8.setIsRule(false);
		o8.setName("ascenseur");
		List<Option> options= new ArrayList<Option>();
		for (int i = 0; i < 9; i++) {
			
		}
	}
	

}
