package upf.ac.ma.entity;

import java.io.Serializable;
import java.util.Date;
import java.lang.Long;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Scolarite
 *
 */
@Entity
@DiscriminatorValue("Scolarite")
public class Scolarite extends Compte implements Serializable {
	private Long idScolarite;
	private static final long serialVersionUID = 1L;
	public Scolarite() {
		super();
	}   
	public Long getIdScolarite() {
		return this.idScolarite;
	}

	public void setIdScolarite(Long idScolarite) {
		this.idScolarite = idScolarite;
	}
	public Scolarite(String nom, String prenom, String email, String motDePasse, Date dateNaissance) {
		super(nom, prenom, email, motDePasse, dateNaissance);
		// TODO Auto-generated constructor stub
	}
	
}
