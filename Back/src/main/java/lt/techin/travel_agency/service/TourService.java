package lt.techin.travel_agency.service;

import lt.techin.travel_agency.dto.travel.TourRequestDTO;
import lt.techin.travel_agency.dto.travel.TourResponseDTO;
import lt.techin.travel_agency.model.Tour;

import lt.techin.travel_agency.model.TourAvailableDates;
import lt.techin.travel_agency.model.TourCategory;
import lt.techin.travel_agency.repository.TourRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TourService {
    private final TourRepository tourRepository;

    public TourService(TourRepository tourRepository) {
        this.tourRepository = tourRepository;
    }

    @Transactional(readOnly = true)
    public List<TourResponseDTO> getAllTours() {
        return tourRepository.findAll().stream()
                .map(this::convertToDTO)
                .toList();
    }

    @Transactional(readOnly = true)
    public List<TourResponseDTO> getToursByCategory(TourCategory category) {
        return tourRepository.findByCategory(category).stream()
                .map(this::convertToDTO)
                .toList();
    }

    @Transactional(readOnly = true)
    public List<TourResponseDTO> getToursByMaxPrice(BigDecimal maxPrice) {
        return tourRepository.findByPriceLessThanEqual(maxPrice).stream()
                .map(this::convertToDTO)
                .toList();
    }

    @Transactional(readOnly = true)
    public List<TourResponseDTO> searchToursByTitle(String title) {
        return tourRepository.findByTitleContainingIgnoreCase(title).stream()
                .map(this::convertToDTO)
                .toList();
    }

    @PostMapping
    public ResponseEntity<Tour> addTour(@RequestBody Tour tour) {
        Tour savedTour = tourRepository.save(tour);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedTour);
    }

    @Transactional
    public TourResponseDTO createTour(Tour tour) {
        Tour savedTour = tourRepository.save(tour);
        return convertToDTO(savedTour);
    }
    @Transactional
    public void deleteTour(Long id) {
        if (!tourRepository.existsById(id)) {
            throw new RuntimeException("Tour with ID " + id + " does not exist!");
        }
        tourRepository.deleteById(id);
    }

    private TourResponseDTO convertToDTO(Tour tour) {
        return new TourResponseDTO(
                tour.getId(),
                tour.getTitle(),
                tour.getImageUrl(),
                tour.getDuration(),
                tour.getPrice(),
                tour.getCategory() != null ? tour.getCategory().name() : "UNKNOWN",
                tour.getAvailableDates() != null && !tour.getAvailableDates().isEmpty()
                        ? tour.getAvailableDates().stream()
                        .map(TourAvailableDates::getAvailableDate)
                        .collect(Collectors.toList())
                        : Collections.emptyList()
        );
    }

}
