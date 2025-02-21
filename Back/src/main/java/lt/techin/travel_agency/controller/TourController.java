package lt.techin.travel_agency.controller;

import lt.techin.travel_agency.dto.travel.TourResponseDTO;
import lt.techin.travel_agency.model.TourCategory;
import lt.techin.travel_agency.service.TourService;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/api/tours")
public class TourController {
    private final TourService tourService;

    public TourController(TourService tourService) {
        this.tourService = tourService;
    }

    @GetMapping
    public List<TourResponseDTO> getAllTours() {
        return tourService.getAllTours();
    }

    // GET tours by category
    @GetMapping("/category/{category}")
    public List<TourResponseDTO> getToursByCategory(@PathVariable TourCategory category) {
        return tourService.getToursByCategory(category);
    }

    // GET tours under a maximum price
    @GetMapping("/price/{maxPrice}")
    public List<TourResponseDTO> getToursByMaxPrice(@PathVariable BigDecimal maxPrice) {
        return tourService.getToursByMaxPrice(maxPrice);
    }

    // GET tours by keyword in title
    @GetMapping("/search")
    public List<TourResponseDTO> searchToursByTitle(@RequestParam String title) {
        return tourService.searchToursByTitle(title);
    }
}
