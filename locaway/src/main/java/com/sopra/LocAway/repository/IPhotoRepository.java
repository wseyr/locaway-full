package com.sopra.LocAway.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sopra.LocAway.model.Photo;

public interface IPhotoRepository extends JpaRepository<Photo, Long> {

}
