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
import com.sopra.LocAway.model.BookedDay;
import com.sopra.LocAway.model.Views;
import com.sopra.LocAway.repository.IBookedDayRepository;

@RestController
@RequestMapping("/bookedDay")
@CrossOrigin("*")
public class BookedDayRestController {

	@Autowired
	private IBookedDayRepository bookedDayRepo;
	
	@GetMapping("")
	@JsonView(Views.ViewCommon.class)
	public List<BookedDay> list() {
		List<BookedDay> bookedDays = bookedDayRepo.findAll();

		return bookedDays;
	}

	@GetMapping("/{id}")
	@JsonView(Views.ViewCommon.class)
	public BookedDay find(@PathVariable Long id) {
		Optional<BookedDay> opt = bookedDayRepo.findById(id);

		if (opt.isPresent()) {
			return opt.get();
		} else {
			throw new NotFoundException();
		}
	}

	@PostMapping("")
	@JsonView(Views.ViewCommon.class)
	public BookedDay create(@RequestBody BookedDay bookedDay) {
		bookedDay = bookedDayRepo.save(bookedDay);

		return bookedDay;
	}

	@PutMapping("/{id}")
	@JsonView(Views.ViewCommon.class)
	public BookedDay update(@RequestBody BookedDay bookedDay, @PathVariable Long id) {
		bookedDay = bookedDayRepo.save(bookedDay);

		return bookedDay;
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		bookedDayRepo.deleteById(id);
	}

}	

