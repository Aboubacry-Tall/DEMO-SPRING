package com.libsys.Maurilib.model;

import javax.persistence.*;

@Entity(name ="livres")
@Table(name="livres")
public class Livre {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String titre;
    private String prix;
    private String statut;
    private String etat;
    private String isbn;
    private String couverture;
    private String categorie;
    private String auteur;
    private String editeur;
    private String document;
    private String dates;
    private String resume;

    public Livre() {
    }

    public Livre(String titre, String prix, String statut, String etat, String isbn, String couverture, String categorie, String auteur, String editeur, String document, String dates, String resume) {
        this.titre = titre;
        this.prix = prix;
        this.statut = statut;
        this.etat = etat;
        this.isbn = isbn;
        this.couverture = couverture;
        this.categorie = categorie;
        this.auteur = auteur;
        this.editeur = editeur;
        this.document = document;
        this.dates = dates;
        this.resume = resume;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getPrix() {
        return prix;
    }

    public void setPrix(String prix) {
        this.prix = prix;
    }

    public String getStatut() {
        return statut;
    }

    public void setStatut(String statut) {
        this.statut = statut;
    }

    public String getEtat() {
        return etat;
    }

    public void setEtat(String etat) {
        this.etat = etat;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getCouverture() {
        return couverture;
    }

    public void setCouverture(String couverture) {
        this.couverture = couverture;
    }

    public String getCategorie() {
        return categorie;
    }

    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }

    public String getAuteur() {
        return auteur;
    }

    public void setAuteur(String auteur) {
        this.auteur = auteur;
    }

    public String getEditeur() {
        return editeur;
    }

    public void setEditeur(String editeur) {
        this.editeur = editeur;
    }

    public String getDocument() {
        return document;
    }

    public void setDocument(String document) {
        this.document = document;
    }

    public String getDates() {
        return dates;
    }

    public void setDates(String dates) {
        this.dates = dates;
    }

    public String getResume() {
        return resume;
    }

    public void setResume(String resume) {
        this.resume = resume;
    }

}
