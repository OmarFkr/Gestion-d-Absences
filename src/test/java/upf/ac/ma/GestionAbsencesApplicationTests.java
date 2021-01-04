package upf.ac.ma;

import java.util.Date;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import upf.ac.ma.coucheDAO.EtudiantRepository;
import upf.ac.ma.entity.Etudiant;

@SpringBootTest
class GestionAbsencesApplicationTests {

	@Autowired
	EtudiantRepository etdr;
	
	@Test
	void contextLoads() {
		
		etdr.save(new Etudiant("187AS", "FAKIR", "OMAR", "omar@", "password", new Date(1996,10,05)));
	}
	
}
