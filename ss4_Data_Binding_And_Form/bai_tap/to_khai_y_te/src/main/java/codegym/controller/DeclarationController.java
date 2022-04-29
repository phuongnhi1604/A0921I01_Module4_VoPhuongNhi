package codegym.controller;

import codegym.entity.Declaration;
import codegym.service.DeclarationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/declaration")
public class DeclarationController {
    @Autowired
    DeclarationService declarationService;

    @GetMapping("/list")
    public String showList(Model model) {
        List<Declaration> declarations = declarationService.findAll();
        model.addAttribute("declarations",declarations);
        return "views/list";
    }
    @GetMapping("/create")
    public String viewCreate(Model model){
        String[] birthday_years={"1990","1991","1992","1993","1994","1995","1995","2000","2001"};
        String[] genders = {"Nam","Nữ"};
        String[] nationalities = {"Việt Nam","Campuchia","Singapore","ThaiLand"};
        String[] vehicles = {"Tàu bay","Tàu thuyền","Ô tô","Khác (Ghi rõ)"};
        model.addAttribute("declaration", new Declaration());
        model.addAttribute("birthday_years",birthday_years);
        model.addAttribute("genders",genders);
        model.addAttribute("nationalities",nationalities);
        model.addAttribute("vehicles",vehicles);
        return "/views/create";
    }

    @PostMapping("/create")
    public String create(@ModelAttribute("declaration") Declaration declaration) {
        declarationService.add(declaration);
        return "redirect:/declaration/list";
    }

    @GetMapping("/view/{id}")
    public String viewDeclaration(@PathVariable("id") String id, Model model) {
        String[] birthday_years={"1990","1991","1992","1993","1994","1995","1995","2000","2001"};
        String[] genders = {"Nam","Nữ"};
        String[] nationalities = {"Việt Nam","Campuchia","Singapore","ThaiLand"};
        String[] vehicles = {"Tàu bay","Tàu thuyền","Ô tô","Khác (Ghi rõ)"};
        Declaration declaration = declarationService.findById(id);
        model.addAttribute("declaration", declaration);
        model.addAttribute("birthday_years",birthday_years);
        model.addAttribute("genders",genders);
        model.addAttribute("nationalities",nationalities);
        model.addAttribute("vehicles",vehicles);
        return "/views/view";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute("declaration") Declaration declaration){
        declarationService.update(declaration);
        return "redirect:/declaration/list";
    }
}
