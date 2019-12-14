package carrent.microservices.web;
import javax.validation.Valid;

import carrent.microservices.*;
import carrent.microservices.data.car1Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
@Controller

@RequestMapping("/")

public class HomeController {
    //        this.infoRepo = infoRepo;
//    }
    private car1Client Car1Client;


    @Autowired
    public HomeController(
            car1Client Car1Client) {
        this.Car1Client = Car1Client;
    }
//        @GetMapping("/showHistory")
//    public List<Information> showForm() {
//        return Car1Client.getAllHistory();
//    }

    @GetMapping("/history")
    public String getHistory2(@Valid OrderHistory history, BindingResult result, Model model) {
        model.addAttribute("history", Car1Client.getAllHistory());
        return "history";
}

    @GetMapping("/payment")
    public String pay() {

        return "payment";
    }


    @GetMapping("/history/{userId}")
    public String getHistory(@Valid OrderHistory history, BindingResult result, Model model) {

        model.addAttribute("history", Car1Client.getAllHistory());
        return "history";
//        infoRepo.save(information);
    }

//    @PostMapping("/history")
//    public void getHistory(@Valid OrderHistory history, BindingResult result, Model model) {
//
//        model.addAttribute("history", Car1Client.getAllHistory());
//        System.out.println(Car1Client.getAllHistory());;
//        infoRepo.save(information);
//    }

    @GetMapping("/bookings")
    public Iterable<Information> getAllBookings() {
        return Car1Client.getAllBookings();
    }
    @GetMapping("/signup")
    public String showSignUpForm(Information information) {
        return "add-user";
    }

    @PostMapping("/adduser")
    public String addUser(@Valid Information information, BindingResult result,Model model) {
        if (result.hasErrors()) {
            return "add-user";
        }
        Car1Client.saveBooking(information);
        model.addAttribute("info", Car1Client.getAllBookings());
        return "index";
//        infoRepo.save(information);
    }

    @GetMapping("/edit/{id}")
    public String showUpdateForm(@PathVariable("id") int id, Model model) {
        Information information =  Car1Client.findById(id);
        model.addAttribute("info", information);
        return "update-user";
    }


    @PostMapping(path="/update/{id}")
    public String updateUser(@PathVariable("id") int id, @Valid Information information,
                             BindingResult result, Model model) {
        if (result.hasErrors()) {
            information.setId(id);
            return "update-user";
        }

        Car1Client.saveBooking(information);
        model.addAttribute("info", Car1Client.getAllBookings());
        return "index";
    }
    @GetMapping("/user/{username}")
    public User getAllUsers(@PathVariable("username") String username) {

        return Car1Client.getUserByUsername(username);
    }
    @GetMapping("/delete/{id}")
    public String deleteUser(@PathVariable("id") int id, Model model) {
        Information information= Car1Client.findById(id);
        Car1Client.deleteById(id);
        model.addAttribute("info", Car1Client.getAllBookings());
        return "index";
    }

    @GetMapping("/")
    public String showDesignForm(Model model) {
        model.addAttribute("info", new Information());
        return "home";
    }
//    @PostMapping
//    public String processDesign(@Valid @ModelAttribute("Information") Information information, Errors errors, Model model) {
//        if (errors.hasErrors()) {
//            return "home";
//        }
//       Car1Client.saveBooking(information);
//        return "redirect:services";
//    }
}

//import javax.validation.Valid;
//
//import carrent.microservices.*;
//import carrent.microservices.data.car1Client;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.validation.BindingResult;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.*;
//import lombok.extern.slf4j.Slf4j;
//
//@Slf4j
//@Controller
//
//@RequestMapping("/")
//
//public class HomeController {
//    //        this.infoRepo = infoRepo;
////    }
//    private car1Client Car1Client;
//
//
//    @Autowired
//    public HomeController(
//            car1Client Car1Client) {
//        this.Car1Client = Car1Client;
//    }
//    @GetMapping("/bookings")
//    public Iterable<Information> getAllBookings() {
//        return Car1Client.getAllBookings();
//    }
//

//
////    @GetMapping("/showHistory")
////    public List<Information> showForm() {
////        return Car1Client.getAllHistory();
////    }
//
//    @PostMapping("/adduser")
//    public String addUser(@Valid Information information, BindingResult result,Model model) {
//        if (result.hasErrors()) {
//            return "add-user";
//        }
//        Car1Client.saveBooking(information);
//        model.addAttribute("info", Car1Client.getAllBookings());
//        return "index";
////        infoRepo.save(information);
//    }
//
//@GetMapping("/history")
//    public String getHistory2(@Valid OrderHistory history, BindingResult result, Model model) {
//
//        model.addAttribute("history", Car1Client.getAllHistory());
//        return "history";
//
//}
////
////    @GetMapping("/payment")
////    public String pay() {
////
////        return "payment";
////    }
//
//
//    @GetMapping("/history/{userId}")
//    public String getHistory(@Valid OrderHistory history, BindingResult result, Model model) {
//
//        model.addAttribute("history", Car1Client.getAllHistory());
//        return "history";
////        infoRepo.save(information);
//    }
//
////    @PostMapping("/history")
////    public void getHistory(@Valid OrderHistory history, BindingResult result, Model model) {
////
//////        model.addAttribute("history", Car1Client.getAllHistory());
////        System.out.println(Car1Client.getAllHistory());;
//////        infoRepo.save(information);
////    }
//
//    @GetMapping("/edit/{id}")
//    public String showUpdateForm(@PathVariable("id") int id, Model model) {
//        Information information =  Car1Client.findById(id);
//        model.addAttribute("info", information);
//        return "update-order";
//    }
//
//    @PostMapping(path="/update/{id}")
//    public String updateUser(@PathVariable("id") int id, @Valid Information information,
//                             BindingResult result, Model model) {
//        if (result.hasErrors()) {
//            information.setId(id);
//            return "update-order";
//        }
//
//        Car1Client.saveBooking(information);
//        model.addAttribute("info", Car1Client.getAllBookings());
//        return "index";
//    }
//    @GetMapping("/user/{username}")
//    public User getAllUsers(@PathVariable("username") String username) {
//
//        return Car1Client.getUserByUsername(username);
//    }
//    @GetMapping("/delete/{id}")
//    public String deleteUser(@PathVariable("id") int id, Model model) {
////        Information information= Car1Client.findById(id);
//        Car1Client.deleteById(id);
//        model.addAttribute("info", Car1Client.getAllBookings());
//        return "index";
//    }
//
//    @GetMapping("/")
//    public String showDesignForm(Model model) {
//        model.addAttribute("info", new Information());
//        return "home";
//    }
////    @PostMapping
////    public String processDesign(@Valid @ModelAttribute("Information") Information information, Errors errors, Model model) {
////        if (errors.hasErrors()) {
////            return "home";
////        }
////       Car1Client.saveBooking(information);
////        return "redirect:services";
////    }
//}
