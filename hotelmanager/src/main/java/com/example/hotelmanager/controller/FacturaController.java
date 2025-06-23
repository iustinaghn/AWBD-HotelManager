package com.example.hotelmanager.controller;

import com.example.hotelmanager.entity.Camera;
import com.example.hotelmanager.entity.Factura;
import com.example.hotelmanager.entity.Rezervare;
import com.example.hotelmanager.service.FacturaService;
import com.example.hotelmanager.service.RezervareService;
import org.springframework.data.jpa.domain.AbstractAuditable_;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@Controller
@RequestMapping("/facturi")
public class FacturaController {

    private final FacturaService facturaService;
    private final RezervareService rezervareService;

    public FacturaController(FacturaService facturaService, RezervareService rezervareService) {
        this.facturaService = facturaService;
        this.rezervareService = rezervareService;
    }

    @GetMapping
    public String list(Model model) {
        List<Factura> facturi = facturaService.getAll();
        model.addAttribute("facturi", facturi);
        return "facturi";
    }

    @GetMapping("/add")
    public String form(Model model) {
        model.addAttribute("factura", new Factura());
        model.addAttribute("rezervari", rezervareService.getAll());
        return "add-factura";
    }

    @PostMapping("/add")
    public String add(@ModelAttribute Factura factura) {
        factura.setDataEmitere(LocalDate.now());
        facturaService.save(factura);
        return "redirect:/facturi";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        facturaService.delete(id);
        return "redirect:/facturi";
    }
    @GetMapping("/edit/{id}")

    public String editForm(@PathVariable Long id, Model model) {
        Factura factura = facturaService.getById(id);
        model.addAttribute("factura", factura);

        // Trebuie să trimitem si lista de rezervari ca să le afisamm în dropdown
        model.addAttribute("rezervari", rezervareService.getAll());

        return "edit-factura";
    }

    @PostMapping("/edit/{id}")
    public String update(@PathVariable Long id, @ModelAttribute Factura factura) {
        factura.setId(id); // Ne asiguram ca se modifica factura cu ID-ul corect
        facturaService.save(factura);
        return "redirect:/facturi";
    }


}
