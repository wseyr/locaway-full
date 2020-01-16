package com.sopra.LocAway.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sopra.LocAway.model.Contact;

public interface IContactRepository extends JpaRepository<Contact, Long> {

}
