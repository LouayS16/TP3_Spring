package com.louay.Medecin.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Medecin {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idMedecin;

    @NotNull
    @Size(min = 4, max = 15)
    private String nomMedecin;

    @Min(value = 10)
    @Max(value = 10000)
    private Double salaire;

    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @PastOrPresent
    private Date datenaissance;

    @ManyToOne
    private Specialite specialite;

    public Medecin() {
        super();
    }

    public Specialite getSpecialite() {
        return specialite;
    }

    public void setSpecialite(Specialite specialite) {
        this.specialite = specialite;
    }

    public Medecin(String nomMedecin, Double salaire, Date datenaissance) {
        this.nomMedecin = nomMedecin;
        this.salaire = salaire;
        this.datenaissance = datenaissance;
    }

    public Long getIdMedecin() {
        return idMedecin;
    }

    public void setIdMedecin(Long idMedecin) {
        this.idMedecin = idMedecin;
    }

    public String getNomMedecin() {
        return nomMedecin;
    }

    public void setNomMedecin(String nomMedecin) {
        this.nomMedecin = nomMedecin;
    }

    public Double getSalaire() {
        return salaire;
    }

    public void setSalaire(Double salaire) {
        this.salaire = salaire;
    }

    public Date getDatenaissance() {
        return datenaissance;
    }

    public void setDatenaissance(Date datenaissance) {
        this.datenaissance = datenaissance;
    }

    @Override
    public String toString() {
        return "Medecin [idMedecin=" + idMedecin + ", nomMedecin=" + nomMedecin + ", salaire=" + salaire
                + ", datenaissance=" + datenaissance + "]";
    }

}
