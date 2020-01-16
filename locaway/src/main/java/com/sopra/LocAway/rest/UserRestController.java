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
import com.sopra.LocAway.model.User;
import com.sopra.LocAway.repository.IUserRepository;

@RestController
@RequestMapping("/user")
@CrossOrigin("*")
public class UserRestController {

	@Autowired
	private IUserRepository userRepo;
	
	@GetMapping("")
	public List<User> list() {
		List<User> users = userRepo.findAll();

		return users;
	}

	@GetMapping("/{id}")
	public User find(@PathVariable Long id) {
		Optional<User> opt = userRepo.findById(id);

		if (opt.isPresent()) {
			return opt.get();
		} else {
			throw new NotFoundException();
		}
	}

	@PostMapping("")
	public User create(@RequestBody User user) {
		user = userRepo.save(user);

		return user;
	}

	@PutMapping("/{id}")
	public User update(@RequestBody User user, @PathVariable Long id) {
		user = userRepo.save(user);

		return user;
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		userRepo.deleteById(id);
	}

}	

