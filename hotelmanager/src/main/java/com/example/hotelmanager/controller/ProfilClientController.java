package com.example.hotelmanager.controller;

import com.example.hotelmanager.entity.Client;
import com.example.hotelmanager.entity.ProfilClient;
import com.example.hotelmanager.service.ClientService;
import com.example.hotelmanager.service.ProfilClientService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/profilclienti")
public class ProfilClientController {
    private final ProfilClientService profilClientService;
    private final ClientService clientService;

    public ProfilClientController(ProfilClientService profilClientService, ClientService clientService) {
        this.profilClientService = profilClientService;
        this.clientService = clientService;
    }

    @GetMapping
    public String list(Model model) {
        model.addAttribute("profiluri", profilClientService.getAll());
        return "profilclient/list";
    }

    @GetMapping("/add")
    public String addForm(Model model) {
        model.addAttribute("profilClient", new ProfilClient());
        model.addAttribute("clienti", clientService.getAll());
        return "profilclient/form";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute ProfilClient profilClient) {
        profilClientService.save(profilClient);
        return "redirect:/profilclienti";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        profilClientService.delete(id);
        return "redirect:/profilclienti";
    }
}
