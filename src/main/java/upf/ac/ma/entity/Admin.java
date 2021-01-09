package upf.ac.ma.entity;

import java.io.Serializable;

import java.util.Date;

import java.lang.Long;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Admin
 *
 */
@Entity
@DiscriminatorValue("Admin")
public class Admin extends Compte implements Serializable {
	private Long idAdmin;
	private static final long serialVersionUID = 1L;
	public Admin() {
		super();
	}   
	public Long getIdAdmin() {
		return this.idAdmin;
	}

	public void setIdAdmin(Long idAdmin) {
		this.idAdmin = idAdmin;
	}
	public Admin(String nom, String prenom, String email, String motDePasse, Date dateNaissance) {
		super(nom, prenom, email, motDePasse, dateNaissance);
		// TODO Auto-generated constructor stub
	}
	
}
