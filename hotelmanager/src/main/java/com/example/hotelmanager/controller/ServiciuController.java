package com.example.hotelmanager.controller;

import com.example.hotelmanager.entity.Serviciu;
import com.example.hotelmanager.service.ServiciuService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/servicii")
public class ServiciuController {

    private final ServiciuService serviciuService;

    public ServiciuController(ServiciuService serviciuService) {
        this.serviciuService = serviciuService;
    }

    @GetMapping
    public String list(Model model) {
        model.addAttribute("servicii", serviciuService.getAll());
        return "servicii";
    }

    @GetMapping("/add")
    public String form(Model model) {
        model.addAttribute("serviciu", new Serviciu());
        return "add-serviciu";
    }

    @PostMapping("/add")
    public String add(@Valid @ModelAttribute Serviciu serviciu,
                      BindingResult bindingResult,
                      Model model) {
        if (bindingResult.hasErrors()) {
            return "add-serviciu"; // dacă sunt erori, rămâi pe pagina de adăugare
        }
        serviciuService.save(serviciu);
        return "redirect:/servicii";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        serviciuService.delete(id);
        return "redirect:/servicii";
    }

    @GetMapping("/edit/{id}")
    public String editServiciu(@PathVariable long id, Model model) {
        model.addAttribute("serviciu", serviciuService.getById(id));
        return "edit-serviciu";
    }

    @PostMapping("/edit/{id}")
    public String updateServiciu(@PathVariable long id,
                                 @Valid @ModelAttribute Serviciu serviciu,
                                 BindingResult bindingResult,
                                 Model model) {
        if (bindingResult.hasErrors()) {
            return "edit-serviciu";
        }
        serviciu.setId(id);
        serviciuService.save(serviciu);
        return "redirect:/servicii";
    }
}
