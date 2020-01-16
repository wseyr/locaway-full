package com.sopra.LocAway.rest;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sopra.LocAway.exception.NotFoundException;
import com.sopra.LocAway.model.Contact;
import com.sopra.LocAway.repository.IContactRepository;

@RestController
@RequestMapping("/contact")
@CrossOrigin("*")
public class ContactRestController {

	@Autowired
	private IContactRepository contactRepo;
	
	@GetMapping("")
	public List<Contact> list() {
		List<Contact> contacts = contactRepo.findAll();

		return contacts;
	}

	@GetMapping("/{id}")
	public Contact find(@PathVariable Long id) {
		Optional<Contact> opt = contactRepo.findById(id);

		if (opt.isPresent()) {
			return opt.get();
		} else {
			throw new NotFoundException();
		}
	}

	@PostMapping("")
	public Contact create(@RequestBody Contact contact) {
		contact = contactRepo.save(contact);

		return contact;
	}

	@PutMapping("/{id}")
	public Contact update(@RequestBody Contact contact, @PathVariable Long id) {
		contact = contactRepo.save(contact);

		return contact;
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		contactRepo.deleteById(id);
	}

}	

