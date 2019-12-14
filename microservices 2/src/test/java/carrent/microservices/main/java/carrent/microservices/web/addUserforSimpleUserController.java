package carrent.microservices.web;


import carrent.microservices.Information;
import carrent.microservices.repository_.InfoRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
@Controller
public class addUserforSimpleUserController {
    private InfoRepository infoRepo;
    public addUserforSimpleUserController(InfoRepository infoRepo) {
        this.infoRepo = infoRepo;
    }
    @GetMapping("/addUserforSimpleUser")
    public String menu() {

        return "addUserforSimpleUser";
    }
    @PostMapping("/adduser2")
    public String addUser(@Valid Information information, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "addUserforSimpleUser";
        }

        infoRepo.save(information);
        model.addAttribute("info", infoRepo.findAll());
        return "history";
    }
     }