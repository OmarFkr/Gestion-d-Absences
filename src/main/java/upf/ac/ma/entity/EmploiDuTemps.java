package upf.ac.ma.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;


/**
 * Entity implementation class for Entity: EmploiDuTemps
 *
 */
@Entity

public class EmploiDuTemps implements Serializable {

	@Id @GeneratedValue
	private Long idEmploi;
	@OneToMany(fetch = FetchType.LAZY, 
		       cascade =
	       {
	    		   CascadeType.MERGE,
	               CascadeType.REMOVE
	       }) @JoinColumn
	private List<Seance>seances;
	@OneToOne(optional = true,fetch = FetchType.LAZY, 
		       cascade =
	       {
	    		   CascadeType.MERGE,
	               CascadeType.REMOVE
	       })
	private Promotion promotion;
	@OneToOne(optional = true,fetch = FetchType.LAZY, 
		       cascade =
	       {
	    	   CascadeType.MERGE,
               CascadeType.REMOVE
	       })
	private Enseignant enseignant;
	private static final long serialVersionUID = 1L;

	public EmploiDuTemps() {
		super();
	}

	public EmploiDuTemps(List<Seance> seances, Promotion promotion, Enseignant enseignant) {
		super();
		this.seances = seances;
		this.promotion = promotion;
		this.enseignant = enseignant;
	}

	public Long getIdEmploi() {
		return idEmploi;
	}

	public void setIdEmploi(Long idEmploi) {
		this.idEmploi = idEmploi;
	}

	public List<Seance> getSeances() {
		return seances;
	}

	public void setSeances(List<Seance> seances) {
		this.seances = seances;
	}

	public Promotion getPromotion() {
		return promotion;
	}

	public void setPromotion(Promotion promotion) {
		this.promotion = promotion;
	}

	public Enseignant getEnseignant() {
		return enseignant;
	}

	public void setEnseignant(Enseignant enseignant) {
		this.enseignant = enseignant;
	}
   
}
