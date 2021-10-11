package com.songr.songr.repository;

import com.songr.songr.controller.Album;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlbumRepository extends JpaRepository<Album,Long>{
Album findAlbumByArtist(String artist);
}
