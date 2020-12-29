package upf.ac.ma.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Promotion
 *
 */
@Entity

public class Promotion implements Serializable {

	@Id @GeneratedValue
	private Long id;
	@Temporal(TemporalType.DATE) @Column(name = "date_debut")
	private Date dateDebut;
	@ManyToOne @JoinColumn
	private Filliere filliere;
	@OneToOne @JoinColumn 
	private EmploiDuTemps emploi_du_temps;
	private static final long serialVersionUID = 1L;
	

	public Promotion(Date dateDebut, Filliere filliere, EmploiDuTemps emploiDuTemps) {
		super();
		this.dateDebut = dateDebut;
		this.filliere = filliere;
		this.emploi_du_temps = emploiDuTemps;
	}


	public Promotion() {
		super();
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public Date getDateDebut() {
		return dateDebut;
	}


	public void setDateDebut(Date dateDebut) {
		this.dateDebut = dateDebut;
	}


	public Filliere getFilliere() {
		return filliere;
	}


	public void setFilliere(Filliere filliere) {
		this.filliere = filliere;
	}


	public EmploiDuTemps getEmploiDuTemps() {
		return emploi_du_temps;
	}


	public void setEmploiDuTemps(EmploiDuTemps emploiDuTemps) {
		this.emploi_du_temps = emploiDuTemps;
	}
   
}
