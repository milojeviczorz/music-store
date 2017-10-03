package com.music.store.app.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.music.store.app.App;
import com.music.store.app.dto.AlbumDTO;
import com.music.store.app.dto.GenreDTO;
import com.music.store.app.services.IAlbumService;
import com.music.store.app.services.IGenreService;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = App.class)
@WebAppConfiguration
@Transactional
public class GenreDAOTest {

	private static final long ID = 1L;

	@Autowired
	private IGenreService genreService;

	@Autowired
	private IAlbumService albumService;

	@Test
	public void testFindAll() {
		List<GenreDTO> genres = genreService.findAll();
		assertEquals(4, genres.size());
	}

	@Test
	public void testFindByName() {
		String name = "Rap";
		GenreDTO genre = genreService.findByName(name);
		assertEquals(name, genre.getName());
	}

	@Test
	public void testGetOne() {
		GenreDTO genre = genreService.findOne(ID);
		assertNotNull(genre);
	}

	@Test
	public void testFindAlbumsByGenreId() {
		List<AlbumDTO> albums = albumService.findAlbumsByGenreId(ID);
		assertEquals(2, albums.size());

	}

}
