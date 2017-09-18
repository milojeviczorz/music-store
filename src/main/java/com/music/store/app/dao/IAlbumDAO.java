package com.music.store.app.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.music.store.app.models.Album;

@Repository("albumDAO")
public interface IAlbumDAO extends JpaRepository<Album, Long> {

	List<Album> findAlbumsByGenreId(long id);

}
