package com.music.store.app.services;

import java.util.List;

import com.music.store.app.models.Album;

public interface IAlbumService {

	List<Album> findAlbumsByGenreId(long id);
}
