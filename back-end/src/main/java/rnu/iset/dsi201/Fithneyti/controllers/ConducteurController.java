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
import org.springframework.web.bind.annotation.RestController;

import rnu.iset.dsi201.Fithneyti.entities.Conducteur;
import rnu.iset.dsi201.Fithneyti.services.ConducteurService;

@RestController
@CrossOrigin(origins="http://localhost:4200")
@RequestMapping("conducteur")
public class ConducteurController {

		@Autowired
		private final ConducteurService service;

		public ConducteurController(ConducteurService UserServ) {
			super();
			this.service = UserServ;
		}

		@GetMapping()
		List<Conducteur> all() {
			return service.getAllConducteurs();
		}
		
		@GetMapping("/{id}")
		public Conducteur getUser(@PathVariable int id) {
			return service.getID(id);
		}
		@PostMapping()
		public Conducteur Add(@RequestBody Conducteur NewU) {
			return service.AddConducteur(NewU);
		}
		@DeleteMapping("/{id}")
		public void deleteUser(@PathVariable int id) {
			service.Delete(id);
		}

		@PutMapping("/{id}")
	    public Optional<Conducteur> Upadate(@PathVariable int id,@RequestBody Conducteur NewU)
	    {
	        return service.getOID(id).map(
	                Conducteur->{
	                	Conducteur.setEmail(NewU.getEmail());
	                    Conducteur.setNom(NewU.getNom());
	                    Conducteur.setPrenom(NewU.getPrenom());
	        			Conducteur.setNumerotlf(NewU.getNumerotlf());
	                    
	                    return service.Update(id,Conducteur)    ;
	                    });
	    }
}
