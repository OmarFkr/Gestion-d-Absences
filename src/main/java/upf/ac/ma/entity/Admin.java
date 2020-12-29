package upf.ac.ma.entity;

import java.io.Serializable;
import java.lang.Long;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Admin
 *
 */
@Entity
@DiscriminatorValue("Admin")
public class Admin implements Serializable {

	   
	@Id
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
   
}
