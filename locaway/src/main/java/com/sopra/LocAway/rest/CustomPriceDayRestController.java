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
import com.sopra.LocAway.model.CustomPriceDay;
import com.sopra.LocAway.repository.ICustomPriceDayRepository;

@RestController
@RequestMapping("/customPriceDay")
@CrossOrigin("*")
public class CustomPriceDayRestController {

	@Autowired
	private ICustomPriceDayRepository customPriceDayRepo;
	
	@GetMapping("")
	public List<CustomPriceDay> list() {
		List<CustomPriceDay> customPriceDays = customPriceDayRepo.findAll();

		return customPriceDays;
	}

	@GetMapping("/{id}")
	public CustomPriceDay find(@PathVariable Long id) {
		Optional<CustomPriceDay> opt = customPriceDayRepo.findById(id);

		if (opt.isPresent()) {
			return opt.get();
		} else {
			throw new NotFoundException();
		}
	}

	@PostMapping("")
	public CustomPriceDay create(@RequestBody CustomPriceDay customPriceDay) {
		customPriceDay = customPriceDayRepo.save(customPriceDay);

		return customPriceDay;
	}

	@PutMapping("/{id}")
	public CustomPriceDay update(@RequestBody CustomPriceDay customPriceDay, @PathVariable Long id) {
		customPriceDay = customPriceDayRepo.save(customPriceDay);

		return customPriceDay;
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		customPriceDayRepo.deleteById(id);
	}

}	

