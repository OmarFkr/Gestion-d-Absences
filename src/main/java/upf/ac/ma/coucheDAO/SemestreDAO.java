package upf.ac.ma.coucheDAO;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import upf.ac.ma.entity.Seance;
import upf.ac.ma.entity.Semestre;

public class SemestreDAO {

	EntityManagerFactory emf = Persistence.createEntityManagerFactory("Gestion_d_Absences");
	EntityManager em 		 = emf.createEntityManager();
	
	public SemestreDAO() {
		// TODO Auto-generated constructor stub
	}
	
	public void ajouter(Semestre s)
	{
		em.getTransaction().begin();
		em.persist(s);
		em.getTransaction().commit();
	}
	
	public Semestre recuperer(Long id)
	{
		Semestre s = em.find(Semestre.class, id);
		return s;
	}
	
	public void mettreAjour(Semestre s)
	{
		
		Semestre ss = em.find(Semestre.class,s.getIdSemeste()));
		em.getTransaction().begin();
		em.remove(ss);
		em.getTransaction().commit();
		
		em.getTransaction().begin();
		em.persist(s);
		em.getTransaction().commit();
	}
	
	public void supprimer(Semestre s)
	{
		Semestre ss = em.find(Semestre.class, s.getIdSemeste());
		em.getTransaction().begin();
		em.remove(ss);
		em.getTransaction().commit();
	}
	

}
