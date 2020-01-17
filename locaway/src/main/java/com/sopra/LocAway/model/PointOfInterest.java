package com.sopra.LocAway.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;

import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Version;

import com.fasterxml.jackson.annotation.JsonView;

@Entity
public class PointOfInterest {

	@Id
	@GeneratedValue
	@JsonView(Views.ViewCommon.class)
	private Long id;
	@Version
	@JsonView(Views.ViewCommon.class)
	private int version;
	@JsonView(Views.ViewCommon.class)
	private String name;
	@JsonView(Views.ViewCommon.class)
	private String description;
	@JsonView(Views.ViewCommon.class)
	private String number;
	@JsonView(Views.ViewCommon.class)
	private String street;
	@JsonView(Views.ViewCommon.class)
	private String city;
	@JsonView(Views.ViewCommon.class)
	private String postcode;
	@JsonView(Views.ViewCommon.class)
	private String country;
	@JsonView(Views.ViewCommon.class)
	private Float latitudeDeg;
	@JsonView(Views.ViewCommon.class)
	private Float longitudeDeg;

	@ManyToMany
	@JsonView(Views.ViewPointOfInterest.class)
	@JoinTable
	private List<Accomodation> accomodations = new ArrayList<Accomodation>();

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
