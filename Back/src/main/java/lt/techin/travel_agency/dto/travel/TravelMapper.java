package lt.techin.travel_agency.dto.travel;

import lt.techin.travel_agency.model.Travel;

public class TravelMapper {

  public static Travel ToEntity(TravelRequestDTO dto) {
    Travel travel = new Travel();
    travel.setName(dto.name());
    travel.setDates(dto.dates());
    travel.setImageUrl(dto.imageUrl());
    travel.setDuration(dto.duration());
    travel.setPrice(dto.price());
    travel.setTravelCategory(dto.travelCategory());
    return travel;
  }

  public static TravelResponseDTO toDTO(Travel travel) {
    return new TravelResponseDTO(
            travel.getId(),
            travel.getName(),
            travel.getImageUrl(),
            travel.getDates(),
            travel.getPrice(),
            travel.getDuration(),
            travel.getTravelCategory()
    );
  }
}
