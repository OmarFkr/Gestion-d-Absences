package upf.ac.ma.entity;

import java.io.Serializable;
import java.lang.Long;
import java.util.Date;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Etudiant
 *
 */
@Entity
@DiscriminatorValue("Etudiant")
public class Etudiant extends Compte implements Serializable {

	   
	//@Id DOES NOT WORK
	private Long idEtudiant;
	private static final long serialVersionUID = 1L;
	@ManyToOne @JoinColumn
	private Promotion promotion;
	@Column(unique = true)
	private String cne;

	public Etudiant() {
		super();
	}   
	public Long getIdEtudiant() {
		return this.idEtudiant;
	}

	public void setIdEtudiant(Long idEtudiant) {
		this.idEtudiant = idEtudiant;
	}
	public Etudiant(String nom, String prenom, String email, String motDePasse, Date dateNaissance) {
		super(nom, prenom, email, motDePasse, dateNaissance);
		// TODO Auto-generated constructor stub
	}
	public Promotion getPromotion() {
		return promotion;
	}
	public void setPromotion(Promotion promotion) {
		this.promotion = promotion;
	}
	public String getCne() {
		return cne;
	}
	public void setCne(String cne) {
		this.cne = cne;
	}
   
}
