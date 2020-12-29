package upf.ac.ma.coucheDAO;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import upf.ac.ma.entity.Enseignant;
import upf.ac.ma.entity.Filliere;

public class FiliereDAO {

	EntityManagerFactory emf = Persistence.createEntityManagerFactory("Gestion_d_Absences");
	EntityManager em 		 = emf.createEntityManager();
	

	public FiliereDAO() {
		// TODO Auto-generated constructor stub
	}
	
	public void ajouter(Filliere f)
	{
		em.getTransaction().begin();
		em.persist(f);
		em.getTransaction().commit();
	}
	
	public Filliere recuperer(Long id)
	{
		
		Filliere f = em.find(Filliere.class, id);
		return f;
	}
	
	public void mettreAjour(Filliere f)
	{
		
		Filliere fs = em.find(Filliere.class, f.getIdFilliere());
		em.getTransaction().begin();
		em.remove(fs);
		em.getTransaction().commit();
		
		em.getTransaction().begin();
		em.persist(f);
		em.getTransaction().commit();
	}
	
	public void supprimer(Filliere f)
	{
		
		Filliere fs = em.find(Filliere.class, f.getIdFilliere());
		em.getTransaction().begin();
		em.remove(fs);
		em.getTransaction().commit();
	}
	

}
