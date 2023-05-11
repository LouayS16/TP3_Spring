package com.louay.Medecin.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.louay.Medecin.entities.Medecin;
import com.louay.Medecin.entities.Specialite;
@RepositoryRestResource(path = "rest")
public interface MedecinRepository extends JpaRepository<Medecin, Long> {
	List<Medecin> findByNomMedecin(String nom);
	List<Medecin> findByNomMedecinContains(String nom);
	@Query("select m from Medecin m where m.nomMedecin like %:nom and m.salaire > :salaire")
	List<Medecin> findByNomSalaire (@Param("nom") String nom,@Param("salaire") Double salaire);
	@Query("select m from Medecin m where m.specialite = ?1")
	List<Medecin> findBySpecialite(Specialite specialite);


	List<Medecin> findBySpecialiteIdSpc(Long id);
	List<Medecin> findByOrderByNomMedecinAsc();
	@Query("select m from Medecin m order by m.nomMedecin ASC, m.salaire DESC")
	List<Medecin> trierMedecinsNomsSalaire ();

}
