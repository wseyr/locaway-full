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
import com.sopra.LocAway.model.PointOfInterest;
import com.sopra.LocAway.repository.IPointOfInterestRepository;

@RestController
@RequestMapping("/pointOfInterest")
@CrossOrigin("*")
public class PointOfInterestRestController {

	@Autowired
	private IPointOfInterestRepository pointOfInterestRepo;
	
	@GetMapping("")
	public List<PointOfInterest> list() {
		List<PointOfInterest> pointOfInterests = pointOfInterestRepo.findAll();

		return pointOfInterests;
	}

	@GetMapping("/{id}")
	public PointOfInterest find(@PathVariable Long id) {
		Optional<PointOfInterest> opt = pointOfInterestRepo.findById(id);

		if (opt.isPresent()) {
			return opt.get();
		} else {
			throw new NotFoundException();
		}
	}

	@PostMapping("")
	public PointOfInterest create(@RequestBody PointOfInterest pointOfInterest) {
		pointOfInterest = pointOfInterestRepo.save(pointOfInterest);

		return pointOfInterest;
	}

	@PutMapping("/{id}")
	public PointOfInterest update(@RequestBody PointOfInterest pointOfInterest, @PathVariable Long id) {
		pointOfInterest = pointOfInterestRepo.save(pointOfInterest);

		return pointOfInterest;
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		pointOfInterestRepo.deleteById(id);
	}

}	

