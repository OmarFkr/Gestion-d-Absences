package upf.ac.ma.coucheDAO;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import upf.ac.ma.entity.Seance;

public interface SeanceRepository extends JpaRepository<Seance, Long> {
	
	//@Query("select a from Absence a inner join a.etudiant e where e.id =:x")
	@Query("SELECT s FROM Seance s inner join s.module m WHERE m.id= :idModule")
	List<Seance> findAllByIdModule(@Param("idModule") Long idModule);

}
