package rnu.iset.dsi201.Fithneyti.entities;

import java.util.List;

import jakarta.persistence.*;
import jakarta.persistence.OneToOne;

@Entity
@Table(name = "conducteur")
public class Conducteur extends Person{
	private static final long serialVersionUID = 1L;
	
	@OneToMany(mappedBy = "conducteur")
    private List<Passager> passager;
	
	@OneToOne(mappedBy = "conducteur",cascade = CascadeType.ALL)
    private Trajet trajet;
	public Conducteur() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Conducteur(String email, String nom, String prenom, String password, int Numerotlf) {
		super(email, nom, prenom,password,Numerotlf);
		
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public String toString() {
		return "User [getEmail()=" + getEmail() + ", getNom()=" + getNom() + ", getPrenom()=" + getPrenom()
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString()
				+ "]";
	}
    public void addTrajet(Trajet trajet) {
        this.trajet = trajet;
        trajet.setConducteur(this);
    }
}
