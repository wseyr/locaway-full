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
import com.sopra.LocAway.model.Review;
import com.sopra.LocAway.model.Views;
import com.sopra.LocAway.repository.IReviewRepository;

@RestController
@RequestMapping("/review")
@CrossOrigin("*")
public class ReviewRestController {

	@Autowired
	private IReviewRepository reviewRepo;
	
	@GetMapping("")
	@JsonView(Views.ViewReview.class)
	public List<Review> list() {
		List<Review> reviews = reviewRepo.findAll();

		return reviews;
	}

	@GetMapping("/{id}")
	@JsonView(Views.ViewReview.class)
	public Review find(@PathVariable Long id) {
		Optional<Review> opt = reviewRepo.findById(id);

		if (opt.isPresent()) {
			return opt.get();
		} else {
			throw new NotFoundException();
		}
	}

	@PostMapping("")
	@JsonView(Views.ViewReview.class)
	public Review create(@RequestBody Review review) {
		review = reviewRepo.save(review);

		return review;
	}

	@PutMapping("/{id}")
	@JsonView(Views.ViewReview.class)
	public Review update(@RequestBody Review review, @PathVariable Long id) {
		review = reviewRepo.save(review);

		return review;
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		reviewRepo.deleteById(id);
	}

}	

