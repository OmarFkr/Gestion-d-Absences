package upf.ac.ma;

import java.util.Date;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import upf.ac.ma.coucheDAO.EtudiantRepository;
import upf.ac.ma.entity.Etudiant;

@SpringBootApplication
public class GestionAbsencesApplication {

	public static void main(String[] args) {
		//ApplicationContext ctx =
		SpringApplication.run(GestionAbsencesApplication.class, args);
		//EtudiantRepository etudiantRepository = ctx.getBean(EtudiantRepository.class);
		//etudiantRepository.save(new Etudiant("18260","FAKIR","OMAR","fakir.omaar@gmail.com","1996",new Date(1996,05,10)));
	}

}
