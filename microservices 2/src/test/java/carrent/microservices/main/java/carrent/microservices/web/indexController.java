package carrent.microservices.web;


import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class indexController {
    @GetMapping("/index")
    public String menu() {
        return "index";
    }


}
