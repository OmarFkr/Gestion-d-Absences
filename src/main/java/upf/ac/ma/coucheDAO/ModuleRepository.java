package upf.ac.ma.coucheDAO;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import upf.ac.ma.entity.Module;

public interface ModuleRepository extends JpaRepository<Module, Long> {

	@Query("SELECT id FROM Module WHERE nom = :nomModule")
	Long findId(@Param("nomModule") String nomModule);
	
	@Query("SELECT m FROM Module m WHERE m.nom =:nomModule")
	Module findByNom(@Param("nomModule") String nomModule);
	
	//@Query("select a from Absence a inner join a.etudiant e where e.id =:x")
	@Query("SELECT m FROM Module m inner join m.semestre s WHERE s.id= :idSemestre")
	List<Module> findByIdSemestre(@Param("idSemestre") Long idSemestre);
	
	@Query("SELECT m FROM Module m inner join m.filliere f WHERE f.id = :id_filliere")
	List<Module> findByIdFilliere(@Param("id_filliere") Long id_filliere);
	
	
}
