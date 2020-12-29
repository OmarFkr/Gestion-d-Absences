package upf.ac.ma.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Seance
 *
 */
@Entity

public class Seance implements Serializable {

	@Id
	private Long idSeance;
	private String jour;
	@Temporal(TemporalType.TIME)
	private Date heure;
	private String salle;
	private static final long serialVersionUID = 1L;
	@ManyToOne @JoinColumn
	private Module module;
	@ManyToOne @JoinColumn
	private Enseignant enseignant;

	public Long getIdSeance() {
		return idSeance;
	}

	public void setIdSeance(Long idSeance) {
		this.idSeance = idSeance;
	}

	public String getJour() {
		return jour;
	}

	public void setJour(String jour) {
		this.jour = jour;
	}

	public Date getHeure() {
		return heure;
	}

	public void setHeure(Date heure) {
		this.heure = heure;
	}

	public String getSalle() {
		return salle;
	}

	public void setSalle(String salle) {
		this.salle = salle;
	}

	public Module getModule() {
		return module;
	}

	public void setModule(Module module) {
		this.module = module;
	}

	public Enseignant getEnseignant() {
		return enseignant;
	}

	public void setEnseignant(Enseignant enseignant) {
		this.enseignant = enseignant;
	}

	public Seance(String jour, Date heure, String salle, Module module, Enseignant enseignant) {
		super();
		this.jour = jour;
		this.heure = heure;
		this.salle = salle;
		this.module = module;
		this.enseignant = enseignant;
	}

	public Seance() {
		super();
	}

	
}
