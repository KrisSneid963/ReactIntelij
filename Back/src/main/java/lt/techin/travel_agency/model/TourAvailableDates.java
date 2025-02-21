package lt.techin.travel_agency.model;

import jakarta.persistence.*;
import lombok.Getter;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

@Getter
@Entity // ✅ Add this annotation to make it a proper JPA Entity
@Table(name = "tour_available_dates") // ✅ Ensure correct table mapping
public class TourAvailableDates implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // ✅ Ensure primary key
    private Long id;

    @ManyToOne // ✅ Properly map the relationship to the Tour entity
    @JoinColumn(name = "tour_id", nullable = false)
    private Tour tour;

    @Column(nullable = false)
    private LocalDate availableDate;

    public TourAvailableDates() {}

    public TourAvailableDates(Tour tour, LocalDate availableDate) {
        this.tour = tour;
        this.availableDate = availableDate;
    }

    public void setTour(Tour tour) {
        this.tour = tour;
    }

    public void setAvailableDate(LocalDate availableDate) {
        this.availableDate = availableDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TourAvailableDates that = (TourAvailableDates) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(tour, that.tour) &&
                Objects.equals(availableDate, that.availableDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, tour, availableDate);
    }
}
