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

import rnu.iset.dsi201.Fithneyti.entities.Passager;
import rnu.iset.dsi201.Fithneyti.services.PassagerService;
import rnu.iset.dsi201.Fithneyti.services.TrajetService;


@RestController
@CrossOrigin(origins="http://localhost:4200")
@RequestMapping("passager")
public class PassagerController {
	@Autowired
	private final PassagerService service;
	@Autowired
	private final TrajetService TService;
	
	public PassagerController(PassagerService UserServ,TrajetService Tservice) {
		super();
		this.service = UserServ;
		this.TService = Tservice;
	}
	
	@GetMapping()
	List<Passager> all(){
		return service.getAllPassagers();
	}
	@GetMapping("/{id}")
	public Passager getUser(@PathVariable int id) {
		return service.getID(id);
	}
	@PostMapping()
	public Passager Add(@RequestBody Passager NewU) {
		return service.AddPassager(NewU);
	}
	@DeleteMapping("/{id}")
	public void deleteUser(@PathVariable int id) {
		service.Delete(id);
	}
	
	@PutMapping("/{id}")
    public Optional<Passager> Upadate(@PathVariable int id,@RequestBody Passager NewU)
    {
        return service.getOID(id).map(
                Passager->{
                	Passager.setEmail(NewU.getEmail());
                    Passager.setNom(NewU.getNom());
                    Passager.setPrenom(NewU.getPrenom());
        			Passager.setNumerotlf(NewU.getNumerotlf());
                    
                    return service.Update(id,Passager);
                    });
    }

	@PutMapping("/{id}/trajet")
    public Optional<Passager> UpdateTrajet(@PathVariable int id,@RequestParam("id") int Trajet_id)
    {
		return service.getOID(id).map(
				Passager->{
				Passager.setTrajet(TService.getID(Trajet_id));
				System.out.print("Test");
				Passager.setConducteur(TService.getID(Trajet_id).getConducteur());
				System.out.print("Test1");
				TService.getID(Trajet_id).addpassager(Passager);
				System.out.print("Test2");
				TService.Update(Trajet_id, TService.getID(Trajet_id));
				System.out.print("Test3");
				return service.Update(id,Passager)    ;
	 });
	}
}
