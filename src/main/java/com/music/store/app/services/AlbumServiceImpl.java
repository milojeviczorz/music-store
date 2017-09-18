package com.music.store.app.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.music.store.app.dao.IAlbumDAO;
import com.music.store.app.models.Album;

@Service("albumService")
public class AlbumServiceImpl implements IAlbumService {

	@Autowired
	private IAlbumDAO albumDAO;

	@Override
	public List<Album> findAlbumsByGenreId(long id) {
		return albumDAO.findAlbumsByGenreId(id);
	}

}
