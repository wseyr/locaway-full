package com.sopra.LocAway.rest;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;
import com.sopra.LocAway.exception.NotFoundException;
import com.sopra.LocAway.model.User;
import com.sopra.LocAway.model.Views;
import com.sopra.LocAway.repository.IUserRepository;

@RestController
@RequestMapping("/user")
@CrossOrigin("*")
public class UserRestController {

	@Autowired
	private IUserRepository userRepo;
	
	boolean connected = false;
	
	@GetMapping("")
	@JsonView(Views.ViewUser.class)
	public List<User> list() {
		List<User> users = userRepo.findAll();

		return users;
	}

	@GetMapping("/{id}")
	@JsonView(Views.ViewUser.class)
	public User find(@PathVariable Long id) {
		Optional<User> opt = userRepo.findById(id);

		if (opt.isPresent()) {
			return opt.get();
		} else {
			throw new NotFoundException();
		}
	}

	@PostMapping("")
	@JsonView(Views.ViewUser.class)
	public User create(@RequestBody User user) {
		user = userRepo.save(user);

		return user;
	}
	
	
	@GetMapping(value="/login/{email}/password/{password}")
	@JsonView(Views.ViewUser.class)
	public User login(User user){
		
		
		User u = userRepo.findByEmailAndPassword(user.getEmail(), user.getPassword());
		System.out.println(u);
		if(u==null) {
			System.out.println("log not found" + u);
			
		} else {
		System.out.println("log found : " + u.getEmail());}
		
		
		return u;
	}

	@PutMapping("/{id}")
	@JsonView(Views.ViewUser.class)
	public User update(@RequestBody User user, @PathVariable Long id) {
		user = userRepo.save(user);

		return user;
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		userRepo.deleteById(id);
	}
	


}	

