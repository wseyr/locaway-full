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

import com.fasterxml.jackson.annotation.JsonView;
import com.sopra.LocAway.exception.NotFoundException;
import com.sopra.LocAway.model.Accomodation;
import com.sopra.LocAway.model.Views;
import com.sopra.LocAway.repository.IAccomodationRepository;

@RestController
@RequestMapping("/accomodation")
@CrossOrigin("*")
public class AccomodationRestController {

	@Autowired
	private IAccomodationRepository accomodationRepo;
	
	@GetMapping("")
	@JsonView(Views.ViewAccomodation.class)
	public List<Accomodation> list() {
		List<Accomodation> accomodations = accomodationRepo.findAll();

		return accomodations;
	}

	@GetMapping("/{id}")
	@JsonView(Views.ViewAccomodation.class)
	public Accomodation find(@PathVariable Long id) {
		Optional<Accomodation> opt = accomodationRepo.findById(id);

		if (opt.isPresent()) {
			return opt.get();
		} else {
			throw new NotFoundException();
		}
	}

	@PostMapping("")
	@JsonView(Views.ViewAccomodation.class)
	public Accomodation create(@RequestBody Accomodation accomodation) {
		accomodation = accomodationRepo.save(accomodation);

		return accomodation;
	}

	@PutMapping("/{id}")
	@JsonView(Views.ViewAccomodation.class)
	public Accomodation update(@RequestBody Accomodation accomodation, @PathVariable Long id) {
		accomodation = accomodationRepo.save(accomodation);

		return accomodation;
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		accomodationRepo.deleteById(id);
	}

}	

