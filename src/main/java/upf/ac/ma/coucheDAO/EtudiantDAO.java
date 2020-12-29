package upf.ac.ma.coucheDAO;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import upf.ac.ma.entity.Compte;
import upf.ac.ma.entity.Enseignant;
import upf.ac.ma.entity.Etudiant;
import javax.persistence.Persistence;
public class EtudiantDAO {

	EntityManagerFactory emf = Persistence.createEntityManagerFactory("Gestion_d_Absences");
	EntityManager em 		 = emf.createEntityManager();
	
	public EtudiantDAO() {
		// TODO Auto-generated constructor stub
	}
	
	public void ajouter(Etudiant e )
	{
		em.getTransaction().begin();
		em.persist(e);
		em.getTransaction().commit();
	}
	
	public Etudiant recuperer(Long id) 
	{
		Etudiant e = em.find(Etudiant.class, id);
		return e;
	}
	
	public void mettreAjour(Etudiant e)
	{
		
		Etudiant es = em.find(Etudiant.class, e.getIdEtudiant());
		em.getTransaction().begin();
		em.remove(es);
		em.getTransaction().commit();
		
		em.getTransaction().begin();
		em.persist(e);
		em.getTransaction().commit();
	}
	
	public void supprimer(Etudiant e)
	{
		
		Etudiant es = em.find(Etudiant.class, e.getIdEtudiant());
		em.getTransaction().begin();
		em.remove(es);
		em.getTransaction().commit();
	}
	
	
	
	void changerMotDePasse(int idEtudiant, String NewPass)
	{
		Compte compte = (Compte) em.createQuery("SELECT * FROM compte WHERE id_utilisateur="+idEtudiant).getSingleResult();
		compte.setMotDePasse(NewPass);
		em.getTransaction().begin();
		em.persist(compte);
		em.getTransaction().commit();
	}


}
