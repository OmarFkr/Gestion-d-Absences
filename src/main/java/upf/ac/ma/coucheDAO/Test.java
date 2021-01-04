package upf.ac.ma.coucheDAO;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;

import upf.ac.ma.entity.Etudiant;

public class Test {	
	public Test() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//AbsenceDAO abs = new AbsenceDAO();
		//Absence ab = new Absence();
		
		Etudiant e = new Etudiant("187AS", "FAKIR", "OMAR", "omar@", "password", new Date(1996,10,05));
		EtudiantDAO eDAO = new EtudiantDAO();
		//eDAO.ajouter(e);
				
	}

}
