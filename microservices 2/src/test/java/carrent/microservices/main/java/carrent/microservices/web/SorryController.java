package carrent.microservices.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class SorryController {
    @GetMapping("/sorry")
    public String menu() {

        return "sorry";
    }
}
