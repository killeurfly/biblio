package com.example.biblio.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.biblio.dto.LivreResponse;
import com.example.biblio.service.LivreService;

@RestController 
@RequestMapping("/api/livres")
public class LivreController {
    private final LivreService service;
    public LivreController(LivreService service) { this.service = service; }

    @GetMapping
    public List<LivreResponse> lister() { return service.lister(); }
}
