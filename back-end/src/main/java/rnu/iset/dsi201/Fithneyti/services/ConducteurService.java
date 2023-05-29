package rnu.iset.dsi201.Fithneyti.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import rnu.iset.dsi201.Fithneyti.entities.Conducteur;
import rnu.iset.dsi201.Fithneyti.entities.Trajet;
import rnu.iset.dsi201.Fithneyti.repositories.ConducteurRepository;



@Service
public class ConducteurService {
	@Autowired
	private ConducteurRepository ConducteurRepo;
	
	public List<Conducteur> getAllConducteurs() 
	{
		 return ConducteurRepo.findAll();
	}
	public Conducteur AddConducteur(Conducteur P)
	{
		return ConducteurRepo.save(P);
	}
	public void Delete(int id) {
		ConducteurRepo.deleteById(id);
	}
	public Conducteur getID(int Id) {
		return ConducteurRepo.findById(Id).orElse(null);
	}
	public Optional<Conducteur> getOID(int Id) {
		return ConducteurRepo.findById(Id);
	}
	public Conducteur Trajetadd(int Id,Trajet trajet) {
		Conducteur optionalU = ConducteurRepo.findById(Id).orElse(null);
		optionalU.addTrajet(trajet);
		return ConducteurRepo.save(optionalU);
	}
	
	public Conducteur Update(int id,Conducteur NewP){
		Conducteur OptionalConducteur = ConducteurRepo.findById(id).orElse(null);
		if (OptionalConducteur != null) {
			OptionalConducteur.setEmail(NewP.getEmail());
			OptionalConducteur.setNumerotlf(NewP.getNumerotlf());
			OptionalConducteur.setNom(NewP.getNom());
			OptionalConducteur.setPrenom(NewP.getPrenom());
			return ConducteurRepo.save(OptionalConducteur);
		}else {
			return null;
		}
	}
}
