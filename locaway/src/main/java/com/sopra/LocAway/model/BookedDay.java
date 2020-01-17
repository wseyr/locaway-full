package com.sopra.LocAway.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Version;

import com.fasterxml.jackson.annotation.JsonView;

@Entity
public class BookedDay {
	@Id
	@GeneratedValue
	@JsonView(Views.ViewCommon.class)
	Long id;
	@Version
	@JsonView(Views.ViewCommon.class)
	private int version;
	@JsonView(Views.ViewCommon.class)
	private Date date;

	@ManyToOne
	@JsonView(Views.ViewBookedDay.class)
	private Booking booking;

	public BookedDay() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Booking getBooking() {
		return booking;
	}

	public void setBooking(Booking booking) {
		this.booking = booking;
	}

}
