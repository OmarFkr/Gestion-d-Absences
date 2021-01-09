package upf.ac.ma.coucheDAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import upf.ac.ma.entity.Semestre;

public interface SemestreRepository extends JpaRepository<Semestre, Long>{
	
	@Query("SELECT s.id FROM Semestre s WHERE s.nom = :nomSemestre")
	Long findId(@Param("nomSemestre") String nomSemestre);

}
