package com.sopra.LocAway.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Version;

@Entity
public class Accomodation {
	@Id
	@GeneratedValue
	private Long id;
	@Version
	private int version;
	private String name;
	private String number;
	private String street;
	private String city;
	private String postcode;
	private String country;
	private Float latitudeDeg;
	private Float longitudeDeg;
	private String description;
	private Integer numberOfRooms;
	private Integer maxPersons;
	private boolean isDeleted;
	@Enumerated(EnumType.STRING)
	private EAccomodationType accomodationType;
	private Float defaultBasePrice;
	private Float defaultPersonPrice;

	@OneToMany(mappedBy = "accomodation")
	private List<CustomPriceDay> customPriceDays;

	@OneToMany(mappedBy = "accomodation")
	private List<Bookmark> bookmarks;

	@OneToMany(mappedBy = "accomodation")
	private List<Review> reviews;

	@OneToMany(mappedBy = "accomodation")
	private List<Photo> photos;

	@OneToMany(mappedBy = "accomodation")
	private List<Booking> bookings;

	@ManyToMany(mappedBy = "accomodations")
	private List<Option> options;

	@ManyToMany(mappedBy = "accomodations")
	private List<PointOfInterest> pointOfInterests;

	@ManyToOne
	private User user;

	public Accomodation() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getPostcode() {
		return postcode;
	}

	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public Float getLatitudeDeg() {
		return latitudeDeg;
	}

	public void setLatitudeDeg(Float latitudeDeg) {
		this.latitudeDeg = latitudeDeg;
	}

	public Float getLongitudeDeg() {
		return longitudeDeg;
	}

	public void setLongitudeDeg(Float longitudeDeg) {
		this.longitudeDeg = longitudeDeg;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getNumberOfRooms() {
		return numberOfRooms;
	}

	public void setNumberOfRooms(Integer numberOfRooms) {
		this.numberOfRooms = numberOfRooms;
	}

	public Integer getMaxPersons() {
		return maxPersons;
	}

	public void setMaxPersons(Integer maxPersons) {
		this.maxPersons = maxPersons;
	}

	public boolean isDeleted() {
		return isDeleted;
	}

	public void setDeleted(boolean isDeleted) {
		this.isDeleted = isDeleted;
	}

	public EAccomodationType getAccomodationType() {
		return accomodationType;
	}

	public void setAccomodationType(EAccomodationType accomodationType) {
		this.accomodationType = accomodationType;
	}

	public Float getDefaultBasePrice() {
		return defaultBasePrice;
	}

	public void setDefaultBasePrice(Float defaultBasePrice) {
		this.defaultBasePrice = defaultBasePrice;
	}

	public Float getDefaultPersonPrice() {
		return defaultPersonPrice;
	}

	public void setDefaultPersonPrice(Float defaultPersonPrice) {
		this.defaultPersonPrice = defaultPersonPrice;
	}

	public List<CustomPriceDay> getCustomPriceDays() {
		return customPriceDays;
	}

	public void setCustomPriceDays(List<CustomPriceDay> customPriceDays) {
		this.customPriceDays = customPriceDays;
	}

	public List<Bookmark> getBookmarks() {
		return bookmarks;
	}

	public void setBookmarks(List<Bookmark> bookmarks) {
		this.bookmarks = bookmarks;
	}

	public List<Review> getReviews() {
		return reviews;
	}

	public void setReviews(List<Review> reviews) {
		this.reviews = reviews;
	}

	public List<Photo> getPhotos() {
		return photos;
	}

	public void setPhotos(List<Photo> photos) {
		this.photos = photos;
	}

	public List<Booking> getBookings() {
		return bookings;
	}

	public void setBookings(List<Booking> bookings) {
		this.bookings = bookings;
	}

	public List<Option> getOptions() {
		return options;
	}

	public void setOptions(List<Option> options) {
		this.options = options;
	}

	public List<PointOfInterest> getPointOfInterests() {
		return pointOfInterests;
	}

	public void setPointOfInterests(List<PointOfInterest> pointOfInterests) {
		this.pointOfInterests = pointOfInterests;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
