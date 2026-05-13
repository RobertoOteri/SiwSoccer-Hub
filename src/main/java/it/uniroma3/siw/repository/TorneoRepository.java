package it.uniroma3.siw.repository;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import it.uniroma3.siw.model.*;

public interface TorneoRepository extends CrudRepository<Torneo, Long>{
	
	@Query("SELECT s FROM Squadra s WHERE s.id NOT IN " +"(SELECT sq.id FROM Torneo t JOIN t.squadre sq WHERE t.id = :id)")
    List<Squadra> findSquadreNonIscritteATorneo(@Param("id") Long id);

}
