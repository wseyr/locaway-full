package com.sopra.LocAway;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.sopra.LocAway.model.Accomodation;
import com.sopra.LocAway.model.CustomPriceDay;
import com.sopra.LocAway.model.EAccomodationType;
import com.sopra.LocAway.model.Option;
import com.sopra.LocAway.model.Photo;
import com.sopra.LocAway.model.PointOfInterest;
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
		o0.addAccomodation(a);
		o0.setName("cheminée");

		Option o1 = new Option();
		o1.setIsRule(false);
		o1.setName("balcon");
		o1.addAccomodation(a);

		Option o2 = new Option();
		o2.setIsRule(false);
		o2.setName("jardin");
		o2.addAccomodation(a);

		Option o3 = new Option();
		o3.setIsRule(false);
		o3.setName("piscine");
		o3.addAccomodation(a1);

		Option o4 = new Option();
		o4.setIsRule(false);
		o4.setName("fibre");
		o4.addAccomodation(a1);

		Option o5 = new Option();
		o5.setIsRule(true);
		o5.setName("no smoking");
		o5.addAccomodation(a1);

		Option o6 = new Option();
		o6.setIsRule(true);
		o6.setName("no animals");
		o6.addAccomodation(a2);

		Option o7 = new Option();
		o7.setIsRule(false);
		o7.setName("amenagement PMR");
		o7.addAccomodation(a2);

		Option o8 = new Option();
		o8.setIsRule(false);
		o8.setName("ascenseur");
		o8.addAccomodation(a2);

		o0 = optionRepo.save(o0);
		o1 = optionRepo.save(o1);
		o2 = optionRepo.save(o2);
		o3 = optionRepo.save(o3);
		o4 = optionRepo.save(o4);
		o5 = optionRepo.save(o5);
		o6 = optionRepo.save(o6);
		o7 = optionRepo.save(o7);
		o8 = optionRepo.save(o8);

		PointOfInterest poi = new PointOfInterest();
		poi.setName("Le Capitole");
		poi.setDescription(
				"C'est l'édifice emblématique de la Ville rose : dressé face à la place du Capitole depuis le XVIIIe siècle, il abrite à la fois l'hôtel de ville et le théâtre du Capitole. On le traverse par la cour Henri-IV, derrière le portail central.");
		poi.setNumber("1");
		poi.setStreet("Place du capitole");
		poi.setCity("Toulouse");
		poi.setPostcode("31000");
		poi.setCountry("France");
		poi.setLatitudeDeg(43.602106f);
		poi.setLongitudeDeg(1.43808f);
		poi.addAccomodation(a1);

		PointOfInterest poi1 = new PointOfInterest();
		poi1.setName("Le jardin des plantes");
		poi1.setDescription("C'est un jardin avec des plantes.");
		poi1.setNumber("44");
		poi1.setStreet("rue des fleurs");
		poi1.setCity("Toulouse");
		poi1.setPostcode("31400");
		poi1.setCountry("France");
		poi1.setLatitudeDeg(43.0206f);
		poi1.setLongitudeDeg(1.3808f);
		poi1.addAccomodation(a1);

		PointOfInterest poi2 = new PointOfInterest();
		poi2.setName("Le canal du Midi");
		poi2.setDescription(
				"superbe ligne d'eau s'étirant de Toulouse à la Méditerranée, restera à jamais l'ouvrage le plus magnifiquement sculpté dans la terre sang et or du Languedoc..");
		poi2.setNumber("31");
		poi2.setStreet("avenue les pieds dans l'eau");
		poi2.setCity("Toulouse");
		poi2.setPostcode("31000");
		poi2.setCountry("France");
		poi2.setLatitudeDeg(49.2990629f);
		poi2.setLongitudeDeg(1.3808f);
		poi2.addAccomodation(a);

		poi = pointOfInterestRepo.save(poi);
		poi1 = pointOfInterestRepo.save(poi1);
		poi2 = pointOfInterestRepo.save(poi2);

		Photo p0 = new Photo();
		p0.setAccomodation(a);
		p0.setMainPhoto(true);
		p0.setPath("/chemin/vers/photoPrincipaleResidence.jpg");
		Photo p1 = new Photo();
		p1.setAccomodation(a);
		p1.setMainPhoto(false);
		p1.setPath("/chemin/vers/photoPieceseResidence.jpg");
		Photo p2 = new Photo();
		p2.setAccomodation(a);
		p2.setMainPhoto(false);
		p2.setPath("/chemin/vers/photoCouloirsResidence.jpg");

		Photo p3 = new Photo();
		p3.setAccomodation(a1);
		p3.setMainPhoto(true);
		p3.setPath("/chemin/vers/photoPrincipaleVilla.jpg");
		Photo p4 = new Photo();
		p4.setAccomodation(a1);
		p4.setMainPhoto(false);
		p4.setPath("/chemin/vers/photoPieceseVilla.png");
		Photo p5 = new Photo();
		p5.setAccomodation(a1);
		p5.setMainPhoto(false);
		p5.setPath("/chemin/vers/photoCouloirsVilla.jpg");

		Photo p6 = new Photo();
		p6.setAccomodation(a1);
		p6.setMainPhoto(true);
		p6.setPath("/chemin/vers/photoPrincipaleAppart.png");
		Photo p7 = new Photo();
		p7.setAccomodation(a1);
		p7.setMainPhoto(false);
		p7.setPath("/chemin/vers/photoPieceseAppart.png");
		Photo p8 = new Photo();
		p8.setAccomodation(a1);
		p8.setMainPhoto(false);
		p8.setPath("/chemin/vers/photoCouloirsAppart.jpg");

		p0 = photoRepo.save(p0);
		p1 = photoRepo.save(p1);
		p2 = photoRepo.save(p2);
		p3 = photoRepo.save(p3);
		p4 = photoRepo.save(p4);
		p5 = photoRepo.save(p5);
		p6 = photoRepo.save(p6);
		p7 = photoRepo.save(p7);
		p8 = photoRepo.save(p8);

		CustomPriceDay cpd = new CustomPriceDay();
		cpd.setBasePrice(89.99f);
		cpd.setPersonPrice(44.49f);
		cpd.setAccomodation(a);

		CustomPriceDay cpd1 = new CustomPriceDay();
		cpd.setBasePrice(89.99f);
		cpd.setPersonPrice(44.49f);
		cpd.setAccomodation(a1);

		CustomPriceDay cpd2 = new CustomPriceDay();
		cpd.setBasePrice(189f);
		cpd.setPersonPrice(104f);
		cpd.setAccomodation(a2);

		cpd = customPriceDayRepo.save(cpd);
		cpd1 = customPriceDayRepo.save(cpd1);
		cpd2 = customPriceDayRepo.save(cpd2);

	}

}
