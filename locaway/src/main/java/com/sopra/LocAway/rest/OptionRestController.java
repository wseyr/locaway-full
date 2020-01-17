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
import com.sopra.LocAway.model.Option;
import com.sopra.LocAway.model.Views;
import com.sopra.LocAway.repository.IOptionRepository;

@RestController
@RequestMapping("/option")
@CrossOrigin("*")
public class OptionRestController {

	@Autowired
	private IOptionRepository optionRepo;
	
	@GetMapping("")
	@JsonView(Views.ViewOption.class)
	public List<Option> list() {
		List<Option> options = optionRepo.findAll();

		return options;
	}

	@GetMapping("/{id}")
	@JsonView(Views.ViewOption.class)
	public Option find(@PathVariable Long id) {
		Optional<Option> opt = optionRepo.findById(id);

		if (opt.isPresent()) {
			return opt.get();
		} else {
			throw new NotFoundException();
		}
	}

	@PostMapping("")
	@JsonView(Views.ViewOption.class)
	public Option create(@RequestBody Option option) {
		option = optionRepo.save(option);

		return option;
	}

	@PutMapping("/{id}")
	@JsonView(Views.ViewOption.class)
	public Option update(@RequestBody Option option, @PathVariable Long id) {
		option = optionRepo.save(option);

		return option;
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		optionRepo.deleteById(id);
	}

}	

