package lt.techin.travel_agency.model;

import jakarta.persistence.*;
import org.springframework.security.core.GrantedAuthority;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "roles")
public class Role implements GrantedAuthority {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;  // ✅ Changed from `byte` to `Long`

  @Column(unique = true, nullable = false)
  private String name; // Example: "ROLE_USER", "ROLE_ADMIN"

  @ManyToMany(fetch = FetchType.EAGER, mappedBy = "roles")
  private List<User> users = new ArrayList<>();

  public Role() {}

  public Long getId() {  // ✅ Changed return type to Long
    return id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public List<User> getUsers() {
    return users;
  }

  public void setUsers(List<User> users) {
    this.users = users;
  }

  @Override
  public String getAuthority() {
    return name;  // ✅ Spring Security will recognize this role
  }
}
