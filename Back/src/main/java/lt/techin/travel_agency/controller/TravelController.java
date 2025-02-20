package lt.techin.travel_agency.controller;

import jakarta.validation.Valid;
import lt.techin.travel_agency.dto.travel.TravelMapper;
import lt.techin.travel_agency.dto.travel.TravelRequestDTO;
import lt.techin.travel_agency.dto.travel.TravelResponseDTO;
import lt.techin.travel_agency.model.Travel;
import lt.techin.travel_agency.service.TravelService;
import lt.techin.travel_agency.util.WebUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;

@RestController
@RequestMapping("/api/travels")
public class TravelController {

  private final TravelService travelService;

  @Autowired
  public TravelController(TravelService travelService) {
    this.travelService = travelService;
  }

  @PostMapping("/add")
  @PreAuthorize("hasAuthority('SCOPE_ROLE_ADMIN')")
  public ResponseEntity<TravelResponseDTO> createTravel(@Valid @RequestBody TravelRequestDTO dto) {

    Travel travel = travelService.createTravel(dto);
    TravelResponseDTO travelResponseDTO = TravelMapper.toDTO(travel);
    URI location = WebUtil.createLocation("/{id}", travel.getId());

    return ResponseEntity.created(location).body(travelResponseDTO);
  }


}
