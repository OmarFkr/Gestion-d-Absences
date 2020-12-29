package upf.ac.ma.coucheDAO;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import upf.ac.ma.entity.Promotion;

public class PromotionDAO {

	EntityManagerFactory emf = Persistence.createEntityManagerFactory("Gestion_d_Absences");
	EntityManager em 		 = emf.createEntityManager();
	
	public PromotionDAO() {
		// TODO Auto-generated constructor stub
	}
	
	public void ajouter(Promotion p)
	{
		em.getTransaction().begin();
		em.persist(p);
		em.getTransaction().commit();
	}
	
	public Promotion recuperer(Long id)
	{
		Promotion p = em.find(Promotion.class, id);
		return p;
	}
	
	public void mettreAjour(Promotion p)
	{
		
		Promotion ps = em.find(Promotion.class,p.getId());
		em.getTransaction().begin();
		em.remove(ps);
		em.getTransaction().commit();
		
		em.getTransaction().begin();
		em.persist(p);
		em.getTransaction().commit();
	}
	
	public void supprimer(Promotion p)
	{
		Promotion ps = em.find(Promotion.class, p.getId());
		em.getTransaction().begin();
		em.remove(ps);
		em.getTransaction().commit();
	}

}
