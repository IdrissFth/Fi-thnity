package rnu.iset.dsi201.Fithneyti.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import rnu.iset.dsi201.Fithneyti.entities.Passager;
import rnu.iset.dsi201.Fithneyti.entities.Trajet;
import rnu.iset.dsi201.Fithneyti.repositories.PassagerRepository;


@Service
public class PassagerService {

	@Autowired
	private PassagerRepository PassagerRepo;
	
	public List<Passager> getAllPassagers() 
	{
		 return PassagerRepo.findAll();
	}
	public Passager AddPassager(Passager P)
	{
		return PassagerRepo.save(P);
	}
	public void Delete(int id) {
		PassagerRepo.deleteById(id);
	}
	public Passager getID(int Id) {
		return PassagerRepo.findById(Id).orElse(null);
	}
	public Optional<Passager> getOID(int Id) {
		return PassagerRepo.findById(Id);
	}
	public Passager Trajetadd(int Id,Trajet Trajet) {
		Passager optionalU = PassagerRepo.findById(Id).orElse(null);
		optionalU.setTrajet(Trajet);
		return PassagerRepo.save(optionalU);
	}
	
	public Passager Update(int id,Passager NewP){
		Passager OptionalPassager = PassagerRepo.findById(id).orElse(null);
		System.out.print("Test4");
		if (OptionalPassager != null) {
			System.out.print("Test**");
			OptionalPassager.setEmail(NewP.getEmail());
			OptionalPassager.setNumerotlf(NewP.getNumerotlf());
			OptionalPassager.setNom(NewP.getNom());
			OptionalPassager.setPrenom(NewP.getPrenom());
			System.out.print("Test****");
			return PassagerRepo.save(OptionalPassager);
		}else {
			return null;
		}
	}
}
