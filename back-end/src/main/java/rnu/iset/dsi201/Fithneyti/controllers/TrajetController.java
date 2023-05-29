package rnu.iset.dsi201.Fithneyti.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import rnu.iset.dsi201.Fithneyti.entities.Conducteur;
import rnu.iset.dsi201.Fithneyti.entities.Passager;
import rnu.iset.dsi201.Fithneyti.entities.Trajet;
import rnu.iset.dsi201.Fithneyti.services.ConducteurService;
import rnu.iset.dsi201.Fithneyti.services.PassagerService;
import rnu.iset.dsi201.Fithneyti.services.TrajetService;


@RestController
@CrossOrigin(origins="http://localhost:4200")
@RequestMapping("trajet")
public class TrajetController {

	private final TrajetService service;
	private final ConducteurService CService;
	private final PassagerService PService;
	@Autowired
	public TrajetController(TrajetService TrajetServ,ConducteurService ConducteurServ, PassagerService Pservice ) {
		super();
		this.service = TrajetServ;
		this.CService = ConducteurServ;
		this.PService = Pservice;
	}

	@GetMapping()
	List<Trajet> all() {
		return service.getAllTrajets();
	}
	
	@GetMapping("/{id}")
	public Trajet getUser(@PathVariable int id) {
		return service.getID(id);
	}
	
	@DeleteMapping("/{id}")
	public void deleteUser(@PathVariable int id) {
		service.Delete(id);
	}
	
	@PostMapping()
	public void addTrajet(@RequestBody Trajet trajet,@RequestParam("id") int userId) {
		Trajet Ctrajet = new Trajet(trajet.getPtsdepart(),trajet.getPtsfin(),trajet.getNbreplace());
		Conducteur user = CService.getID(userId);
		Ctrajet.setConducteur(CService.getID(userId));
		CService.Trajetadd(userId, Ctrajet);
		CService.Update(userId, user);
	}
	
	@PutMapping("/{id}")
	public Optional<Trajet> Upadate(@PathVariable int id, @RequestParam int Passager_id) {
	    Passager Opassager = PService.getOID(id).orElse(null);
	    if (Opassager != null) {
	        return service.getOID(id).map(Trajet -> {
	            Trajet.setNbreplace(Trajet.getNbreplace() - 1);
	            Trajet.addpassager(Opassager);
	            Opassager.setTrajet(Trajet);
	            return service.Update(id, Trajet);
	        });
	    } else {
	        return null;
	    }
	}

}
