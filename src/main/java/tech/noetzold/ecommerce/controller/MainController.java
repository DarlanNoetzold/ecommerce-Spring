package tech.noetzold.ecommerce.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @GetMapping("/administrativo")
    public String accessHome(){
        return "administrativo/home";
    }
}
