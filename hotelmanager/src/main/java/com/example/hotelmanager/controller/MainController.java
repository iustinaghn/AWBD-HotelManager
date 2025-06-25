package com.example.hotelmanager.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @GetMapping("/menu")
    public String showMenu() {
        return "menu"; // fără extensia .html
    }

    @GetMapping("/")
    public String redirectToMenu() {
        return "redirect:/menu";
    }
}
