package upf.ac.ma.entity;

import java.io.Serializable;
import java.util.ArrayList;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Filliere
 *
 */
@Entity

public class Filliere implements Serializable {

	@Id @GeneratedValue
	private Long idFilliere;
	private String nom;
	
	private static final long serialVersionUID = 1L;

	
	public Filliere(String nom) {
		super();
		this.nom = nom;
	}
	
	public Filliere() {
		super();
	}

	public Long getIdFilliere() {
		return idFilliere;
	}

	public void setIdFilliere(Long idFilliere) {
		this.idFilliere = idFilliere;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}
   
}
