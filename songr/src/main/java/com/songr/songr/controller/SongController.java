package com.songr.songr.controller;

//import com.songr.songr.model.Album;
import com.songr.songr.model.Albums;
import com.songr.songr.model.Song;
import com.songr.songr.model.dto.SongDTO;
import com.songr.songr.repository.AlbumRepository;
import com.songr.songr.repository.SongRepository;
import org.dom4j.rule.Mode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;
@Controller
public class SongController {

    @Autowired
    private SongRepository songRepository;
    @Autowired
    private AlbumRepository albumRepository;

    @GetMapping("/songs")
    public String findAllSongs(Model model){

        model.addAttribute("song", songRepository.findAll());
        System.out.println(songRepository.findAll().toString());
        return "songs";
    }

    @GetMapping("/addSongs")
    public String addASong(){
        return "addSongs";
    }

    @PostMapping("/songs")
    public RedirectView addNewSong(@ModelAttribute SongDTO songDTO){
        Albums album = albumRepository.findAlbumByTitle(songDTO.getAlbum());
        Song addNewSong = new Song(songDTO.getTitle(),songDTO.getLength(),songDTO.getTrackNumber(),album);
        System.out.println(addNewSong.getAlbum());
        songRepository.save(addNewSong);
        return new RedirectView("/songs");
    }

    @GetMapping("/songs/{album_id}")
    public String getSongByAlbumId(@PathVariable Long album_id, Model model){
        model.addAttribute("song",songRepository.findByAlbums_Id(album_id));
        return "songs";
    }
}
