package lt.techin.travel_agency.dto.travel;

import lt.techin.travel_agency.model.TravelCategory;

import java.math.BigDecimal;
import java.util.List;

public record TravelResponseDTO(
        long id,
        String name,
        String imageUrl,
        List<String> dates,
        BigDecimal price,
        double duration,
        TravelCategory travelCategory
) {
}
