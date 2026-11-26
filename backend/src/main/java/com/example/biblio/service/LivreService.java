package com.example.biblio.service;
import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.biblio.dto.LivreResponse;
import com.example.biblio.repository.LivreRepository;

@Service
@Transactional(readOnly = true)
public class LivreService {
    private final LivreRepository livres;
    public LivreService(LivreRepository livres) { this.livres = livres; }

    public List<LivreResponse> lister() {
        return livres.findAll(Sort.by("titre")).stream().map(LivreResponse::from).toList();
    }
}
