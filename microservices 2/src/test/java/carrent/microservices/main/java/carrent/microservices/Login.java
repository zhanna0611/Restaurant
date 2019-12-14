package carrent.microservices;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import lombok.Data;
import org.springframework.security.crypto.password.PasswordEncoder;

import static org.apache.tomcat.jni.SSL.setPassword;

@Data
@Entity
@Table(name = "userName")
public class Login implements Serializable {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    @NotEmpty(message="Login is required")
    private String username;

    @NotEmpty(message="Password is required")
    private String password;

    @NotEmpty(message="Name is required")
    private String name;

    @NotEmpty(message="Role is required")
    private String role="USER";
    private String ROLE_PREFIX = "ROLE_";

    public void toEditTimetable(PasswordEncoder passwordEncoder) {
        setPassword(passwordEncoder.encode(password));
    }

    public Object getUsername() {
        return username;
    }
}