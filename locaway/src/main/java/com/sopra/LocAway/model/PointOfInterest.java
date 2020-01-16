package com.sopra.LocAway.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;

import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Version;

@Entity
public class PointOfInterest {

	@ManyToMany
	@JoinTable
	private List<Accomodation> accomodations = new ArrayList<Accomodation>();

	@Id
	@GeneratedValue
	private Long id;
	@Version
	private int version;
	private String name;
	private String description;
	private String number;
	private String street;
	private String city;
	private String postcode;
	private String country;
	private Float latitudeDeg;
	private Float longitudeDeg;

	public PointOfInterest() {
		super();
	}
	
	public void addAccomodation(Accomodation a) {
		this.accomodations.add(a);
	}

	public List<Accomodation> getAccomodations() {
		return accomodations;
	}

	public void setAccomodations(List<Accomodation> accomodations) {
		this.accomodations = accomodations;
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
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

	@Override
	public String toString() {
		return "PointOfInterest [id=" + id + ", name=" + name + ", description=" + description + ", number=" + number
				+ ", street=" + street + ", city=" + city + ", country=" + country + "]";
	}

}
