package com.music.store.app.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.music.store.app.dao.IAlbumDAO;
import com.music.store.app.dto.AlbumDTO;
import com.music.store.app.models.Album;
import com.music.store.app.utils.DTOManager;

@Service("albumService")
public class AlbumServiceImpl implements IAlbumService {

	@Autowired
	private DTOManager<Album, AlbumDTO> dto;

	@Autowired
	private IAlbumDAO albumDAO;

	@Override
	public List<AlbumDTO> findAlbumsByGenreId(long id) {
		List<Album> albums = albumDAO.findAlbumsByGenreId(id);
		return dto.convertToBO(albums, AlbumDTO.class, "album");
	}

}
