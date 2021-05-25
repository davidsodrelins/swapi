package swapi.b2w.api.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import swapi.b2w.api.model.Planet;
import swapi.b2w.api.service.PlanetService;

@RestController
@RequestMapping("api/planet")
public class PlanetController {
	
	private final PlanetService planetService;
	
	public PlanetController(PlanetService planetService) {
		this.planetService = planetService;
	}
	
	@SuppressWarnings("rawtypes")
	@PostMapping
	public ResponseEntity addPlanet(@RequestBody Planet planet) {
		planetService.addPlanet(planet);
		return ResponseEntity.status(HttpStatus.CREATED).build();
	}
	
	@GetMapping
	public ResponseEntity<List<Planet>> getAllPlanets() {
		return ResponseEntity.ok(planetService.getAllPlanets());
	}
	
	@GetMapping("/name/{name}")
	public ResponseEntity<Planet> getPlanetByName(@PathVariable String name) {
		return ResponseEntity.ok(planetService.getPlanetByName(name));
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Planet> getPlanetById(@PathVariable String id) {
		return ResponseEntity.ok(planetService.getPlanetById(id));
	}
	
	@SuppressWarnings("rawtypes")
	@DeleteMapping("/{id}")
	public ResponseEntity deletePlanet(@PathVariable String id) {
		planetService.deletePlanet(id);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}
	
}

