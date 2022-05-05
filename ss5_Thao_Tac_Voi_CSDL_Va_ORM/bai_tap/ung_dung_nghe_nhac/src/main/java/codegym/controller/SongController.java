package codegym.controller;

import codegym.entity.Song;
import codegym.service.SongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/song")
public class SongController {
    @Autowired
    private SongService service;

    @GetMapping("/list")
    public String list(Model model) {
        List<Song> songList = service.findAll();
        model.addAttribute("songList", songList);
        return "music/list";
    }

    @GetMapping("/create")
    public String viewCreate(Model model){
        model.addAttribute("song",new Song());
        return "/music/create";
    }

    @PostMapping("/create")
    public String create(@ModelAttribute("song") Song song){
        service.create(song);
        return "redirect:/song/list";
    }

    @GetMapping("/update")
    public String showUpdate(@RequestParam("id") int id, Model model){
        model.addAttribute("song",service.findById(id));
        return "/music/edit";
    }

    @PostMapping("/update")
    public String update(Song song){
        service.update(song.getId(),song);
        return "redirect:/song/list";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam("id") int id, Model model){
        model.addAttribute("song",service.findById(id));
        return "/music/delete";
    }

    @PostMapping("/delete")
    public String delete(Song song){
        service.delete(song.getId());
        return "redirect:/song/list";
    }
}
