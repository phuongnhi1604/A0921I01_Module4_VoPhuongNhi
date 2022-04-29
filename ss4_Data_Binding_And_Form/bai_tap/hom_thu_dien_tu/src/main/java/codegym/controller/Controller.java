package codegym.controller;

import codegym.entity.Letter;
import codegym.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@org.springframework.stereotype.Controller
@RequestMapping("/email")
public class Controller {
    @Autowired
    private EmailService emailService;

    @GetMapping("/showList")
    public String showList(Model model) {
        List<Letter> emailList = emailService.findAll();
        model.addAttribute("emailList",emailList);
        return "letter/list";
    }

    @GetMapping( "/showForm/{id}")
    public String showForm(@PathVariable("id") String id, ModelMap model){
        String[] languages = {"English","Vietnamese","Japanese","Chinese"};
        String[] pageSizes = {"5","10","15","25","50","100"};
        Letter email = emailService.findById(id);
        model.addAttribute("email",email);
        model.addAttribute("languages",languages);
        model.addAttribute("pageSize",pageSizes);
        return "letter/setting";
    }

    @PostMapping( "/setting")
    public String update(@ModelAttribute("email") Letter letter){
        emailService.update(letter);
        return "redirect:/email/showList";
    }



}
