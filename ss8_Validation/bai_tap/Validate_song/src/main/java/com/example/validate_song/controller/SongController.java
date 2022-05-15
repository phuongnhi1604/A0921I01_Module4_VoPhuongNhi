package com.example.validate_song.controller;

import com.example.validate_song.model.Song;
import com.example.validate_song.model.SongDto;
import com.example.validate_song.service.SongService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/song")
public class SongController {
    @Autowired
    private SongService songService;

    @GetMapping("/list")
    public String list(Model model){
        model.addAttribute("songList",songService.findAll());
        return "/list";
    }

    @GetMapping("/create")
    public String showForm(Model model){
        model.addAttribute("songDto",new SongDto());
        return "/create";
    }

    @PostMapping("/create")
    public String create(@ModelAttribute @Validated SongDto songDto, BindingResult bindingResult){
        if (bindingResult.hasFieldErrors()){
            return "/create";
        }else {
            Song song = new Song();
            BeanUtils.copyProperties(songDto,song);
            songService.add(song);
            return "redirect:/song/list";
        }
    }

    @GetMapping("/{id}/update")
    public String showUpdate(@PathVariable int id, Model model){
        model.addAttribute("song",songService.findById(id));
        return "/edit";
    }

    @PostMapping("/update")
    public String update(@Validated SongDto songDto, BindingResult bindingResult, Model model){
        if (bindingResult.hasFieldErrors()){
            return "/edit";
        }else {
            Song song = new Song();
            BeanUtils.copyProperties(songDto,song);
            songService.edit(song);
            return "redirect:/song/list";
        }
    }
}
