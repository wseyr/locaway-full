package com.sopra.LocAway.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Version;

@Entity
public class Review {

	@Id
	@GeneratedValue
	private Long id;
	@Version
	private int version;
	private String text;
	private int grade;

	@ManyToOne
	private Accomodation accomodation;

	@ManyToOne
	private User user;

	public Review() {
		super();
	}

	public Review(String text, int grade, Accomodation accomodation, User user) {
		super();
		this.text = text;
		this.grade = grade;
		this.accomodation = accomodation;
		this.user = user;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public int getGrade() {
		return grade;
	}

	public void setGrade(int grade) {
		this.grade = grade;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public User getUser() {
		return user;
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

}
