package com.songr.songr.repository;

import com.songr.songr.model.Album;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlbumRepository extends JpaRepository<Album,Long>{
Album findAlbumByArtist(String artist);
}
