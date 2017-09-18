package com.music.store.app.services;

import java.util.List;

import com.music.store.app.models.Genre;

public interface IGenreService {

	List<Genre> findAll();

	Genre getOne(long id);

	Genre findByName(String string);

}
