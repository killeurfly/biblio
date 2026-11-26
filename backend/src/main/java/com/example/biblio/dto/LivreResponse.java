package com.example.biblio.dto;

import com.example.biblio.entity.Livre;

public record LivreResponse(Long id, String titre, String auteur, String isbn, Integer annee) {
    public static LivreResponse from(Livre l) {
        return new LivreResponse(l.getId(), l.getTitre(), l.getAuteur(), l.getIsbn(), l.getAnnee());
    }
}