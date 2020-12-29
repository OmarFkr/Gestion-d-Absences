package upf.ac.ma.entity;

import java.io.Serializable;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Module
 *
 */
@Entity

public class Module implements Serializable {

	@Id @GeneratedValue @Column(name = "id_module")
	private Long idModule;
	private String nom;
	@ManyToOne @JoinColumn
	private Filliere filliere;
	@ManyToOne @JoinColumn
	private Enseignant enseignant;
	@ManyToOne @JoinColumn
	private Semestre semestre;
	private static final long serialVersionUID = 1L;

	public Module(String nom, Filliere filliere, Enseignant enseignant, Semestre semestre) {
		super();
		this.nom = nom;
		this.filliere = filliere;
		this.enseignant = enseignant;
		this.semestre = semestre;
	}
	
	public Module() {
		super();
	}

	public Long getIdModule() {
		return idModule;
	}

	public void setIdModule(Long idModule) {
		this.idModule = idModule;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public Filliere getFilliere() {
		return filliere;
	}

	public void setFilliere(Filliere filliere) {
		this.filliere = filliere;
	}

	public Enseignant getEnseignant() {
		return enseignant;
	}

	public void setEnseignant(Enseignant enseignant) {
		this.enseignant = enseignant;
	}
	
	public Semestre getSemestre() {
		return semestre;
	}

	public void setSemestre(Semestre semestre) {
		this.semestre = semestre;
	}
	
	
   
}
