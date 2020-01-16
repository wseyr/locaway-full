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
import com.sopra.LocAway.model.Bookmark;
import com.sopra.LocAway.repository.IBookmarkRepository;

@RestController
@RequestMapping("/bookmark")
@CrossOrigin("*")
public class BookmarkRestController {

	@Autowired
	private IBookmarkRepository bookmarkRepo;
	
	@GetMapping("")
	public List<Bookmark> list() {
		List<Bookmark> bookmarks = bookmarkRepo.findAll();

		return bookmarks;
	}

	@GetMapping("/{id}")
	public Bookmark find(@PathVariable Long id) {
		Optional<Bookmark> opt = bookmarkRepo.findById(id);

		if (opt.isPresent()) {
			return opt.get();
		} else {
			throw new NotFoundException();
		}
	}

	@PostMapping("")
	public Bookmark create(@RequestBody Bookmark bookmark) {
		bookmark = bookmarkRepo.save(bookmark);

		return bookmark;
	}

	@PutMapping("/{id}")
	public Bookmark update(@RequestBody Bookmark bookmark, @PathVariable Long id) {
		bookmark = bookmarkRepo.save(bookmark);

		return bookmark;
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		bookmarkRepo.deleteById(id);
	}

}	

