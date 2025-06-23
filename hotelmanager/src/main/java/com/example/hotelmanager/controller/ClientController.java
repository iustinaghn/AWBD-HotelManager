package com.example.hotelmanager.controller;

import com.example.hotelmanager.entity.Client;
import com.example.hotelmanager.service.ClientService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/clienti")
public class ClientController {

    private final ClientService clientService;

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping
    public String list(Model model) {
        model.addAttribute("clienti", clientService.getAll());
        return "clienti";
    }

    @GetMapping("/add")
    public String form(Model model) {
        model.addAttribute("client", new Client());
        return "add-client";
    }

    @PostMapping("/add")
    public String add(@ModelAttribute Client client) {
        clientService.save(client);
        return "redirect:/clienti";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        clientService.delete(id);
        return "redirect:/clienti";
    }

    @GetMapping("/edit/{id}")
    public String editForm(@PathVariable Long id, Model model) {
        model.addAttribute("client", clientService.getById(id)); //aduce clientul dupa ID
        return "edit-client";

    }
    @PostMapping ("edit/{id}")
    public String editSubmit (@PathVariable Long id, @ModelAttribute Client client)
    {
        client.setId(id);
        clientService.save(client);
        return "redirect:/clienti";
    }

}