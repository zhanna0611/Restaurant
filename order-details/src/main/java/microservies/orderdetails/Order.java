package microservies.orderdetails;
import lombok.Getter;
import lombok.Setter;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import javax.persistence.*;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.jdbc.core.JdbcTemplate;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import org.springframework.boot.autoconfigure.domain.EntityScan;
@Data
@Entity
@Table(name="\"booking\"")
@Getter
@Setter
public class Order {
    public Order() {
    }

    public Order(String name, @NotBlank(message = "Email is required") String email, @NotBlank(message = "Phone is required") String phone, @Pattern(regexp = "^(0[0-9]|1[0-9])([\\/])([0-9][0-9])$",
            message = "Must be formatted MM/YY") String date, @NotBlank(message = "Person is required") String person,int userId) {
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.date = date;
        this.person = person;
        this.userId = userId;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;
    @NotBlank(message="Email is required")
    private String email;
    @NotBlank(message="Phone is required")
    private String phone;
    @Pattern(regexp = "^(0[0-9]|1[0-9])([\\/])([0-9][0-9])$",
            message = "Must be formatted MM/YY")
    private String date;

    @NotBlank(message="Person number is required")
    private String person;
    private int userId;
//    @PrePersist
//    void date() {
//        this.date = new Date();
//    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
}
