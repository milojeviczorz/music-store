package com.music.store.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.music.store.app.models.Genre;

@Repository("genreDAO")
public interface IGenreDAO extends JpaRepository<Genre, Long> {

	Genre findByName(String name);
}
