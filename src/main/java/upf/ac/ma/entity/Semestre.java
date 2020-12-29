package upf.ac.ma.entity;

import java.io.Serializable;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Semestre
 *
 */
@Entity

public class Semestre implements Serializable {
	
	@Id @GeneratedValue
	private Long idSemeste;
	private String nom;
	private static final long serialVersionUID = 1L;

	public Semestre() {
		super();
	}
	
	public Semestre(String nom) {
		super();
		this.nom = nom;
	}
	
	public Long getIdSemeste() {
		return idSemeste;
	}

	public void setIdSemeste(Long idSemeste) {
		this.idSemeste = idSemeste;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}
   
}
