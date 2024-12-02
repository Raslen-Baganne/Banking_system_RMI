package Server;

import java.io.Serializable;
import java.util.Date;

public class Compte implements Serializable {
    private int code;
    private String nom;
    private String prenom;

    private double solde;
    private Date dateCreation;

    
    public Compte(int code,String nom, String prenom, double solde, Date dateCreation) {
        this.code = code;
        this.nom = nom;
        this.prenom = prenom;
        this.solde = solde;
        this.dateCreation = dateCreation;
    }

    // Getters et Setters
    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public double getSolde() {
        return solde;
    }

    public void setSolde(double solde) {
        this.solde = solde;
    }

    public Date getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(Date dateCreation) {
        this.dateCreation = dateCreation;
    }

    public String getNom() {
        return nom;
    }
    
    public void setNom(String nom) {
        this.nom = nom;
    }
    
    public String getPrenom() {
        return prenom;
    }
    
    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    @Override
    public String toString() {
        return "Compte :" +
           " code=" + code +
           ", nom=" + nom +
           ", prenom=" + prenom +
           ", solde=" + solde +
           ", dateCreation=" + dateCreation;
    }
}