package carrent.microservices.web;
import carrent.microservices.Authorization;
import carrent.microservices.Information;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import lombok.extern.slf4j.Slf4j;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@Slf4j
@Controller


public class LoginController {
    @GetMapping("/login")
    public String showDesignForm(Model model) {
        model.addAttribute("Authorization", new Authorization());
        return "login";
    }

    @PostMapping("/login")
    public String processAuthorization(@Valid @ModelAttribute("Authorization") Authorization Authorization, Errors errors, Model model) {
        if (errors.hasErrors()) {
            System.out.println("has error");
            return "login";
        }
        System.out.println("success");
        return "redirect:/index";
    }
}
