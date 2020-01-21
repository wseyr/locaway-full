package com.sopra.LocAway.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Version;

import com.fasterxml.jackson.annotation.JsonView;

@Entity
public class Option {
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
	private Boolean isRule;

	@ManyToMany(mappedBy = "options")
	private List<Accomodation> accomodations = new ArrayList<Accomodation>();

	public Option() {
		super();
	}

	public Option(String name, Boolean isRule) {
		super();
		this.name = name;
		this.isRule = isRule;
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

	public Boolean getIsRule() {
		return isRule;
	}

	public void setIsRule(Boolean isRule) {
		this.isRule = isRule;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	public List<Accomodation> getAccomodations() {
		return accomodations;
	}

	public void setAccomodations(List<Accomodation> accomodations) {
		this.accomodations = accomodations;
	}

	@Override
	public String toString() {
		return "Option [id=" + id + ", name=" + name + ", isRule=" + isRule + "]";
	}

}
