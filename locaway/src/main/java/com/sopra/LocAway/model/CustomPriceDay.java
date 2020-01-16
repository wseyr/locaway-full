package com.sopra.LocAway.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Version;

@Entity
public class CustomPriceDay {

	@Id
	@GeneratedValue
	private Long id;
	@Version
	private int version;
	private Float basePrice;
	private Float personPrice;
	private Date date;

	@ManyToOne
	private Accomodation accomodation;

	public CustomPriceDay() {
		super();
	}

	public CustomPriceDay(Float basePrice, Float personPrice, Date date) {
		super();
		this.basePrice = basePrice;
		this.personPrice = personPrice;
		this.date = date;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Float getBasePrice() {
		return basePrice;
	}

	public void setBasePrice(Float basePrice) {
		this.basePrice = basePrice;
	}

	public Float getPersonPrice() {
		return personPrice;
	}

	public void setPersonPrice(Float personPrice) {
		this.personPrice = personPrice;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Accomodation getAccomodation() {
		return accomodation;
	}

	public void setAccomodation(Accomodation accomodation) {
		this.accomodation = accomodation;
	}

	@Override
	public String toString() {
		return "CustomPriceDay [id=" + id + ", basePrice=" + basePrice + ", personPrice=" + personPrice + ", date="
				+ date + "]";
	}

}
