package upf.ac.ma.coucheDAO;

import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import upf.ac.ma.entity.Filliere;

public interface FilliereRepository extends JpaRepository<Filliere, Long>{
	
	@Query("SELECT * FROM filliere WHERE nom= :nom AND id_promotion= :idPromotion")
	Filliere findByNomAndIdPromo(@Param("nom") String nom,@Param("idPromotion") Long idPromotion );

}
