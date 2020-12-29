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
	
	public AbsenceDAO() {
		// TODO Auto-generated constructor stub
	}
	
	@SuppressWarnings("unchecked")
	public int classementAbsenceClasse(Long idEtudiant, String filiere, Date promotion) {
		
		Promotion promo    = (Promotion) em.createQuery("SELECT id FROM promotion WHERE date="+promotion).getResultList();
		Filliere filiere_  = (Filliere) em.createQuery("SELECT * FROM filliere WHERE nom="+filiere+"AND id_promotion="+promo).getResultList();
		List<Module> lstm  = em.createQuery("SELECT * FROM module WHERE id_filiere="+filiere_.getIdFilliere()).getResultList();
		//RECUPERE LES SEANCES DES MODULES
		List<Seance> lsts = new ArrayList<Seance>();
		for (Module module : lstm)
		{
			lsts.addAll(em.createQuery("SELECT * FROM seance WHERE id_module="+module.getIdModule()).getResultList());
		}
		//RECUPERER LES ABSENCES DES SEANCES DES ETUDIANTS DU PROMO
		List<Absence> lsta = new ArrayList<Absence>();
		for (Seance seance : lsts)
		{
			lsta.addAll(em.createQuery("SELECT * FROM absence WHERE id_seance="+seance.getIdSeance()).getResultList());
		}
		
		//RECUPERER LES IDs
		Set<Long> ids = new HashSet<Long>();
		for (Absence absence: lsta) {
			ids.add(absence.getEtudiant().getIdEtudiant());
		}
		
		//DEFINIR LES MAP
		Map<Long, Integer> id_nbr_a=new LinkedHashMap<Long, Integer>();  
		TreeMap<Long, Integer> id_nbr_a_sorted = new TreeMap<Long, Integer>();
		
		//RECUPERE LES IDS DES ETUDIANTS ET LE NOMBRE DABSENCE 
		for (Long id : ids) {
			int nbr_a = 0;
			for (Absence absence: lsta) {
				if (id == absence.getEtudiant().getIdEtudiant())
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
		@SuppressWarnings("unchecked")
		List<Absence> lstAbs = em.createQuery("SELECT * FROM absence WHERE id_etudiant="+e.getIdEtudiant()).getResultList();
		return lstAbs;
	}
	
	
	@SuppressWarnings("unchecked")
	List<Absence> getAbsencesSemestre(String semestre)
	{
		//RECUPERER LE SEMESTRE
		Semestre s        = (Semestre) em.createQuery("SELECT * FROM semestre WHERE nom="+semestre).getResultList();
		//RECUPERER LES MODULES ENSEIGNER DANS LE SEMESTRE
		List<Module> lstm = em.createQuery("SELECT * FROM module WHERE id_semstre="+s.getIdSemeste()).getResultList();
		//RECUPERE LES SEANCES DES MODULES
		List<Seance> lsts = new ArrayList<Seance>();
		for (Module module : lstm)
		{
			lsts.addAll(em.createQuery("SELECT * FROM seance WHERE id_module="+module.getIdModule()).getResultList());
		}
		//RECUPERER LES ABSENCES DES SEANCES
		List<Absence> lsta = new ArrayList<Absence>();
		for (Seance seance : lsts)
		{
			lsta.addAll(em.createQuery("SELECT * FROM absence WHERE id_seance="+seance.getIdSeance()).getResultList());
		}
			
		return lsta;
	}
	
	@SuppressWarnings("unchecked")
	List<Absence> getAbsencesModule(String nomModule) {
		
		List<Seance> lsts = new ArrayList<Seance>();
		int id_module = em.createQuery("SELECT id_module FROM module WHERE nom="+nomModule).getFirstResult();
		lsts.addAll(em.createQuery("SELECT * FROM seance WHERE id_module="+id_module).getResultList());
		//RECUPERER LES ABSENCES DES SEANCES
		List<Absence> lsta = new ArrayList<Absence>();
		for (Seance seance : lsts)
		{
			lsta.addAll(em.createQuery("SELECT * FROM absence WHERE id_seance="+seance.getIdSeance()).getResultList());
		}
			
		return lsta;
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
