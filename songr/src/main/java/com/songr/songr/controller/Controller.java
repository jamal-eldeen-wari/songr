package com.songr.songr.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;


@org.springframework.stereotype.Controller
public class Controller {


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




}
