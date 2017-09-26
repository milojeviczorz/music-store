package com.music.store.app.controllers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.music.store.app.dto.AlbumDTO;
import com.music.store.app.dto.GenreDTO;
import com.music.store.app.services.IAlbumService;
import com.music.store.app.services.IGenreService;

@RestController
public class GenreRestController {

	private static final Logger LOG = LoggerFactory.getLogger(GenreRestController.class);

	@Autowired
	private IGenreService genreService;

	@Autowired
	private IAlbumService albumService;

	@RequestMapping(value = "/genres", method = RequestMethod.GET)
	public ResponseEntity<?> getAll() {

		List<GenreDTO> genres = genreService.findAll();

		if (genres.isEmpty()) {
			LOG.info("[getAll] Genres list empty");
			return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		}

		return new ResponseEntity<List<GenreDTO>>(genres, HttpStatus.OK);
	}

	@RequestMapping(value = "/genres/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> findAlbumsByGenre(@PathVariable long id) {

		List<AlbumDTO> albums = albumService.findAlbumsByGenreId(id);

		if (albums.isEmpty()) {
			LOG.info("[findAlbumsByGenre] albums list empty");
			return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		}

		return new ResponseEntity<List<AlbumDTO>>(albums, HttpStatus.OK);
	}

}
