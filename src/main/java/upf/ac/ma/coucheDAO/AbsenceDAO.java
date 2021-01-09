package upf.ac.ma.coucheDAO;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.springframework.beans.factory.annotation.Autowired;

import upf.ac.ma.entity.Absence;
import upf.ac.ma.entity.Etudiant;
import upf.ac.ma.entity.Filliere;
import upf.ac.ma.entity.Seance;
import upf.ac.ma.entity.Semestre;
import upf.ac.ma.entity.Module;
import upf.ac.ma.entity.Promotion;

public class AbsenceDAO {

	EntityManagerFactory emf = Persistence.createEntityManagerFactory("Gestion_d_Absences");
	EntityManager em 		 = emf.createEntityManager();
	
	@Autowired
	AbsenceRepository absenceRepo;
	@Autowired
	ModuleRepository moduleRepo;
	@Autowired
	SeanceRepository seanceRepo;
	@Autowired
	SemestreRepository semestreRepo;
	@Autowired
	PromotionRepository promotionRepo;
	@Autowired
	FilliereRepository filliereRepo;
	
	public AbsenceDAO() {
		// TODO Auto-generated constructor stub
	}
	
	public int classementAbsenceClasse(Long idEtudiant, String filiere, Date promotion) {
		
		Long idPromo = promotionRepo.findIdByDate(promotion);
		Filliere filiere_ = filliereRepo.findByNomAndIdPromo(filiere,idPromo);		
		List<Module> listModules  = moduleRepo.findByIdFilliere(filiere_.getIdFilliere());
		
		//RECUPERE LES SEANCES DES MODULES
		List<Seance> listSeances = new ArrayList<Seance>();
		for (Module module : listModules)
		{
			listSeances.addAll(seanceRepo.findAllByIdModule(module.getIdModule()));
		}
		
		//RECUPERER LES ABSENCES DES SEANCES DES ETUDIANTS DU PROMO
		List<Absence> listAbsences = new ArrayList<Absence>();
		for (Seance seance : listSeances)
		{
			listAbsences.addAll(absenceRepo.findAllByIdSeance(seance.getIdSeance()));
		}
		
		//RECUPERER LES IDs
		Set<Long> ids = new HashSet<Long>();
		for (Absence absence: listAbsences) {
			ids.add(absence.getEtudiant().getId());
		}
		
		//DEFINIR LES MAP
		Map<Long, Integer> id_nbr_a=new LinkedHashMap<Long, Integer>();  
		TreeMap<Long, Integer> id_nbr_a_sorted = new TreeMap<Long, Integer>();
		
		//RECUPERE LES IDS DES ETUDIANTS ET LE NOMBRE DABSENCE 
		for (Long id : ids) {
			int nbr_a = 0;
			for (Absence absence: listAbsences) {
				if (id == absence.getEtudiant().getId())
				{	nbr_a++; }
				id_nbr_a.put(id, nbr_a);
			}	
		}
		
		//SORT BY NOMBRE DABSENCE 
		id_nbr_a.entrySet()
	    .stream()
	    .sorted(Map.Entry.comparingByValue())
	    .forEachOrdered(x -> id_nbr_a_sorted.put(x.getKey(), x.getValue()));
		
		int classement = id_nbr_a_sorted.headMap(idEtudiant).size();
		
		return classement;
	}
	
	
	List<Absence> getAllAbsences(Etudiant e)
	{
		List<Absence> listAbsences = absenceRepo.findAllByIdEtudiant(e.getId());
		return listAbsences;
	}
	
	
	List<Absence> getAbsencesSemestre(String semestre)
	{
		//RECUPERER LE SEMESTRE
		Long id_semestre = semestreRepo.findId(semestre);
		//RECUPERER LES MODULES ENSEIGNER DANS LE SEMESTRE
		List<Module> listModules = moduleRepo.findByIdSemestre(id_semestre);
		//RECUPERE LES SEANCES DES MODULES
		List<Seance> listSceances = new ArrayList<Seance>();
		for (Module module : listModules)
		{
			listSceances.addAll(seanceRepo.findAllByIdModule(module.getIdModule()));	
		}
		//RECUPERER LES ABSENCES DES SEANCES
		List<Absence> listAbsences = new ArrayList<Absence>();
		for (Seance seance : listSceances)
		{
			listAbsences.addAll(absenceRepo.findAllByIdSeance(seance.getIdSeance()));
		}
			
		return listAbsences;
	}

	List<Absence> getAbsencesModule(String nomModule) {
		
		List<Seance> listSeances = new ArrayList<Seance>();
		
		Long id_module = moduleRepo.findId(nomModule);		
		
		listSeances.addAll(seanceRepo.findAllByIdModule(id_module));
		
		//RECUPERER LES ABSENCES DES SEANCES
		List<Absence> listAbsence = new ArrayList<Absence>();
		
		for (Seance seance : listSeances)
		{
			listAbsence.addAll(absenceRepo.findAllByIdSeance(seance.getIdSeance()));
		}
			
		return listAbsence;
	}
	
	
	public void ajouter(Absence a)
	{
		
		em.getTransaction().begin();
		em.persist(a);
		em.getTransaction().commit();
	}
	
	public Absence recuperer(Long id)
	{
		
		Absence a = em.find(Absence.class, id);
		return a;
	}
	
	public void mettreAjour(Absence a)
	{
		
		Absence ab = em.find(Absence.class, a.getIdAbsence());
		em.getTransaction().begin();
		em.remove(ab);
		em.getTransaction().commit();
		
		em.getTransaction().begin();
		em.persist(a);
		em.getTransaction().commit();
	}
	
	public void supprimer(Absence a)
	{
		
		Absence ab = em.find(Absence.class, a.getIdAbsence());
		em.getTransaction().begin();
		em.remove(ab);
		em.getTransaction().commit();
	}
	
	
	
}
