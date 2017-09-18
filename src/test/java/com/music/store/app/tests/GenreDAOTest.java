package com.music.store.app.tests;

import static org.junit.Assert.assertEquals;

import java.util.List;

import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.music.store.app.App;
import com.music.store.app.models.Genre;
import com.music.store.app.services.IGenreService;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = App.class)
@WebAppConfiguration
@Transactional
public class GenreDAOTest {

	@Autowired
	private IGenreService genreService;

	@Test
	public void testFindAll() {
		List<Genre> genres = genreService.findAll();
		assertEquals(4, genres.size());
	}

	@Test
	public void testFindByName() {
		String name = "Rap";
		Genre genre = genreService.findByName(name);
		assertEquals(name, genre.getName());
	}

}
