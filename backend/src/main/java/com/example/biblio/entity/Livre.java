package com.example.biblio.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "livre")
public class Livre {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, length = 200) private String titre;
    @Column(nullable = false, length = 120) private String auteur;
    @Column(nullable = false, unique = true, length = 13) private String isbn;
    private Integer annee;

    protected Livre() {}
    public Livre(String titre, String auteur, String isbn, Integer annee) {
        this.titre = titre; this.auteur = auteur; this.isbn = isbn; this.annee = annee;
    }
    public Long getId() { return id; }
    public String getTitre() { return titre; }
    public String getAuteur() { return auteur; }
    public String getIsbn() { return isbn; }
    public Integer getAnnee() { return annee; }
}
