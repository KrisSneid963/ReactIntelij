package lt.techin.travel_agency.service;

import lt.techin.travel_agency.dto.travel.TravelMapper;
import lt.techin.travel_agency.dto.travel.TravelRequestDTO;
import lt.techin.travel_agency.model.Travel;
import lt.techin.travel_agency.model.TravelCategory;
import lt.techin.travel_agency.repository.TravelRepository;
import lt.techin.travel_agency.validation.exception.TravelExistsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TravelService {

  private final TravelRepository travelRepository;

  @Autowired
  public TravelService(TravelRepository travelRepository) {
    this.travelRepository = travelRepository;
  }

  public Travel createTravel(TravelRequestDTO dto) {

    if (travelRepository.existsByName(dto.name())) {
      throw new TravelExistsException("Travel '" + dto.name() + "' already exists");
    }

    Travel newTravel = TravelMapper.ToEntity(dto);

    if (dto.travelCategory() == null) {
      newTravel.setTravelCategory(TravelCategory.SINGLE);
    }

    return travelRepository.save(newTravel);
  }
}
