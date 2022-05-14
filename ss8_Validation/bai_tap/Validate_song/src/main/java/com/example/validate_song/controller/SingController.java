package com.example.validate_song.controller;

import com.example.validate_song.model.Song;
import com.example.validate_song.model.SongDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/song")
public class SingController {
    @GetMapping("/create")
    public String showForm(Model model){
        model.addAttribute("songDto",new SongDto());
        return "/create";
    }
}
