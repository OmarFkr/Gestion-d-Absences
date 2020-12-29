package upf.ac.ma.entity;

import java.io.Serializable;
import java.lang.Long;
import java.util.Date;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Enseignant
 *
 */
@Entity
@DiscriminatorValue("Enseignant")
public class Enseignant extends Compte implements Serializable {

	//@Id
	//private Long idEnseignant;
	private static final long serialVersionUID = 1L;
	@OneToOne @JoinColumn
	private EmploiDuTemps emploiDuTemps;
	public Enseignant() {
		super();
	}   
	
	
	public Long getIdEnseignant() {
		return super.getIdCompte();
	}

	public void setIdEnseignant(Long idEnseignant) {
		super.setIdCompte(idEnseignant);
	}
	
	public Enseignant(String nom, String prenom, String email, String motDePasse, Date dateNaissance) {
		//super(nom, prenom, email, motDePasse, dateNaissance);
		// TODO Auto-generated constructor stub
	}
	
	public EmploiDuTemps getEmploiDuTemps() {
		return emploiDuTemps;
	}
	
	public void setEmploiDuTemps(EmploiDuTemps emploiDuTemps) {
		this.emploiDuTemps = emploiDuTemps;
	}
   
}
