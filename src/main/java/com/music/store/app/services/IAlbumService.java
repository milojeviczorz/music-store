package com.music.store.app.services;

import java.util.List;

import com.music.store.app.dto.AlbumDTO;

public interface IAlbumService {

	List<AlbumDTO> findAlbumsByGenreId(long id);
}
