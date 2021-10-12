package com.songr.songr.controller;

import com.songr.songr.repository.AlbumRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;


@org.springframework.stereotype.Controller
public class Controller {

    @Autowired
    private AlbumRepository albumRepository;


    @GetMapping("/hello")
    public String hello(@RequestParam(name = "name", required = false,defaultValue = " Hello From Controller ") String name, Model model){
        model.addAttribute("name",name);
        return "hello";
    }

    @GetMapping("/capitalize/{name}")
    public String capitalize(@PathVariable String name, Model model){
        model.addAttribute("name", name.toUpperCase());
        return "capitalize";
    }

    Album [] albums ={new Album("Long Year","Steve Everett",24,180,"https://f4.bcbits.com/img/0007272500_10.jpg"),
            new Album("Fake it","Steve Everett",24,180,"https://f4.bcbits.com/img/0007272500_10.jpg"),
            new Album("Never love you","Steve Everett",24,180,"https://f4.bcbits.com/img/0007272500_10.jpg")};

    @GetMapping("/album")
    public String album(Model model){
//        ArrayList<Object> albums = new ArrayList<>();

       model.addAttribute("album",albums);
        return "album";
    }

    @ResponseBody
    @PostMapping("/v1/songrs")
    public Album createSong(@RequestBody Album album){
        Album album1 = albumRepository.save(album);
        return album1;
    }

    @GetMapping("/v2/songrs")
    public String getSong(Model model){
        model.addAttribute("albums",albumRepository.findAll());
        return "albums";
    }

//    @PostMapping("/v2/songrs")
//    public RedirectView createNewSong(@ModelAttribute Album album){
//        albumRepository.save(album);
//        return new RedirectView("albums");
//    }

    @PostMapping("/v2/songrs")
public RedirectView addNewAlbum(@RequestParam (value = "title") String title ,
                                @RequestParam (value = "artist") String artist,
                                @RequestParam (value = "songCount") int songCount,
                                @RequestParam (value = "length") int length,
                                @RequestParam (value = "imageURL") String imageURL){

    Album albums = new Album(title,artist,songCount,length,imageURL);
    albumRepository.save(albums);
    return new RedirectView("/v2/songrs");

}
    @GetMapping("/v2/songrs/{artist}")
    public String findAlbumByArtist(@PathVariable String artist, Model model){
        Album album = albumRepository.findAlbumByArtist(artist);
        model.addAttribute("album",album);
        return "album";
    }







}
