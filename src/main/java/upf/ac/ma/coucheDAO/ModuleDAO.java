package upf.ac.ma.coucheDAO;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import upf.ac.ma.entity.Module;

public class ModuleDAO {
	
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("Gestion_d_Absences");
	EntityManager em 		 = emf.createEntityManager();
	
	public ModuleDAO() {
		// TODO Auto-generated constructor stub
	}
	
	public void ajouter(Module m)
	{
		em.getTransaction().begin();
		em.persist(m);
		em.getTransaction().commit();
	}
	
	public Module recuperer(Long id)
	{
		Module m = em.find(Module.class, id);
		return m;
	}
	
	public void mettreAjour(Module m)
	{
		
		Module ms = em.find(Module.class,m.getIdModule());
		em.getTransaction().begin();
		em.remove(ms);
		em.getTransaction().commit();
		
		em.getTransaction().begin();
		em.persist(m);
		em.getTransaction().commit();
	}
	
	public void supprimer(Module m)
	{
		Module ms = em.find(Module.class, m.getIdModule());
		em.getTransaction().begin();
		em.remove(ms);
		em.getTransaction().commit();
	}

}
