package lt.techin.travel_agency.dto.travel;

import jakarta.validation.constraints.*;
import lt.techin.travel_agency.model.TravelCategory;
import org.hibernate.validator.constraints.Range;

import java.math.BigDecimal;
import java.util.List;

public record TravelRequestDTO(
        @NotNull(message = "Name cannot be null")
        @Size(min = 2, max = 200, message = "Name must be from 2 to 200 characters")
        @Pattern(
                regexp = "^[a-zA-Z][a-zA-Z0-9._ -]{1,98}$",
                message = "Name must start and end with a letter and can contain" +
                        " dots, underscores, and hyphens"
        )
        String name,
        @NotNull(message = "ImageUrl cannot be null")
        @Pattern(
                regexp = "^https?:\\/\\/(?:[a-zA-Z0-9\\-._~!$&'()*+,;=:@\\/]|%[0-9A-F]{2})+$",
                message = "Must be a valid HTTP/HTTPS URL"
        )
        String imageUrl,
        @NotNull(message = "Date cannot be null")
        @Size(min = 1, max = 20, message = "Must add at least 1 date up to 20")
        List<String> dates,
        @NotNull(message = "Price cannot be null")
        @Positive(message = "Must be positive")
        @DecimalMax(value = "9999",message = "Max price is 9999 euros")
        BigDecimal price,
        @Positive(message = "Must be positive")
        @Max(value = 24)
        double duration,
        TravelCategory travelCategory
) {

}
