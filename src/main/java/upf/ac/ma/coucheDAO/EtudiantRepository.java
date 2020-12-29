package upf.ac.ma.coucheDAO;

import org.springframework.data.jpa.repository.JpaRepository;

import upf.ac.ma.entity.Etudiant;

public interface EtudiantRepository extends JpaRepository<Etudiant, Long> {

	
}
