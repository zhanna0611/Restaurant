package carrent.microservices.web;

import carrent.microservices.Information;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class addUserController {
    @GetMapping("/add-user")
    public String menu(Model model) {
        model.addAttribute("info", new Information());
        return "add-user";
    }
}
