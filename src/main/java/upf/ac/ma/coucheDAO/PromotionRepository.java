package upf.ac.ma.coucheDAO;

import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import upf.ac.ma.entity.Promotion;

public interface PromotionRepository extends JpaRepository<Promotion, Long>  {
	
	@Query("SELECT id FROM promotion WHERE date= :date")
	Long findIdByDate(@Param("date") Date date);

}
