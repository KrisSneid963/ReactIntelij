package lt.techin.travel_agency.repository;

import lt.techin.travel_agency.model.Travel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TravelRepository extends JpaRepository<Travel, Long> {

  boolean existsByName(String name);
}

