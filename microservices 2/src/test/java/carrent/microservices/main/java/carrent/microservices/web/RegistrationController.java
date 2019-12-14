package carrent.microservices.web;

import carrent.microservices.RegistrationForm;
import carrent.microservices.data.car1Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RequestMapping("/register")
public class RegistrationController {
    private car1Client Car1Client;
//    private UserRepository userRepo;
    private PasswordEncoder passwordEncoder;
    @Autowired
    public RegistrationController(car1Client Car1Client,PasswordEncoder passwordEncoder) {
        this.Car1Client = Car1Client;
this.passwordEncoder=passwordEncoder;
    }
    @GetMapping
    public String registerForm() {

        return "registration";
    }
    @PostMapping
    public String processRegistration(RegistrationForm form, Model model) {
//        Car1Client.saveUser(form.toUser(passwordEncoder));
        Car1Client.saveUser(form);
        return "redirect:/login";
    }
}
