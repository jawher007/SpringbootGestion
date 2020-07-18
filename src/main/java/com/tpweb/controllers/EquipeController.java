package com.tpweb.controllers;

import java.util.List;

import javax.validation.Valid;

import com.tpweb.models.Equipe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tpweb.services.IEquipeService;
@CrossOrigin(origins = "*")

@RestController
@RequestMapping("/api")
public class EquipeController {
    @Autowired
    IEquipeService equipeService;

    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    @GetMapping("/equipes")

    public List<Equipe> getAllEquipes() {
        List<Equipe> equipes = equipeService.findAllEquipes();

        return equipes;
    }

    @GetMapping("/equipes/{id}")
    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    public Equipe getEquipe(@PathVariable Long id) {
        return equipeService.findByID(id);
    }

    @PostMapping("/equipe")
    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    public Equipe createEquipe(@Valid @RequestBody Equipe equipe) {
        return equipeService.saveEquipe(equipe);
    }



    @PutMapping("/equipe/{id}")
    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    public Equipe editEquipe(@Valid @RequestBody Equipe equipe) {
        return equipeService.editEquipe(equipe);
    }

    @DeleteMapping("/equipe/{id}")
    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    public String deleteEquipe(@PathVariable Long id) {
        Equipe equipe = equipeService.findByID(id);
        equipeService.delete(equipe);
        return "equipe deleted";
    }
}
