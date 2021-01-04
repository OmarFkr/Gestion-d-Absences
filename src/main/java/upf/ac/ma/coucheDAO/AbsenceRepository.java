package upf.ac.ma.coucheDAO;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import upf.ac.ma.entity.Absence;

public interface AbsenceRepository extends JpaRepository<Absence, Long> {
	
	@Query("SELECT * FROM absence WHERE id_seance= :idSeance")
	List<Absence> findAllByIdSeance(@Param("idSeance") Long idSeance);
	
	@Query("SELECT * FROM absence WHERE id_etudiant= :idEtudiant")
	List<Absence> findAllByIdEtudiant(@Param("idEtudiant") Long idEtudiant);
}
