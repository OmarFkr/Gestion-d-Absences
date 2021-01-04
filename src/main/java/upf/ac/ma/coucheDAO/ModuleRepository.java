package upf.ac.ma.coucheDAO;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import upf.ac.ma.entity.Module;

public interface ModuleRepository extends JpaRepository<Module, Long> {

	@Query("SELECT id_module FROM module WHERE nom = :nomModule")
	Long findId(@Param("nomModule") String nomModule);
	
	@Query("SELECT * FROM module WHERE id_semstre= :idSemestre")
	List<Module> findByIdSemestre(@Param("idSemestre") Long idSemestre);
	
	@Query("SELECT * FROM module WHERE id_filliere = :id_filliere")
	List<Module> findByIdFilliere(@Param("id_filliere") Long id_filliere);
	
	
}
