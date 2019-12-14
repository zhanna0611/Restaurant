package carrent.microservices.web;


import carrent.microservices.Information;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.stereotype.Controller;

@Controller
public class updateUserController {
    @GetMapping("/update-user")
    public String menu(Model model) {
        model.addAttribute("info", new Information());
        return "update-order";
    }
}
