package upf.ac.ma.coucheDAO;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import upf.ac.ma.entity.Seance;

public class SeanceDAO {

	EntityManagerFactory emf = Persistence.createEntityManagerFactory("Gestion_d_Absences");
	EntityManager em 		 = emf.createEntityManager();
	
	public SeanceDAO() {
		// TODO Auto-generated constructor stub
	}
	
	public void ajouter(Seance s)
	{
		em.getTransaction().begin();
		em.persist(s);
		em.getTransaction().commit();
	}
	
	public Seance recuperer(Long id)
	{
		Seance s = em.find(Seance.class, id);
		return s;
	}
	
	public void mettreAjour(Seance s)
	{
		
		Seance ss = em.find(Seance.class,s.getIdSeance());
		em.getTransaction().begin();
		em.remove(ss);
		em.getTransaction().commit();
		
		em.getTransaction().begin();
		em.persist(s);
		em.getTransaction().commit();
	}
	
	public void supprimer(Seance s)
	{
		Seance ss = em.find(Seance.class, s.getIdSeance());
		em.getTransaction().begin();
		em.remove(ss);
		em.getTransaction().commit();
	}
	
}
