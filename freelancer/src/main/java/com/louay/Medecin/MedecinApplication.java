package com.louay.Medecin;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

import com.louay.Medecin.entities.Medecin;
import com.louay.Medecin.service.MedecinService;

@SpringBootApplication
public class MedecinApplication implements CommandLineRunner {
	@Autowired
	MedecinService medecinService;
	@Autowired
	private RepositoryRestConfiguration repositoryRestConfiguration;
	
	public static void main(String[] args) {
		SpringApplication.run(MedecinApplication.class, args);
	}
	
	@Override
	public void run(String... args) throws Exception {
		repositoryRestConfiguration.exposeIdsFor(Medecin.class);
	}
}
