package com.louay.Medecin;

import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;

import com.louay.Medecin.entities.Medecin;
import com.louay.Medecin.entities.Specialite;
import com.louay.Medecin.repos.MedecinRepository;
import com.louay.Medecin.service.MedecinService;

@SpringBootTest
class MedecinApplicationTests {

	@Autowired
	private MedecinRepository MedecinRepository;
	@Autowired
	private MedecinService  MedecinService ;
	@Test
	public void testCreateMedecin() {
		Medecin Medecin1 = new Medecin("mouhamed kileni",25000.00,new Date());
		MedecinRepository.save(Medecin1);
	}
	@Test
	public void testFindMedecin()
	{
		Medecin m = MedecinRepository.findById(1L).get(); 
	System.out.println(m);
	}
	@Test
	public void testUpdateChat()
	{
		Medecin m = MedecinRepository.findById(1L).get();
	m.setSalaire(1000.0);
	MedecinRepository.save(m);
	}
	@Test
	public void testDeleteFreelancer()
	{
		MedecinRepository.deleteById(1L);;
	}
	@Test
	public void testListerTousMedecins()
	{
	List<Medecin> Medecins = MedecinRepository.findAll();
	for (Medecin m : Medecins)
	{
	System.out.println(m);
	}
	}
	@Test
	public void testFindBynomMedecinContains()
	{
	Page<Medecin> Medecin1 = MedecinService.getAllMedecinParPage(0,3);
	System.out.println(Medecin1.getSize());
	System.out.println(Medecin1.getTotalElements());
	System.out.println(Medecin1.getTotalPages());
	Medecin1.getContent().forEach(m -> {System.out.println(m.toString());
	 });
	
	}
	@Test
	public void testfindByNomChat()
	{
	List<Medecin> Medecin1 = MedecinRepository.findByNomMedecin("Mouhamed Ali Mansour");
	for (Medecin m : Medecin1)
	{
	System.out.println(m);
	}
	}
	@Test
	public void testFindByNomChatContains()
	{
	List<Medecin> Medecin1=MedecinRepository.findByNomMedecinContains("m");
	for (Medecin m : Medecin1)
	{
	System.out.println(m);
	} }
	@Test
	public void testfindByNomSalaire()
	{
	List<Medecin> Medecin1 = MedecinRepository.findByNomSalaire("Sousou", 50.0);
	for (Medecin m : Medecin1)
	{
	System.out.println(m);
	}
	}

	@Test
	public void testfindBySpecialite()
	{
		Specialite spc = new Specialite();
	spc.setIdSpc(1L);
	List<Medecin> Medecin1 = MedecinRepository.findBySpecialite(spc);
	for (Medecin m : Medecin1)
	{
	System.out.println(m);
	}
	}
	
	@Test
	public void findBySpecialiteIdSpc()
	{
	List<Medecin> Medecin1 = MedecinRepository.findBySpecialiteIdSpc(1L);
	for (Medecin m : Medecin1)
	{
	System.out.println(m);
	}
	 }
	@Test
	public void testfindByOrderByNomMedecinAsc()
	{
	List<Medecin> Medecin1 = MedecinRepository.findByOrderByNomMedecinAsc();
	for (Medecin m : Medecin1)
	{
	System.out.println(m);
	}
	}
	@Test
	public void testTrierMedecinsNomsSalaire()
	{
	List<Medecin> Medecin1 = MedecinRepository.trierMedecinsNomsSalaire();
	for (Medecin m : Medecin1)
	{
	System.out.println(m);
	}
	}

}
