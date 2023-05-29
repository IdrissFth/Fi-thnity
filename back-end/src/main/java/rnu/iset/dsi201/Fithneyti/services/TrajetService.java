package rnu.iset.dsi201.Fithneyti.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import rnu.iset.dsi201.Fithneyti.entities.Passager;
import rnu.iset.dsi201.Fithneyti.entities.Trajet;
import rnu.iset.dsi201.Fithneyti.repositories.TrajetRepository;

@Service
public class TrajetService {
	@Autowired
	private TrajetRepository TrajetRepo;
	
	public List<Trajet> getAllTrajets() 
	{
		 return TrajetRepo.findAll();
	}
	
	public Trajet AddTrajet(Trajet Trajet) {
		return TrajetRepo.save(Trajet);
	}
	public Trajet getID(int id) {
		return TrajetRepo.getById(id);
	}
	public void Delete(int id) {
		TrajetRepo.deleteById(id);
	}
	public Optional<Trajet> getOID(int id){
		return TrajetRepo.findById(id);
	}
	public Trajet UpdatePassager(int id, Passager passager){
		Trajet OptionalTrajet = TrajetRepo.findById(id).orElse(null);
		System.out.print(OptionalTrajet);
		if(OptionalTrajet != null) {
			OptionalTrajet.setNbreplace(OptionalTrajet.getNbreplace()-1);
			OptionalTrajet.addpassager(passager);
			System.out.print(OptionalTrajet.getNbreplace());
			return TrajetRepo.save(OptionalTrajet);
		}else {
			return null;
		}
	}
	public Trajet Update(int id,Trajet NewM){
		Trajet OptionalTrajet = TrajetRepo.findById(id).orElse(null);
		if(OptionalTrajet != null) {
			OptionalTrajet.setLdate(OptionalTrajet.getLdate());
			OptionalTrajet.setLheure(NewM.getLheure());
			OptionalTrajet.setPtsdepart(NewM.getPtsdepart());
			OptionalTrajet.setPtsfin(NewM.getPtsfin());
			OptionalTrajet.setNbreplace(NewM.getNbreplace());
			return TrajetRepo.save(OptionalTrajet);
		}else {
			return null;
		}
	}
}
