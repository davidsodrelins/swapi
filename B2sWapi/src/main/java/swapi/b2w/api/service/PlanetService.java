package swapi.b2w.api.service;

import java.util.List;

import org.springframework.stereotype.Service;

import swapi.b2w.api.model.Planet;
import swapi.b2w.api.repository.PlanetRepository;

@Service
public class PlanetService {
	
	private final PlanetRepository planetRespository;
	
	public PlanetService(PlanetRepository planetRepository) {
		this.planetRespository = planetRepository;
	}
	
	public void addPlanet(Planet planet) {
		planetRespository.save(planet);
	}
	
	public List<Planet> getAllPlanets() {
		return planetRespository.findAll();
	}
	
	public Planet getPlanetByName(String name) {
		return planetRespository.findByName(name)
				.orElseThrow(() -> new RuntimeException(
						String.format("Não foi encontrado o planeta %s", name)));
	}
	
	public Planet getPlanetById(String id) {
		return planetRespository.findById(id)
				.orElseThrow(() -> new RuntimeException(
						String.format("Não existe planeta com id %s", id)));
	}

	public void deletePlanet(String id){
		planetRespository.deleteById(id);
	}	

}
