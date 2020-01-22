package com.sopra.LocAway;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.sopra.LocAway.model.Accomodation;
import com.sopra.LocAway.model.BookedDay;
import com.sopra.LocAway.model.Booking;
import com.sopra.LocAway.model.Bookmark;
import com.sopra.LocAway.model.Contact;
import com.sopra.LocAway.model.CustomPriceDay;
import com.sopra.LocAway.model.EAccomodationType;
import com.sopra.LocAway.model.Option;
import com.sopra.LocAway.model.Photo;
import com.sopra.LocAway.model.PointOfInterest;
import com.sopra.LocAway.model.Review;
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
		u.setEmail("steven@gmail.com");
		u.setPassword("motdepasse");
		u.setPhoneNumber("0560606060");
		u.setFirstName("Steven");
		u.setLastName("Jobs");

		User u1 = new User();
		u1.setAdmin(true);
		u1.setEmail("adminlocaway@yahoo.com");
		u1.setPassword("topsecret");
		u1.setPhoneNumber("0567891234");
		u1.setFirstName("Admin");
		u1.setLastName("Admin");

		User u2 = new User();
		u2.setAdmin(false);
		u2.setEmail("javadev@oracle.com");
		u2.setPassword("azerty");
		u2.setPhoneNumber("012345678");
		u2.setFirstName("John");
		u2.setLastName("Smith");
		
		User u3 = new User();
		u3.setAdmin(false);
		u3.setEmail("a");
		u3.setPassword("a");
		u3.setPhoneNumber("0613315267");
		u3.setFirstName("Thierry");
		u3.setLastName("Dupont");

		u= userRepo.save(u);
		u1 = userRepo.save(u1);
		u2 = userRepo.save(u2);
		u3 = userRepo.save(u3);
		
		
		String sdl = System.getProperty("line.separator");
		
		Accomodation a = new Accomodation();
		a.setName("Résidence des hirondelles");
		a.setNumber("25");
		a.setStreet("allée de cherbourg");
		a.setCity("Toulouse");
		a.setPostcode("31000");
		a.setCountry("France");
		a.setLatitudeDeg(43.595282f);
		a.setLongitudeDeg(1.429806f);
		
		a.setDescription("Pour 4 personnes\r\n" + 
				"très calme donnant sur une cour intérieure ( pas sur rue)\r\n" + 
				"terrasse non privative devant le logement\r\n" + 
				"exposé sud-est avec vue sur montagne\r\n" + 
				"séjour/cuisine\r\n" + 
				"coin nuit avec\r\n" + 
				"lit 140 + 1 mezzanine 2 places\r\n" + 
				"salle de bains avec douche\r\n" + 
				"chauffage électrique ( à régler en hiver)\r\n" + 
				"cellier pour rangements divers\r\n" + 
				"animaux non admis\r\n" + 
				"proche de l'accès télécabine pour le ski\r\n" + 
				"très proche des thermes pour cure\r\n" + 
				"très facile d'accès pour le centre ville et commerces\r\n" + 
				"JANVIER la semaine du samedi au samedi 190€\r\n" + 
				"hors vacances scolaires la semaine 190€\r\n" + 
				"pendant vacances scolaires 220€");
		a.setNumberOfRooms(12);
		a.setMaxPersons(30);
		a.setDeleted(false);
		a.setAccomodationType(EAccomodationType.APPARTMENT);
		a.setDefaultBasePrice(65f);
		a.setDefaultPersonPrice(5f);
		a.setUser(u);

		Accomodation a1 = new Accomodation();
		a1.setName("Villa des calanques");
		a1.setNumber("67");
		a1.setStreet("Boulevard des airs");
		a1.setCity("Toulouse");
		a1.setPostcode("31000");
		a1.setCountry("France");
		a1.setLatitudeDeg(43.5865373f);
		a1.setLongitudeDeg(1.4385796f);
		a1.setDescription("-Location ouverte d’avril à décembre 2020 - Classé gîte de France.\r\n" + sdl +
				"-Adhésion Destifrance : maison pouvant accueillir personne à mobilité réduite." +  sdl + 
				"Piscine en bois semi enterré clôturé, profondeur 1.20m diamètre 5.80m. Le gîte+piscine est entièrement pour les vacanciers. La piscine est ouverte de juin jusqu'à fin septembre selon la météo.\r\n" + sdl +
				"-Dans le Haut Quercy, cette charmante maison de 120 m² d’habitable avec un jardin clos, vous accueille pour vos vacances dans le Lot.\r\n" + sdl+
				"Elle est située au calme, sur les hauteurs du village de Condat (450m du bourg) et vous apportera tout le confort pour passer d'agréables moments en famille, entre amis.\r\n" + sdl+
				"-Rez de chaussée, 1 grande pièce à vivre avec cuisine intégrée+1chambre avec lit 140+1salle de bain+1wc séparé+1cellier.\r\n" + sdl+
				"-A l'étage: 2 chambres avec lit 140+1grande chambre avec 1 lit 140 et 1 lit de 120+1salle de bain avec wc.\r\n" + sdl+
				"Le linge de maison n’est pas fourni (drap+taie d’oreiller)\r\n" +sdl+ 
				"-Equipement: Four, lave vaisselle, lave linge, micro-ondes, cafetière, grille pain, bouilloire, télévision, radio cd, congélateur, barbecue, table+fer à repasser,2 lits parapluies,1 baignoire bébé salon de jardin .\r\n" + 
				"-Jeux loisirs: table ping-pong, balançoire, trampoline, jeux société, 1 jeu de 8 boules de pétanque, livres enfant.\r\n" + 
				"-Etant entouré par certains de nos plus beaux villages et sites de FRANCE, Condat est le point idéal de départ pour de nombreuses visites: Rocamadour, le Gouffre de Padirac, Les Cascades d'Autoire, Loubressac, Turenne, Martel, Collonges la Rouge, Curemonte etc..\r\n" + 
				"-A proximité, pour vos loisirs, vous trouverez: 1 parc aquatique, 1 parc accro branche, 1centre équestre, terrains de golf+tennis, des chemins de randonnée, un casino etc. Faire aussi la descente de la Dordogne en canoë\r\n" + 
				"-Tous les soirs de la semaine vous pourrez déguster nos produits régionaux dans une bonne ambiance grâce aux marchés de Pays.\r\n" + 
				"-Nous mettrons à votre disposition toute la documentation concernant les manifestations durant votre séjour.\r\n" + 
				"-Tous commerces et services à 2 KMS\r\n" + 
				"\r\n" + 
				"Maison non fumeur & petits animaux admis\r\n" + 
				"\r\n" + 
				"Nos tarifs sont les suivants :\r\n" + 
				"\r\n" + 
				"Printemps-automne 2020 :\r\n" + 
				"La semaine :\r\n" + 
				"2 pers, 180€ au-delà 20€ par pers supplémentaire\r\n" + 
				"Le week-end:\r\n" + 
				"1 nuit 50€ pour 2 pers et 40€ pour 2 pers sup.\r\n" + 
				"2nuits 80€ pour 2 pers et 70€ pour 2 pers sup.\r\n" + 
				"1 nuit 120€ pour 6 pers, au-delà 10€ par pers sup.\r\n" + 
				"2 nuits 160€ pour 6 pers, au-delà 10€ par pers sup.\r\n" + 
				"\r\n" + 
				"ETE 2020:\r\n" + 
				"Du 27-06 au 04-07 : 450€ pour 6 pers au-delàs 20 € par pers sup.\r\n" + 
				"Juillet à partir du 04-07 : 750€ jusqu’à 6 pers au-delà 25€ par pers sup.\r\n" + 
				"Août 750€ jusqu’à 6 pers au-delà 25€ par pers sup.\r\n" + 
				"La location s’effectue du samedi arrivé 16h au samedi départ à 10h.\r\n" + 
				"\r\n" + 
				"Contact par téléphone:\r\n" + 
				"06 45 81 07 85\r\n" + 
				"Maison secondaire.");
		a1.setNumberOfRooms(23445);
		a1.setMaxPersons(876896786);
		a1.setDeleted(false);
		a1.setAccomodationType(EAccomodationType.APPARTMENT);
		a1.setDefaultBasePrice(150f);
		a1.setDefaultPersonPrice(5f);
		a1.setUser(u1);

		Accomodation a2 = new Accomodation();
		a2.setName("Maison d'hôte chaleureuse");
		a2.setNumber("221B");
		a2.setStreet("Baker Street");
		a2.setCity("Londres");
		a2.setPostcode("WC2N 5DU");
		a2.setCountry("Angleterre");
		a2.setLatitudeDeg(4.5f);
		a2.setLongitudeDeg(1.5f);
		a2.setDescription("Situé au Sud-Ouest de Londres à 40mn de l'aéroport international . Isolé en haut d'un côteau avec vue imprenable sur les Pyrénées et situé dans un parc arboré de 1.4 ha. A 3 km du village avec tous commerces.\r\n" + 
				"\r\n" + 
				"4 chambres d'hôtes avec salle de douche et WC privatifs, salle commune. Elles sont mitoyennes à 3 gîtes ruraux (3/5 p.et 4/6 p.) d'environ 50m2 chaqu'un, une grande loggiaa réservée aux hôtes.\r\n" + 
				"\r\n" + 
				"Table d'Hôtes 23 € /pers. - de 12 ans 12 €.\r\n" + 
				"\r\n" + 
				"A 60 km de Toulouse, 35 km de Auch et 40 km de St Gaudens.\r\n" + 
				"- tourisme de loisirs comme les parcs d'attractions, les stations thermales, les stations de ski, ...\r\n" + 
				"- tourisme culturel comme les sites archéologiques, les châteaux, les abbayes, les cathédrales Auch et St Bertrand de Comminges, les musées, ...\r\n" + 
				"- tourisme animalier comme le parc zoologiques de Plaisance du Touche.\r\n" + 
				"- tourisme sportif comme les sentiers de grande randonnée.\r\n" + 
				"- tourisme gastronomique comme les spécialités régionales, Canard (Marché de Gimont ou de Samatan), le veau élevé sous la mère ...");
		a2.setNumberOfRooms(4);
		a2.setMaxPersons(8);
		a2.setDeleted(false);
		a2.setAccomodationType(EAccomodationType.GUESTHOUSE);
		a2.setDefaultBasePrice(1500f);
		a2.setDefaultPersonPrice(310f);
		a2.setUser(u2);
		
		
			
		Accomodation a3 = new Accomodation();
		a3.setName("Chaleureux loft");
		a3.setNumber("12");
		a3.setStreet("rue du chêne");
		a3.setCity("Camaran");
		a3.setPostcode("31840");
		a3.setCountry("France");
		a3.setLatitudeDeg(43.793282f);
		a3.setLongitudeDeg(1.429806f);
		a3.setDescription("Appartement 2 pièces rez de chaussé,avec cuisine intégrée et spacieuse avec un grand four et grand réfrigérateur et congélateur chambre indépendante de la cuisine salle d'eau indépendante des WC , parking privative et ombragé. surface habitable 26 m² + terrasse . Appartement refait a neuf 2019 literie neuve, buanderie gratuite à proximité tarif cure\r\n" + 
				"540 € mars et novembre\r\n" + 
				"580€ d'avril à octobre");
		a3.setNumberOfRooms(3);
		a3.setMaxPersons(12);
		a3.setDeleted(false);
		a3.setAccomodationType(EAccomodationType.APPARTMENT);
		a3.setDefaultBasePrice(20f);
		a3.setDefaultPersonPrice(10f);
		a3.setUser(u);
		
		Accomodation a4 = new Accomodation();
		a4.setName("Grand et bel appartement dans Maison Bigourdane");
		a4.setNumber("27");
		a4.setStreet("Rue de la vallée");
		a4.setCity("Aas");
		a4.setPostcode("64971");
		a4.setCountry("France");
		a4.setLatitudeDeg(43.595282f);
		a4.setLongitudeDeg(1.429806f);
		a4.setDescription("Semaine 7 soldée à 600 euros au lieu de 750 euros.\r\n" + 
				"\r\n" + 
				"Location de Standing.\r\n" + 
				"Trois Etoiles Meublé de Tourisme.\r\n" + 
				"5 Diamants Par OT .\r\n" + 
				"Entrée Barèges à Sers « Quartier de Barzun ».\r\n" + 
				"----------------------------------\r\n" + 
				"Dans grande Maison Bigourdane d’époque ( vers 1800 ), en position dominante, au centre d’un domaine de 7 ha, un appartement indépendant de 73 M2 en duplex pour 4 – 5 Personnes refait récemment avec grand goût, classé 3 *** Meublé de Tourisme et 5 diamants par l’ Office du Tourisme Vallées de Gavarnie.\r\n" + 
				"Située, versant soleil, des vues à 360° s’offrent à vous.\r\n" + 
				"Sécurité pour enfants assurée. Vous arrivez en voiture devant la porte.\r\n" + 
				"Grands parkings plats privés de vers : 1000 M2 à l’avant et 700 m2 à l’arrière. Un luxe en montagne. Navette à 100 M l’hiver. Et 80 M pour les Thermes l’été. 15 Minutes à pied du centre de Barèges par le chemin Thermal.\r\n" + 
				"Cuisine indépendante équipée moderne et très complète de 12 M2 au sol , donnant sur une grande pièce de vie de vers 30 m2 avec WC. Possibilités utilisation du poêle moderne. 60 DM3 de bois offert puis 10 Euros le panier.\r\n" + 
				"A l’étage, deux chambres de 15 M2 et 9 M2, salle de bain, Cabine douche avec WC.\r\n" + 
				"Equipements modernes, meubles de qualité, dans un cadre splendide.\r\n" + 
				"Réception Wifi gratuite.\r\n" + 
				"Télévisions : écran plat ( 80 cms dans la salle commune ) et LED ( 56 cms dans la grande chambre ) , lecteur CD - DVD.\r\n" + 
				"Locations Week- end , 2 nuits ou plus possibles en fonction des disponibilités :\r\n" + 
				"Périodes Creuses : 2 nuits = 200 E + 100 E la nuit pour cours séjour.\r\n" + 
				"Périodes Rouges, si libre : 150 Euros la nuit, soit 37, 5 E par personne, base 4 personnes.\r\n" + 
				"Prendre contact pour de plus amples renseignements et visite de notre site.\r\n" + 
				"Prix Eté : entre 500 à 600 E la semaine suivant périodes.\r\n" + 
				"Cures de 21 Jours entre 750 à 1000 E.\r\n" + 
				"Prix Hiver : entre 500 à 750 E la semaine suivant les périodes.\r\n" + 
				"Réservez hors vacances, c’est moins cher.\r\n" + 
				"Prix spécial Cure Thermale : Pour 2 personnes. Entre 750 à 1000 Euros les 21 jours suivant les périodes.");
		a4.setNumberOfRooms(1);
		a4.setMaxPersons(2);
		a4.setDeleted(false);
		a4.setAccomodationType(EAccomodationType.APPARTMENT);
		a4.setDefaultBasePrice(45f);
		a4.setDefaultPersonPrice(2f);
		a4.setUser(u);
		
		Accomodation a5 = new Accomodation();
		a5.setName("Yourte ");
		a5.setNumber("25");
		a5.setStreet("allée de cherbourg");
		a5.setCity("Toulouse");
		a5.setPostcode("31000");
		a5.setCountry("France");
		a5.setLatitudeDeg(43.595282f);
		a5.setLongitudeDeg(1.429806f);
		a5.setDescription("AU BOIS D'ESCOUMOS\r\n" + 
				"\r\n" + 
				"HEBERGEMENT ECO-CITOYEN\r\n" + 
				"\r\n" + 
				"Pour plus d'informations et de photos\r\n" + 
				"rechercher\r\n" + 
				"au bois d'escoumos\r\n" + 
				"\r\n" + 
				"Ouvert depuis le 9 juillet 2011 d’un site\r\n" + 
				"respectueux de l’environnement.\r\n" + 
				"\r\n" + 
				"Situé aux portes du Gers et des\r\n" + 
				"Hautes-Pyrénées, venez\r\n" + 
				"découvrir la tranquillité et le\r\n" + 
				"calme ambiant sous une de nos trois Yourtes\r\n" + 
				"Mongoles équipées de meubles\r\n" + 
				"traditionnels et d'un poêle à bois,\r\n" + 
				"installées dans un bois de plus de 2\r\n" + 
				"hectares, vous pourrez admirer la chaîne des\r\n" + 
				"Pyrénées et le coucher du soleil sur\r\n" + 
				"la vallée des\r\n" + 
				"Hautes-Pyrénées.\r\n" + 
				"\r\n" + 
				"Un vrai bol d’air au plus près de la\r\n" + 
				"nature.\r\n" + 
				"\r\n" + 
				"Possibilité de repas et petit\r\n" + 
				"déjeuner concoctés par un Chef de cuisine.\r\n" + 
				"\r\n" + 
				"DEUX YOURTES DE 27 M² de 1 à 4\r\n" + 
				"personnes\r\n" + 
				"TARIF POUR DEUX PERSONNES\r\n" + 
				"\r\n" + 
				"vacances scolaires\r\n" + 
				"67 € la nuit, 402 € la semaine\r\n" + 
				"hors vacances\r\n" + 
				"57 € la nuit, 342 € la semaine\r\n" + 
				"Personne supplémentaire 13 €\r\n" + 
				"\r\n" + 
				"UNE YOURTE DE 35 M² de 1 à 6 personnes\r\n" + 
				"TARIF POUR DEUX PERSONNES\r\n" + 
				"\r\n" + 
				"vacances scolaires\r\n" + 
				"77 € la nuit, 462 € la semaine\r\n" + 
				"hors vacances\r\n" + 
				"67 € la nuit, 402 € la semaine\r\n" + 
				"Personne supplémentaire 13 €\r\n" + 
				"\r\n" + 
				"Taxe de séjour : 0€22 par nuit et par\r\n" + 
				"personne\r\n" + 
				"repas : 30 € par personne, enfant – de 10 ans\r\n" + 
				"à 15 €\r\n" + 
				"Panier petit déjeuner « maison»\r\n" + 
				"10 €\r\n" + 
				"location de linge : 10 € lit de 2 pers, 8 € lit de\r\n" + 
				"1 pers\r\n" + 
				"\r\n" + 
				"Possibilité de massage et de Qi Gong sur\r\n" + 
				"réservation\r\n" + 
				"\r\n" + 
				"Accès piscine, espace jeux, poules,\r\n" + 
				"âne, brebis et chèvre en\r\n" + 
				"libertés, très gourmands de pain\r\n" + 
				"dur, n'hésitez pas à en apporter !!\r\n" + 
				"\r\n" + 
				"Au plaisir de vous accueillir");
		a5.setNumberOfRooms(1);
		a5.setMaxPersons(4);
		a5.setDeleted(false);
		a5.setAccomodationType(EAccomodationType.ALTERNATIVE);
		a5.setDefaultBasePrice(67f);
		a5.setDefaultPersonPrice(10f);
		a5.setUser(u);

		a = accomodationRepo.save(a);
		a1 = accomodationRepo.save(a1);
		a2 = accomodationRepo.save(a2);
		a3 = accomodationRepo.save(a3);
		a4 = accomodationRepo.save(a4);
		a5 = accomodationRepo.save(a5);

		Option o0 = new Option();
		o0.setIsRule(false);
		o0.setName("Cheminée");

		Option o1 = new Option();
		o1.setIsRule(false);
		o1.setName("Balcon");

		Option o2 = new Option();
		o2.setIsRule(false);
		o2.setName("Jardin");

		Option o3 = new Option();
		o3.setIsRule(false);
		o3.setName("Piscine");

		Option o4 = new Option();
		o4.setIsRule(false);
		o4.setName("Fibre");

		Option o5 = new Option();
		o5.setIsRule(true);
		o5.setName("Non fumeur");

		Option o6 = new Option();
		o6.setIsRule(true);
		o6.setName("Animaux non acceptés");

		Option o7 = new Option();
		o7.setIsRule(false);
		o7.setName("Aménagement PMR");

		Option o8 = new Option();
		o8.setIsRule(false);
		o8.setName("Ascenseur");

		o0 = optionRepo.save(o0);
		o1 = optionRepo.save(o1);
		o2 = optionRepo.save(o2);
		o3 = optionRepo.save(o3);
		o4 = optionRepo.save(o4);
		o5 = optionRepo.save(o5);
		o6 = optionRepo.save(o6);
		o7 = optionRepo.save(o7);
		o8 = optionRepo.save(o8);
		
		a.addOption(o0);
		a.addOption(o1);
		a.addOption(o2);
		a1.addOption(o3);
		a1.addOption(o4);
		a1.addOption(o5);
		a2.addOption(o6);
		a2.addOption(o7);
		a2.addOption(o8);
		
		a = accomodationRepo.save(a);
		a1 = accomodationRepo.save(a1);
		a2 = accomodationRepo.save(a2);
		
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
				"Superbe ligne d'eau s'étirant de Toulouse à la Méditerranée, restera à jamais l'ouvrage le plus magnifiquement sculpté dans la terre sang et or du Languedoc..");
		poi2.setNumber("31");
		poi2.setStreet("avenue du canal");
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
		p0.setPath("https://odis.homeaway.com/odis/listing/9dfcf337-7086-4627-883f-2615eb5d6297.f6.jpg");
		Photo p1 = new Photo();
		p1.setAccomodation(a);
		p1.setMainPhoto(false);
		p1.setPath("https://q-cf.bstatic.com/images/hotel/max1024x768/121/121148855.jpg");
		Photo p2 = new Photo();
		p2.setAccomodation(a);
		p2.setMainPhoto(false);
		p2.setPath("https://www.wilderkaiser.info/feratel/hotel/large/ellmau-appartment-nina-hanna3.jpg");

		Photo p3 = new Photo();
		p3.setAccomodation(a1);
		p3.setMainPhoto(true);
		p3.setPath("https://r-cf.bstatic.com/images/hotel/max1024x768/459/45999850.jpg");
		Photo p4 = new Photo();
		p4.setAccomodation(a1);
		p4.setMainPhoto(false);
		p4.setPath("https://q-cf.bstatic.com/images/hotel/max1024x768/960/96080127.jpg");
		Photo p5 = new Photo();
		p5.setAccomodation(a1);
		p5.setMainPhoto(false);
		p5.setPath("https://www.sintbernardus.be/images/photolib/1000x500c/1163/guesthouse-brouwershuis.jpg");
		Photo p6 = new Photo();
		p6.setAccomodation(a1);
		p6.setMainPhoto(true);
		p6.setPath("https://q-xx.bstatic.com/images/hotel/max1024x768/183/183776257.jpg");
		Photo p7 = new Photo();
		p7.setAccomodation(a1);
		p7.setMainPhoto(false);
		p7.setPath("https://www.manusurf.com/wp-content/uploads/2017/06/hebergement-surfcamp-guesthouse-le-bernard-936x668.jpg");
		Photo p8 = new Photo();
		p8.setAccomodation(a1);
		p8.setMainPhoto(false);
		p8.setPath("https://foto.hrsstatic.com/fotos/0/3/1090/700/80/000000/http%3A%2F%2Ffoto-origin.hrsstatic.com%2Ffoto%2F5%2F8%2F1%2F6%2F581683%2F581683_su_9255717.jpg/1ndI7Kf74D1Il1VvYrQoOw%3D%3D/3734,2832/6/Kalipeh_SAP_Guesthouse-Walldorf-Suite-1-581683.jpg");

		Photo p9 = new Photo();
		p9.setAccomodation(a2);
		p9.setMainPhoto(true);
		p9.setPath("https://q-cf.bstatic.com/images/hotel/max1024x768/117/117288599.jpg");
		
		Photo p10 = new Photo();
		p10.setAccomodation(a3);
		p10.setMainPhoto(true);
		p10.setPath("https://cdngeneral.rentcafe.com/dmslivecafe/3/654967/TheFLAT_Model_Overall_WEB(1).jpg?crop=(0,0,300,200)&cropxunits=300&cropyunits=200&quality=85&scale=both&");
		
		Photo p11 = new Photo();
		p11.setAccomodation(a4);
		p11.setMainPhoto(true);
		p11.setPath("http://www.foyers-bef.fr/images/realizations/BeF-Flat-6_m.jpg");
		
		Photo p12 = new Photo();
		p12.setAccomodation(a5);
		p12.setMainPhoto(true);
		p12.setPath("https://consultation.avocat.fr/userfiles/articles/38399-20190530-145249-yourte.jpg");
		
		p0 = photoRepo.save(p0);
		p1 = photoRepo.save(p1);
		p2 = photoRepo.save(p2);
		p3 = photoRepo.save(p3);
		p4 = photoRepo.save(p4);
		p5 = photoRepo.save(p5);
		p6 = photoRepo.save(p6);
		p7 = photoRepo.save(p7);
		p8 = photoRepo.save(p8);
		p9 = photoRepo.save(p9);
		p10 = photoRepo.save(p10);
		p11 = photoRepo.save(p11);
		p12 = photoRepo.save(p12);

		
		CustomPriceDay cpda = new CustomPriceDay();
		cpda.setBasePrice(750.99f);
		cpda.setPersonPrice(120f);
		cpda.setAccomodation(a);
		Date cpdaDate = new GregorianCalendar(2020, Calendar.MARCH, 2).getTime();
		cpda.setDate(cpdaDate);
		CustomPriceDay cpd1a = new CustomPriceDay();
		cpd1a.setBasePrice(750.99f);
		cpd1a.setPersonPrice(120f);
		cpd1a.setAccomodation(a);
		Date cpd1aDate = new GregorianCalendar(2020, Calendar.MARCH, 3).getTime();
		cpd1a.setDate(cpd1aDate);
		CustomPriceDay cpd2a = new CustomPriceDay();
		cpd2a.setBasePrice(750.99f);
		cpd2a.setPersonPrice(120f);
		cpd2a.setAccomodation(a);
		Date cpd2aDate = new GregorianCalendar(2020, Calendar.MARCH, 4).getTime();
		cpd2a.setDate(cpd2aDate);

		CustomPriceDay cpd1 = new CustomPriceDay();
		cpd1.setBasePrice(89.99f);
		cpd1.setPersonPrice(44.49f);
		cpd1.setAccomodation(a1);
		Date cpdDate1 = new GregorianCalendar(2020, Calendar.FEBRUARY, 5).getTime();
		cpd1.setDate(cpdDate1);

		CustomPriceDay cpd2 = new CustomPriceDay();
		cpd2.setBasePrice(189f);
		cpd2.setPersonPrice(104f);
		cpd2.setAccomodation(a2);
		Date cpdDate2 = new GregorianCalendar(2020, Calendar.FEBRUARY, 6).getTime();
		cpd2.setDate(cpdDate2);

		cpda = customPriceDayRepo.save(cpda);
		cpd1a = customPriceDayRepo.save(cpd1a);
		cpd2a = customPriceDayRepo.save(cpd2a);
		cpd1 = customPriceDayRepo.save(cpd1);
		cpd2 = customPriceDayRepo.save(cpd2);
		
		Bookmark bkm =new Bookmark();
		bkm.setAccomodation(a);
		bkm.setUser(u1);
		
		Bookmark bkm1 =new Bookmark();
		bkm1.setAccomodation(a1);
		bkm1.setUser(u2);
		
		Bookmark bkm2 =new Bookmark();
		bkm2.setAccomodation(a2);
		bkm2.setUser(u);
		
		Bookmark bkm3 =new Bookmark();
		bkm2.setAccomodation(a);
		bkm2.setUser(u2);
		
		Bookmark bkm4 =new Bookmark();
		bkm2.setAccomodation(a2);
		bkm2.setUser(u2);
		
		bkm = bookmarkRepo.save(bkm);
		bkm1 = bookmarkRepo.save(bkm1);
		bkm2 = bookmarkRepo.save(bkm2);
		bkm3 = bookmarkRepo.save(bkm3);
		bkm4 = bookmarkRepo.save(bkm4);
		
		Review r = new Review();
		r.setGrade(2);
		r.setText("C T NUL ^^");
		r.setAccomodation(a);
		r.setUser(u2);

		Review r1 = new Review();
		r1.setGrade(5);
		r1.setText("Parfait changez rien !!!");
		r1.setAccomodation(a1);
		r1.setUser(u);

		Review r2 = new Review();
		r2.setGrade(3);
		r2.setText("OK");
		r2.setAccomodation(a2);
		r2.setUser(u1);

		r = reviewRepo.save(r);
		r1 = reviewRepo.save(r1);
		r2 = reviewRepo.save(r2);
		
		Booking b = new Booking();
		b.setValidated(false);
		b.setCancelled(false);
		b.setAccomodation(a);
		b.setUser(u);
		b.setTotalPrice(512.22f);
		
		Booking b1 = new Booking();
		b1.setValidated(true);
		b1.setCancelled(false);
		b1.setAccomodation(a1);
		b1.setUser(u1);
		b1.setTotalPrice(128f);
		
		
		

		Booking b2 = new Booking();
		b2.setValidated(false);
		b2.setCancelled(false);
		b2.setAccomodation(a2);
		b2.setUser(u2);
		b2.setTotalPrice(4875f);

		b = bookingRepo.save(b);
		b1 = bookingRepo.save(b1);
		b2 = bookingRepo.save(b2);
		
		Contact c0 = new Contact();
		c0.setEmail("amidea@mail.fr");
		c0.setBooking(b);
		
		Contact c1 = new Contact();
		c1.setEmail("potedea1@mail.fr");
		c1.setBooking(b1);
		
		Contact c2 = new Contact();
		c2.setEmail("familledea2@mail.fr");
		c2.setBooking(b2);
		Contact c3 = new Contact();
		c3.setEmail("smaladea2@mail.fr");
		c3.setBooking(b2);
		
		c0 = contactRepo.save(c0);
		c1 = contactRepo.save(c1);
		c2 = contactRepo.save(c2);
		c3 = contactRepo.save(c3);
		
		BookedDay bd = new BookedDay();
		bd.setBooking(b);
		Date bdDate = new GregorianCalendar(2020, Calendar.FEBRUARY, 11).getTime();
		bd.setDate(bdDate);

		BookedDay bd1 = new BookedDay();
		bd1.setBooking(b1);
		Date bdDate1 = new GregorianCalendar(2020, Calendar.FEBRUARY, 15).getTime();
		bd1.setDate(bdDate1);
		
		BookedDay bd2 = new BookedDay();
		bd2.setBooking(b1);
		Date bdDate2 = new GregorianCalendar(2020, Calendar.FEBRUARY, 16).getTime();
		bd2.setDate(bdDate2);
		
		BookedDay bd3 = new BookedDay();
		bd3.setBooking(b1);
		Date bdDate3 = new GregorianCalendar(2020, Calendar.FEBRUARY, 17).getTime();
		bd3.setDate(bdDate3);
		
		bd = bookedDayRepo.save(bd);
		bd1 = bookedDayRepo.save(bd1);
		bd2 = bookedDayRepo.save(bd2);
		bd3 = bookedDayRepo.save(bd3);
	}

}
