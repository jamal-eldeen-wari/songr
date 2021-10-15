package com.songr.songr.repository;

import com.songr.songr.model.Song;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SongRepository extends JpaRepository<Song,Long> {
Song findByAlbums_Id(Long album_id);
}
