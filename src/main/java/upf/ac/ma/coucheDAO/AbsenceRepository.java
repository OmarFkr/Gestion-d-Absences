package upf.ac.ma.coucheDAO;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import upf.ac.ma.entity.Absence;

public interface AbsenceRepository extends JpaRepository<Absence, Long> {
	
	//@Query("select a from Absence a inner join a.etudiant e where e.id =:x")
	@Query("SELECT a FROM Absence a inner join a.seance s WHERE s.id =:idSeance")
	List<Absence> findAllByIdSeance(@Param("idSeance") Long idSeance);
	
	@Query("SELECT a FROM Absence a inner join a.etudiant e WHERE e.id =:idEtudiant")
	List<Absence> findAllByIdEtudiant(@Param("idEtudiant") Long idEtudiant);
}
