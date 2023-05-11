package com.louay.Medecin.controllers;

import java.text.ParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.louay.Medecin.entities.Medecin;
import com.louay.Medecin.entities.Specialite;
import com.louay.Medecin.service.MedecinService;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.validation.Valid;

@Controller
public class MedecinController {
	@Autowired
	MedecinService MedecinService;
	@RequestMapping("/showCreate")
	public String showCreate(ModelMap modelMap)
	{
		List<Specialite> spcs = MedecinService.getAllSpecialite();
		Medecin Medecin1 = new Medecin();
		Specialite spc = new Specialite ();

		if (!spcs.isEmpty()) {
		    spc = spcs.get(0);
		}

		Medecin1.setSpecialite(spc);
		modelMap.addAttribute("Medecin", new Medecin());
		modelMap.addAttribute("mode", "new");
		modelMap.addAttribute("Specialite", spcs);
		
		for (Specialite s : spcs) {
			System.out.println(s);
		}
		
		modelMap.addAttribute("page",0);
		return "formMedecin";
	}
	
	@RequestMapping("/saveMedecin")
	public String saveMedecin(@Valid Medecin Medecin,  BindingResult bindingResult, @ModelAttribute("page") int pageFromPrevious,
		    @RequestParam (name="size", defaultValue = "3") int size,
		    RedirectAttributes redirectAttributes,ModelMap modelMap)
	{ int page;
		 if (bindingResult.hasErrors()) {
			 List<Specialite> spcs = MedecinService.getAllSpecialite();
			 modelMap.addAttribute("Specialite", spcs);
			 modelMap.addAttribute("mode", "edit");
		        return "formMedecin";
		    }if (Medecin.getIdMedecin()==null) //adding
		        page = MedecinService.getAllMedecins().size()/size; // calculer le nbr de pages
		    else //updating
		        page = pageFromPrevious;
		    MedecinService.saveMedecin(Medecin);
		    redirectAttributes.addAttribute("page", page);
		    return "listeMedecin";
	}
	@RequestMapping("/listeMedecin")
	public String listeMedecin(ModelMap modelMap, @RequestParam(name = "page", defaultValue = "0") int page,
	        @RequestParam(name = "size", defaultValue = "3") int size) {

	    Page<Medecin> medecinsPage = MedecinService.getAllMedecinParPage(page, size);
	    modelMap.addAttribute("Medecins", medecinsPage.getContent());
	    modelMap.addAttribute("pages", new int[medecinsPage.getTotalPages()]);
	    modelMap.addAttribute("currentPage", page);
	    return "listeMedecins"; // Note: changed from "redirect:/listeMedecins" to "listeMedecins"
	}

	@RequestMapping("/supprimerMedecin")
	public String supprimerMedecin(@RequestParam("id") Long id,
	 ModelMap modelMap ,@RequestParam (name="page",defaultValue = "0") int page,
	 @RequestParam (name="size", defaultValue = "3") int size)
	{ 
		MedecinService.deleteMedecinById(id);
		Page<Medecin> Medecinl = MedecinService.getAllMedecinParPage(page, 
				size);
				modelMap.addAttribute("Medecin", Medecinl);
				modelMap.addAttribute("pages", new int[Medecinl.getTotalPages()]);
				modelMap.addAttribute("currentPage", page);
				modelMap.addAttribute("size", size);

	return "listeMedecins";
	}
	@RequestMapping("/modifierMedecin")
	public String editerMedecin(@RequestParam("id") Long id, @RequestParam("page") int page,ModelMap modelMap)
	{
		Medecin m = MedecinService.getMedecin(id);
		List<Specialite> spcs = MedecinService.getAllSpecialite();
	modelMap.addAttribute("Medecin", m);
	modelMap.addAttribute("mode", "edit");
	modelMap.addAttribute("page",page);
	modelMap.addAttribute("Specialite", spcs);
	return "formMedecin";
	}
	@RequestMapping("/updateMedecin")
	public String updateMedecin(@ModelAttribute("Medecin") Medecin Medecin,
	@RequestParam("date") String date,ModelMap modelMap) throws ParseException 
	{
		//conversion de la date 
		 SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
		 Date datenaissance = dateformat.parse(String.valueOf(date));
		 Medecin.setDatenaissance(datenaissance);
		 
		 MedecinService.updateMedecin(Medecin);
		 List<Medecin> Medecinl = MedecinService.getAllMedecins();
		 modelMap.addAttribute("Medecins", Medecinl);
		return "listeMedecin";
		}
}
