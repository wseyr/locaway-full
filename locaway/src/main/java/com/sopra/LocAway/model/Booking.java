package com.sopra.LocAway.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Version;

@Entity
public class Booking {
	@Id
	@GeneratedValue
	Long id;
	@Version
	private int version;
	boolean isValidated;
	boolean isCancelled;
	Float totalPrice;

	@ManyToOne
	User user;
	@ManyToOne
	Accomodation accomodation;
	@OneToMany(mappedBy = "booking")
	List<BookedDay> bookedDays;
	@OneToMany(mappedBy = "booking")
	List<Contact> contacts;

	public Booking() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public boolean isValidated() {
		return isValidated;
	}

	public void setValidated(boolean isValidated) {
		this.isValidated = isValidated;
	}

	public Float getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(Float totalPrice) {
		this.totalPrice = totalPrice;
	}

	public User getUser() {
		return user;
	}

	public boolean isCancelled() {
		return isCancelled;
	}

	public void setCancelled(boolean isCancelled) {
		this.isCancelled = isCancelled;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Accomodation getAccomodation() {
		return accomodation;
	}

	public void setAccomodation(Accomodation accomodation) {
		this.accomodation = accomodation;
	}

	public List<BookedDay> getBookedDays() {
		return bookedDays;
	}

	public void setBookedDays(List<BookedDay> bookedDays) {
		this.bookedDays = bookedDays;
	}

	public List<Contact> getContacts() {
		return contacts;
	}

	public void setContacts(List<Contact> contacts) {
		this.contacts = contacts;
	}

}
