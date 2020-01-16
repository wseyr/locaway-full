package com.sopra.LocAway.rest;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sopra.LocAway.exception.NotFoundException;
import com.sopra.LocAway.model.Photo;
import com.sopra.LocAway.repository.IPhotoRepository;

@RestController
@RequestMapping("/photo")
public class PhotoRestController {

	@Autowired
	private IPhotoRepository photoRepo;
	
	@GetMapping("")
	public List<Photo> list() {
		List<Photo> photos = photoRepo.findAll();

		return photos;
	}

	@GetMapping("/{id}")
	public Photo find(@PathVariable Long id) {
		Optional<Photo> opt = photoRepo.findById(id);

		if (opt.isPresent()) {
			return opt.get();
		} else {
			throw new NotFoundException();
		}
	}

	@PostMapping("")
	public Photo create(@RequestBody Photo photo) {
		photo = photoRepo.save(photo);

		return photo;
	}

	@PutMapping("/{id}")
	public Photo update(@RequestBody Photo photo, @PathVariable Long id) {
		photo = photoRepo.save(photo);

		return photo;
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		photoRepo.deleteById(id);
	}

}	

