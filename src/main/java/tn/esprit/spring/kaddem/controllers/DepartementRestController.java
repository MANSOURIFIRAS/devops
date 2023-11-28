package tn.esprit.spring.kaddem.controllers;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.spring.kaddem.entities.Departement;
import tn.esprit.spring.kaddem.services.IDepartementService;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/departement")
public class DepartementRestController {
	IDepartementService departementService;

	// http://localhost:8082/departement/retrieve-all-departements
	@GetMapping("/retrieve-all-departements")
	public List<Departement> getDepartements() {
		List<Departement> listDepartements = departementService.retrieveAllDepartements();
		return listDepartements;
	}

	// http://localhost:8082/departement/retrieve-departement/{id}
	@GetMapping("/retrieve-departement/{departement-id}")
	public Departement retrieveDepartement(@PathVariable("departement-id") Integer departementId) {
		return departementService.retrieveDepartement(departementId);
	}

	// http://localhost:8082/departement/add-departement
	@PostMapping("/add-departement")
	public Departement addDepartement(@RequestBody Departement d) {
		Departement departement = departementService.addDepartement(d);
		return departement;
	}

	// http://localhost:8082/departement/remove-departement/{id}
	@DeleteMapping("/remove-departement/{departement-id}")
	public void removeDepartement(@PathVariable("departement-id") Integer departementId) {
		departementService.deleteDepartement(departementId);
	}

	// http://localhost:8082/departement/update-departement
	@PutMapping("/update-departement")
	public Departement updateDepartement(@RequestBody Departement e) {
		Departement departement = departementService.updateDepartement(e);
		return departement;
	}
}
