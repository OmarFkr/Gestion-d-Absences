package upf.ac.ma.entity;

import java.io.Serializable;
import java.lang.Long;
import java.util.Date;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Compte
 *
 */
@MappedSuperclass
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="Role")

public abstract class Compte implements Serializable {
	   
	@Id @GeneratedValue @Column(name = "id_compte")
	private Long idCompte;
	private String nom;
	private String prenom;
	private String email;
	@Column(name = "mot_de_pass")
	private String motDePasse;
	@Temporal(TemporalType.DATE) @Column(name = "date_naissance")
	private Date dateNaissance;
	private static final long serialVersionUID = 1L;

	public Compte() {
		super();
	}


	public Long getIdCompte() {
		return idCompte;
	}

	public void setIdCompte(Long idCompte) {
		this.idCompte = idCompte;
	}


	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMotDePasse() {
		return motDePasse;
	}

	public void setMotDePasse(String motDePasse) {
		this.motDePasse = motDePasse;
	}

	public Date getDateNaissance() {
		return dateNaissance;
	}

	public void setDateNaissance(Date dateNaissance) {
		this.dateNaissance = dateNaissance;
	}


	public Compte(String nom, String prenom, String email, String motDePasse, Date dateNaissance) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.motDePasse = motDePasse;
		this.dateNaissance = dateNaissance;
	}
	
   
}
