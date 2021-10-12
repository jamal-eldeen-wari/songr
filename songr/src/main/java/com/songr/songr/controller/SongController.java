package com.songr.songr.controller;

import com.songr.songr.model.Album;
import com.songr.songr.model.Song;
import com.songr.songr.repository.AlbumRepository;
import com.songr.songr.repository.SongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

public class SongController {

    @Autowired
    private SongRepository songRepository;
    @Autowired
    private AlbumRepository albumRepository;
//    Get all the songs from the database (I think)
//    @GetMapping("/song/{songId}")
//    public String findSongById(@PathVariable String songId, Model model){
//        Song song = songRepository.findById(Long.parseLong(songId)).orElseThrow();
//        model.addAttribute("song", song);
//        return "song";
//    }

    @GetMapping("/v1/songs")
    public String findAllSongs(Model model){
        Song song = (Song) songRepository.findAll();
        model.addAttribute("song",song);
        return "songs";
    }

    @GetMapping("/songAdd")
    public String addASong(){
        return "addSongs";
    }

    @PostMapping("/v2/songs")
    public RedirectView addNewSong(@RequestParam Long album_id,
            @RequestParam String title,
                                   @RequestParam String length,
                                   @RequestParam int trackNumber
                                   ){
        Album album = albumRepository.getById(album_id);
        Song addNewSong = new Song(title,length,trackNumber,album);
        songRepository.save(addNewSong);
        return new RedirectView("/songs");

    }



}
