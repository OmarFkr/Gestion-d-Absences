package upf.ac.ma.coucheDAO;

import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import upf.ac.ma.entity.Filliere;
import upf.ac.ma.entity.Promotion;

public interface PromotionRepository extends JpaRepository<Promotion, Long>  {
	
	
	@Query("SELECT p.id FROM Promotion p WHERE p.dateDebut= :date")
	Long findIdByDate(@Param("date") Date date);
	
	//@Query("select a from Absence a inner join a.etudiant e where e.id =:x")
	@Query("SELECT f FROM Promotion p inner join p.filliere f WHERE p.id =:idPromo AND f.nom =:nomFilliere")
	Filliere findFilliereByIdAndNomF(@Param("idPromo") Long idPromo,@Param("nomFilliere") String nomFilliere );

}
