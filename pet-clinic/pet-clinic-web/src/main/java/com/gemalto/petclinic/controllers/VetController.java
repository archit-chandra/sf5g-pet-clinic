package com.gemalto.petclinic.controllers;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gemalto.petclinic.models.Vet;
import com.gemalto.petclinic.services.VetService;

@Controller
@RequestMapping("/vets")
public class VetController {

    private final VetService vetService;

    @Autowired
    public VetController(VetService vetService) {
        this.vetService = vetService;
    }

    @GetMapping({"", "/", "/index", "/index.html"})
    public String listVets(Model model) {
        model.addAttribute("vets", vetService.findAll());
        return "vets/index";
    }

    // TODO: Future Requirement (D2)
    //  1. This service will be moved to other module with extra security implementation
    //  2. It will filter vets (not retunn all)
    //  3. Filtering criteria:  available date, pet type, speciality, etc. (TBD)
    @GetMapping("/api/vets")
    public @ResponseBody
    Set<Vet> getVetsJson() {
        return vetService.findAll();
    }
}
