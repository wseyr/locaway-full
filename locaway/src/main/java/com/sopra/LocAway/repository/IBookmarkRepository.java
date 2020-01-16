package com.sopra.LocAway.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sopra.LocAway.model.Bookmark;

public interface IBookmarkRepository extends JpaRepository<Bookmark, Long> {

}
