package com.music.store.app.services;

import java.util.List;

import com.music.store.app.dto.GenreDTO;

public interface IGenreService {

	List<GenreDTO> findAll();

	GenreDTO getOne(long id);

	GenreDTO findByName(String string);

}
