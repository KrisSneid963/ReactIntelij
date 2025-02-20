package lt.techin.travel_agency.model;


import com.vladmihalcea.hibernate.type.json.JsonType;
import jakarta.persistence.*;
import org.hibernate.annotations.Type;

import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "travels")
public class Travel {

  @Id
  @GeneratedValue
  private long id;

  private String name;
  private String imageUrl;
  @Column(columnDefinition = "json")
  @Type(JsonType.class)
  private List<String> dates;
  private BigDecimal price;
  private double duration;

  @Enumerated(value = EnumType.STRING)
  private TravelCategory travelCategory;

  public Travel() {

  }

  public long getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getImageUrl() {
    return imageUrl;
  }

  public void setImageUrl(String imageUrl) {
    this.imageUrl = imageUrl;
  }

  public List<String> getDates() {
    return dates;
  }

  public void setDates(List<String> dates) {
    this.dates = dates;
  }

  public BigDecimal getPrice() {
    return price;
  }

  public void setPrice(BigDecimal price) {
    this.price = price;
  }

  public double getDuration() {
    return duration;
  }

  public void setDuration(double duration) {
    this.duration = duration;
  }

  public TravelCategory getTravelCategory() {
    return travelCategory;
  }

  public void setTravelCategory(TravelCategory travelCategory) {
    this.travelCategory = travelCategory;
  }
}
