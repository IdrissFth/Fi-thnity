package rnu.iset.dsi201.Fithneyti.entities;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;

@Entity
@Table(name = "Trajet")
public class Trajet {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idtrajet;
	private LocalDate ldate;
	private LocalDate lheure;
	private String ptsdepart;
	private String ptsfin;
	private int nbreplace;
	@JsonIgnore
	@OneToMany
	private List<Passager> passagers;
	@OneToOne
	@JsonIgnore
	@JoinColumn(name = "Conducteur_id")
	private Conducteur conducteur;
	
	public int getIdtrajet() {
		return idtrajet;
	}
	public LocalDate getLdate() {
		return ldate;
	}
	public void setLdate(LocalDate ldate) {
		this.ldate = ldate;
	}
	public LocalDate getLheure() {
		return lheure;
	}
	public void setLheure(LocalDate lheure) {
		this.lheure = lheure;
	}
	public String getPtsdepart() {
		return ptsdepart;
	}
	public void setPtsdepart(String ptsdepart) {
		this.ptsdepart = ptsdepart;
	}
	public String getPtsfin() {
		return ptsfin;
	}
	public void setPtsfin(String ptsfin) {
		this.ptsfin = ptsfin;
	}
	public int getNbreplace() {
		return nbreplace;
	}
	public void setNbreplace(int nbreplace) {
		this.nbreplace = nbreplace;
	}
	public Trajet(String ptsdepart,String ptsfin ,int nbreplace) {
		super();
		this.ldate = LocalDate.now();
		this.lheure = LocalDate.now();
		this.ptsdepart = ptsdepart;
		this.ptsfin = ptsfin;
		this.nbreplace = nbreplace;
	}
	public Trajet() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public String toString() {
		return "Trajet [idtrajet=" + idtrajet + ", ldate=" + ldate + ", lheure=" + lheure + ", ptsdepart=" + ptsdepart
				+ ", ptsfin=" + ptsfin + ", nbreplace=" + nbreplace + ", passagers=" + passagers + ", conducteur="
				+ conducteur + "]";
	}
	public List<Passager> getPassager() {
	    return passagers;
	}
	public void addpassager(Passager passager) {
		if (this.getNbreplace()!=0) {
			if (this.passagers == null) {
		        passagers = new ArrayList<>();
		    }
			this.setNbreplace(this.getNbreplace()-1);
        passagers.add(passager);
        }
	}
	public Conducteur getConducteur() {
		return conducteur;
	}
	public void setConducteur(Conducteur conducteur) {
		this.conducteur = conducteur;
	}
	
}
