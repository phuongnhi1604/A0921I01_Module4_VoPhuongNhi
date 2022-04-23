package codegym.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@org.springframework.stereotype.Controller

public class Controller {
    @RequestMapping()
    public String loadIndex() {
        return "index";
    }
    @GetMapping("/save")
    public String save (@RequestParam("condiment") String[] condiments, Model model){
        model.addAttribute("condiments",condiments);
        return "view/list";
    }
}
