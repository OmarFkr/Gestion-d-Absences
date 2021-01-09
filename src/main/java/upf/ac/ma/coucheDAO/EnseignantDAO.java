package upf.ac.ma.coucheDAO;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import upf.ac.ma.entity.Enseignant;

public class EnseignantDAO {


	EntityManagerFactory emf = Persistence.createEntityManagerFactory("Gestion_d_Absences");
	EntityManager em 		 = emf.createEntityManager();
	
	public EnseignantDAO() {
		// TODO Auto-generated constructor stub
	}
	
	public void ajouter(Enseignant e )
	{
		em.getTransaction().begin();
		em.persist(e);
		em.getTransaction().commit();
	}
	
	public Enseignant recuperer(Long id)
	{
		
		Enseignant e = em.find(Enseignant.class, id);
		return e;
	}
	
	public void mettreAjour(Enseignant e)
	{
		
		Enseignant es = em.find(Enseignant.class, e.getId());
		em.getTransaction().begin();
		em.remove(es);
		em.getTransaction().commit();
		
		em.getTransaction().begin();
		em.persist(e);
		em.getTransaction().commit();
	}
	
	public void supprimer(Enseignant e)
	{
		
		Enseignant es = em.find(Enseignant.class, e.getId());
		em.getTransaction().begin();
		em.remove(es);
		em.getTransaction().commit();
	}

}
