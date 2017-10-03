package com.music.store.app.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.music.store.app.dao.IGenreDAO;
import com.music.store.app.dto.GenreDTO;
import com.music.store.app.models.Genre;
import com.music.store.app.utils.DTOManager;

@Service("genreService")
public class GenreServiceImpl implements IGenreService {

	@Autowired
	private DTOManager<Genre, GenreDTO> dto;

	@Autowired
	private IGenreDAO genreDAO;

	@Override
	public List<GenreDTO> findAll() {
		List<Genre> genre = genreDAO.findAll();
		return dto.convertToBO(genre, GenreDTO.class);
	}

	@Override
	public GenreDTO findOne(long id) {
		Genre genre = genreDAO.findOne(id);
		return dto.convert(genre, GenreDTO.class);
	}

	@Override
	public GenreDTO findByName(String name) {
		Genre genre = genreDAO.findByName(name);
		return dto.convert(genre, GenreDTO.class);
	}
}
