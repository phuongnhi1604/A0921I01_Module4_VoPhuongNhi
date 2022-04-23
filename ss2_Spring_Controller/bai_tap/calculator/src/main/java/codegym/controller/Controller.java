package codegym.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@org.springframework.stereotype.Controller
public class Controller {
    @RequestMapping()
    public String loadIndex() {
        return "index";
    }
    @PostMapping("/calculator")
    public String calculate(@RequestParam double num1, @RequestParam double num2, @RequestParam("calculator") String calculator, Model model){
        double result = 0;
        String notify="";
        switch (calculator){
            case "Addition(+)":
                result = num1+num2;
                break;
            case "Subtraction(-)":
                result = num1-num2;
                break;
            case "Multiplication(*)":
                result = num1*num2;
                break;
            case "Division(/)":
                if (num2!=0){
                result = num1/num2;}
                else {
                    notify = "Khong chia duoc cho 0";
                }
                break;
        }
        model.addAttribute("num1",num1);
        model.addAttribute("num2",num2);
        model.addAttribute("result",result);
        model.addAttribute("notify",notify);
        return "view/result";
    }
}
