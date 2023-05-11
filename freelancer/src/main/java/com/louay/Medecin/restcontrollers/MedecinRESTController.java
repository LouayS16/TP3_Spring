package com.louay.Medecin.restcontrollers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.louay.Medecin.entities.Medecin;
import com.louay.Medecin.service.MedecinService;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class MedecinRESTController {
	@Autowired
	MedecinService MedecinService ;
	
	@RequestMapping(method=RequestMethod.GET)
	public List<Medecin> getAllMedecin() {
		return MedecinService.getAllMedecins();
	}
	@RequestMapping(value="/{id}",method = RequestMethod.GET)
	public Medecin getMedecinById(@PathVariable("id") Long id) {
	return MedecinService.getMedecin(id);
	 }
	@RequestMapping(method = RequestMethod.POST)
	public Medecin createMedecin(@RequestBody Medecin Medecin) {
	return MedecinService.saveMedecin(Medecin);
	}
	@RequestMapping(method = RequestMethod.PUT)
	public Medecin updateMedecin(@RequestBody Medecin Medecin) {
	return MedecinService.updateMedecin(Medecin);
	}
	@RequestMapping(value="/{id}",method = RequestMethod.DELETE)
	public void deleteMedecin(@PathVariable("id") Long id)
	{
		MedecinService.deleteMedecinById(id);
	}
	@RequestMapping(value="/Medecinspc/{idSpc}",method = RequestMethod.GET)
	public List<Medecin> getMedecinBySpcId(@PathVariable("idSpc") Long idSpc) {
	return MedecinService.findBySpecialiteIdSpc(idSpc);
	}
}
