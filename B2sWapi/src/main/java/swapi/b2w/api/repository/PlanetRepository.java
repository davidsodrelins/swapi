package swapi.b2w.api.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import swapi.b2w.api.model.Planet;

public interface PlanetRepository extends MongoRepository<Planet, String>{
	
	@Query("{'name':?0}")
	Optional<Planet> findByName(String name);

}
