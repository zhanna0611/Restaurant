package carrent.microservices;
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

import static javax.persistence.GenerationType.*;

@Data
@Entity
@Table(name="\"booking\"")
@Getter
@Setter
public class Information {
    public Information() {
    }

    public Information(Date createdAt, @NotBlank(message = "Location is required") String location, @Pattern(regexp = "^(0[0-9]|1[0-9])([\\/])([0-9][0-9])$",
            message = "Must be formatted MM/YY") String pickupDate, @Pattern(regexp = "^(0[0-9]|1[0-9])([\\/])([0-9][0-9])$",
            message = "Must be formatted MM/YY") String returnDate, @NotBlank(message = "Car Type is required") String carType, int userId) {
        this.createdAt = createdAt;
        this.location = location;
        this.pickupDate = pickupDate;
        this.returnDate = returnDate;
        this.carType = carType;
        this.userId = userId;
    }

    @Id
    @GeneratedValue(strategy = AUTO)
    private int id;
    private Date createdAt;
    @NotBlank(message="Location is required")
    private String location;
    @Pattern(regexp="^(0[0-9]|1[0-9])([\\/])([0-9][0-9])$",
            message="Must be formatted MM/YY")
    private String pickupDate;
    @Pattern(regexp="^(0[0-9]|1[0-9])([\\/])([0-9][0-9])$",
            message="Must be formatted MM/YY")
    private String returnDate;
    @NotBlank(message="Car Type is required")
    protected String carType;
    private int userId;
    @PrePersist
    void createdAt() {
        this.createdAt = new Date();
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
}