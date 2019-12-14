package carrent.microservices;
import javax.persistence.*;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Pattern;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.CreditCardNumber;
import org.hibernate.validator.constraints.NotBlank;
import lombok.Data;
import java.util.Date;

@Data
@Entity
@Getter
@Setter
@Table(name="\"payment\"")
public class Order {
    public Order() {
    }

    public Order(@NotBlank(message = "Name is required") String ccName, @NotBlank(message = "City is required") String ccValidDate, @NotBlank(message = "ccNumber is required") String ccCode, @Pattern(regexp = "^(0[1-9]|1[0-2])([\\/])([1-9][0-9])$",
            message = "Must be formatted MM/YY") String orderId) {
        this.ccName = ccName;
        this.ccValidDate = ccValidDate;
        this.ccCode = ccCode;
        this.orderId = orderId;
    }
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @NotBlank(message="Name is required")
    private String ccName;
    @NotBlank(message="City is required")
    private String ccValidDate;
    @NotBlank(message="ccNumber is required")
    private String ccCode;
    @Pattern(regexp="^(0[1-9]|1[0-2])([\\/])([1-9][0-9])$",
            message="Must be formatted MM/YY")
    private String orderId;

}
