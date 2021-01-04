package upf.ac.ma.coucheDAO;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import upf.ac.ma.entity.Seance;

public interface SeanceRepository extends JpaRepository<Seance, Long> {
	
	@Query("SELECT * FROM seance WHERE id_module= :idModule")
	List<Seance> findAllByIdModule(@Param("idModule") Long idModule);

}
