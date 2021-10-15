package com.songr.songr.repository;

//import com.songr.songr.model.Album;
import com.songr.songr.model.Albums;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlbumRepository extends JpaRepository<Albums,Long>{
Albums findAlbumByArtist(String artist);
Albums findAlbumByTitle(String title);

}
