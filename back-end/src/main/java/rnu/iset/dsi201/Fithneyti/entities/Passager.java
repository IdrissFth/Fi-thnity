package rnu.iset.dsi201.Fithneyti.entities;


import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;


@Entity
@Table(name = "Passager")
public class Passager extends Person{
		private static final long serialVersionUID = 1L;
		@JsonIgnore
		@ManyToOne(fetch = FetchType.LAZY)
	    private Trajet trajet;
		@JsonIgnore
		@ManyToOne
		@JoinColumn(name = "conducteur_id")
		private Conducteur conducteur;
		public Passager() {
			super();
			// TODO Auto-generated constructor stub
		}

		public Passager(String email, String nom, String prenom, String password, int Numerotlf) {
			super(email, nom, prenom,password,Numerotlf);
			this.trajet= null;
			// TODO Auto-generated constructor stub
		}
		
		public Trajet getTrajet() {
			return trajet;
		}

		public void setTrajet(Trajet trajet) {
			this.trajet = trajet;
		}

		public Conducteur getConducteur() {
			return conducteur;
		}

		public void setConducteur(Conducteur conducteur) {
			this.conducteur = conducteur;
		}

	        
		@Override
		public String toString() {
			return "User [getEmail()=" + getEmail() + ", getNom()=" + getNom() + ", getPrenom()=" + getPrenom()
					+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString()
					+ "]";
		}
}
