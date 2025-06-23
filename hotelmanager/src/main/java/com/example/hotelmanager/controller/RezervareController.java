package com.example.hotelmanager.controller;

import com.example.hotelmanager.entity.*;
import com.example.hotelmanager.service.CameraService;
import com.example.hotelmanager.service.ClientService;
import com.example.hotelmanager.service.RezervareService;
import com.example.hotelmanager.service.ServiciuService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/rezervari")
public class RezervareController {

    private final RezervareService rezervareService;
    private final ClientService clientService;
    private final CameraService cameraService;
    private final ServiciuService serviciuService;

    public RezervareController(RezervareService rezervareService,
                               ClientService clientService,
                               CameraService cameraService,
                               ServiciuService serviciuService) {
        this.rezervareService = rezervareService;
        this.clientService = clientService;
        this.cameraService = cameraService;
        this.serviciuService = serviciuService;
    }

    @GetMapping
    public String list(Model model) {
        model.addAttribute("rezervari", rezervareService.getAll());
        return "rezervari";
    }

    @GetMapping("/add")
    public String form(Model model) {
        model.addAttribute("rezervare", new Rezervare());
        model.addAttribute("clienti", clientService.getAll());
        model.addAttribute("camere", cameraService.getAll());
        model.addAttribute("servicii", serviciuService.getAll());
        return "add-rezervare";
    }

    @PostMapping("/add")
    public String add(@ModelAttribute Rezervare rezervare) {
        rezervareService.save(rezervare);
        return "redirect:/rezervari";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        rezervareService.delete(id);
        return "redirect:/rezervari";
    }

    @GetMapping("/edit/{id}")
    public String editRezervare(@PathVariable long id, Model model) {
        Rezervare rezervare = rezervareService.getById(id);

        if (rezervare == null) {
            return "redirect:/rezervari";
        }

        model.addAttribute("rezervare", rezervare);
        model.addAttribute("clienti", clientService.getAll());
        model.addAttribute("camere", cameraService.getAll());
        model.addAttribute("servicii", serviciuService.getAll());
        return "edit-rezervare";
    }

    @PostMapping("/edit/{id}")
    public String updateRezervare(@PathVariable long id,
                                  @RequestParam Long client,
                                  @RequestParam Long camera,
                                  @RequestParam(required = false) List<Long> servicii) {

        Rezervare rezervare = rezervareService.getById(id);
        if (rezervare == null) {
            return "redirect:/rezervari";
        }

        rezervare.setClient(clientService.getById(client));
        rezervare.setCamera(cameraService.getById(camera));

        if (servicii != null) {
            rezervare.setServicii(serviciuService.getAllByIds(servicii));
        } else {
            rezervare.setServicii(null);
        }

        rezervareService.save(rezervare);
        return "redirect:/rezervari";
    }
}
