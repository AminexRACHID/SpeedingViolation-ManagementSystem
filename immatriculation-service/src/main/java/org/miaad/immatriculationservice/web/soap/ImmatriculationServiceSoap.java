package org.miaad.immatriculationservice.web.soap;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebService;

import java.util.HashMap;
import java.util.Map;

@WebService(serviceName = "proprietairews")
public class ImmatriculationServiceSoap {

    private Map<String, Proprietaire> proprietaires = new HashMap<>();

    @WebMethod
    public String createProprietaire(
            @WebParam(name = "nom") String nom,
            @WebParam(name = "dateNaissance") String dateNaissance,
            @WebParam(name = "email") String email) {
        String proprietaireId = "22";
        Proprietaire proprietaire = new Proprietaire(proprietaireId, nom, dateNaissance, email);
        proprietaires.put(proprietaireId, proprietaire);
        return proprietaireId;
    }

    @WebMethod
    public String updateProprietaire(
            @WebParam(name = "proprietaireId") String proprietaireId,
            @WebParam(name = "nom") String nom,
            @WebParam(name = "dateNaissance") String dateNaissance,
            @WebParam(name = "email") String email) {
        if (proprietaires.containsKey(proprietaireId)) {
            Proprietaire proprietaire = proprietaires.get(proprietaireId);
            proprietaire.setNom(nom);
            proprietaire.setDateNaissance(dateNaissance);
            proprietaire.setEmail(email);
            return "Proprietaire mis à jour avec succès";
        } else {
            return "Proprietaire non trouvé";
        }
    }

    @WebMethod
    public Proprietaire getProprietaire(@WebParam(name = "proprietaireId") String proprietaireId) {
        if (proprietaires.containsKey(proprietaireId)) {
            return proprietaires.get(proprietaireId);
        } else {
            return null;
        }
    }


}

class Proprietaire {
    private String id;
    private String nom;
    private String dateNaissance;
    private String email;

    public Proprietaire(String id, String nom, String dateNaissance, String email) {
        this.id = id;
        this.nom = nom;
        this.dateNaissance = dateNaissance;
        this.email = email;
    }

    public Proprietaire() {
        // Default constructor
    }

    // Getters et setters

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(String dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}