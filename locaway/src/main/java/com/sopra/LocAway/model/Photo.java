package com.sopra.LocAway.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Version;

import org.hibernate.annotations.JoinColumnOrFormula;

@Entity
public class Photo {
	@Id
	@GeneratedValue
	private Long id;
	@Version
	private int version;
	private String path;
	private boolean isMainPhoto;

	@ManyToOne
	@JoinColumn
	private Accomodation accomodation;

	public Photo() {
		super();
	}

	public Photo(Long id, String path, boolean isMainPhoto, Accomodation accomodation) {
		super();
		this.id = id;
		this.path = path;
		this.isMainPhoto = isMainPhoto;
		this.accomodation = accomodation;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public boolean isMainPhoto() {
		return isMainPhoto;
	}

	public void setMainPhoto(boolean isMainPhoto) {
		this.isMainPhoto = isMainPhoto;
	}

	public Accomodation getAccomodation() {
		return accomodation;
	}

	public void setAccomodation(Accomodation accomodation) {
		this.accomodation = accomodation;
	}

}
