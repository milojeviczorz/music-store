package com.music.store.app.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.music.store.app.dao.IGenreDAO;
import com.music.store.app.models.Genre;

@Service("genreService")
public class GenreServiceImpl implements IGenreService {

	@Autowired
	private IGenreDAO genreDAO;

	@Override
	public List<Genre> findAll() {
		return genreDAO.findAll();
	}

	@Override
	public Genre getOne(long id) {
		return genreDAO.findOne(id);
	}

	@Override
	public Genre findByName(String name) {
		return genreDAO.findByName(name);
	}
}
