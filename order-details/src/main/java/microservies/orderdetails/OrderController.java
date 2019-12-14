package microservies.orderdetails;
import javax.validation.Valid;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.*;
import lombok.extern.slf4j.Slf4j;

import java.util.Optional;

@Slf4j
@RestController
@EnableHystrix
@RequestMapping("/")
public class OrderController {

    @Autowired
    private InfoRepository infoRepo;
    @GetMapping("/bookings")
//    @HystrixCommand(fallbackMethod = "fallback_allBookings", commandProperties = {
////            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "1000")
////    })
    public Iterable<Order> getAllBookings() throws InterruptedException {
        return infoRepo.findAll();
    }
//    private String fallback_allBookings() throws InterruptedException {
//        return "Request fails. It takes long time to response";
//    }
    @GetMapping("/bookings/{id}")
    public Optional<Order> getOrderbyID(@PathVariable("id") int id) {

        return infoRepo.findById(id);
    }

    @GetMapping("/booking/{user_id}")
    public Order getOrderbyUserID(@PathVariable("user_id") int userId) {

        return infoRepo.findOrderByUserId(userId);
    }

    @PostMapping("/addOrder")
    public ResponseEntity<?> addOrder(@RequestBody @Valid Order order) {

        infoRepo.save(order);

        return new ResponseEntity<>(HttpStatus.OK);

    }
    @GetMapping(value = {"/edit", "/edit/{id}"})
    public ResponseEntity<?> orderEditForm(@PathVariable (required = false, name = "id") int id) {
        Optional<Order> optionalOrder = infoRepo.findById(id);
        if ( optionalOrder.isPresent() ) {
            return new ResponseEntity<>(infoRepo.findById(id), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }

    }

    @GetMapping("/delete/{id}")
    public void deleteOrder(@PathVariable("id") int id) {
        try {
            infoRepo.deleteById(id);
        } catch (EmptyResultDataAccessException e) {}
    }


//    @PostMapping(path="/update/{id}", consumes="application/json")
//    public Order patchOrder(@PathVariable("id") int id,
//                                  @RequestBody Order patch) {
//        Order information = infoRepo.findById(id).get();
//        if (patch.getLocation() != null) {
//            information.setLocation(patch.getLocation());
//        }
//        if (patch.getPickup_date() != null) {
//            information.setPickup_date(patch.getPickup_date());
//        }
//        if (patch.getReturn_date() != null) {
//            information.setReturn_date(patch.getReturn_date());
//        }
//        if (patch.getCar_type() != null) {
//            information.setCar_type(patch.getCar_type());
//        }
//
//        return infoRepo.save(information);
//    }
}

