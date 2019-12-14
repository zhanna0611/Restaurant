package carrent.microservices;
import org.springframework.security.crypto.password.PasswordEncoder;
import lombok.Data;
import carrent.microservices.User;
@Data
public class RegistrationForm {
    private String username;
    private String password;
    private String fullname;
    private String role;
    private String phoneNumber;

}
