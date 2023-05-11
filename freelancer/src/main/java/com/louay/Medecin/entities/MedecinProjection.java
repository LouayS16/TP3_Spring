package com.louay.Medecin.entities;

import org.springframework.data.rest.core.config.Projection;

@Projection(name = "nomMedecinl", types = { Medecin.class })
public interface MedecinProjection {
	public String getNomMedecin();
}
