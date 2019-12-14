package carrent.microservices.web;

import javax.validation.Valid;

import carrent.microservices.data.car1Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
//end::baseClass[]
//tag::baseClass[]

import lombok.extern.slf4j.Slf4j;
import carrent.microservices.*;

@Slf4j
@Controller
@RequestMapping("/")
public class OrderController {
    private car1Client Car1Client;


    @Autowired
    public OrderController(
            car1Client Car1Client) {
        this.Car1Client = Car1Client;
    }

    @GetMapping("/order")
    public String orderForm(Model model) {
        model.addAttribute("Order", new Order());
        return "orderForm";
    }
    @PostMapping("/savePayment")
    public String processOrder(@Valid @ModelAttribute("Order") Order order, Errors errors, Model model) {
        if (errors.hasErrors()) {
            return "orderForm";
        }
        Car1Client.savePayment(order);
        return "redirect:services";
    }


//tag::baseClass[]

}
//end::baseClass[]
