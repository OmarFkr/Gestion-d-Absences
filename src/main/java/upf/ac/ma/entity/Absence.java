package upf.ac.ma.entity;

import java.io.Serializable;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Absence
 *
 */
@Entity

public class Absence implements Serializable {
	
	@Id @GeneratedValue @Column(name = "id_absence")
	private Long idAbsence;
	@ManyToOne @JoinColumn
	private Seance seance;
	@OneToOne @JoinColumn
	private Etudiant etudiant;
	private static final long serialVersionUID = 1L;
	
	public Absence(Seance seance, Etudiant etudiant) {
		super();
		this.seance = seance;
		this.etudiant = etudiant;
	}
	public Etudiant getEtudiant() {
		return etudiant;
	}

	public void setEtudiant(Etudiant etudiant) {
		this.etudiant = etudiant;
	}

	public Long getIdAbsence() {
		return idAbsence;
	}

	public void setIdAbsence(Long idAbsence) {
		this.idAbsence = idAbsence;
	}

	public Seance getSeance() {
		return seance;
	}

	public void setSeance(Seance seance) {
		this.seance = seance;
	}
	
		
	public Absence(Seance seance) {
		super();
		this.seance = seance;
	}


	public Absence() {
		super();
	}
   
}