package com.louay.Medecin.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Specialite {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idSpc;
	private String nomSpc;
	private String descriptionSpc;

	@OneToMany(mappedBy = "specialite")
	@JsonIgnore
	private List<Medecin> medecins;

	@Override
	public String toString() {
		return "Specialite [idSpc=" + idSpc + ", nomSpc=" + nomSpc + ", descriptionSpc=" + descriptionSpc + ", medecins="
				+ medecins + "]";
	}

	public Long getIdSpc() {
		return idSpc;
	}

	public void setIdSpc(Long idSpc) {
		this.idSpc = idSpc;
	}

	public String getNomSpc() {
		return nomSpc;
	}

	public void setNomSpc(String nomSpc) {
		this.nomSpc = nomSpc;
	}

	public String getDescriptionSpc() {
		return descriptionSpc;
	}

	public void setDescriptionSpc(String descriptionSpc) {
		this.descriptionSpc = descriptionSpc;
	}

	public List<Medecin> getMedecins() {
		return medecins;
	}

	public void setMedecins(List<Medecin> medecins) {
		this.medecins = medecins;
	}
}
