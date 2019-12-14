package microservices.userdetails;

import microservices.userdetails.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.*;
import lombok.extern.slf4j.Slf4j;

import javax.validation.Valid;
import java.util.Optional;

import static org.springframework.http.HttpStatus.*;

@Slf4j
@RestController

@RequestMapping("/users")

public class UserController {
    private UserRepository userRepo;
    @Autowired
    public UserController(UserRepository userRepo) {
        this.userRepo = userRepo;
    }
    @GetMapping("/{userID}")
    public Optional<User> getAllUsers(@PathVariable("userID") int id) {

        return userRepo.findById(id);
    }

    @GetMapping("/{username}")
    public User getByUsername(@PathVariable("username") String username) {

        return userRepo.findByUsername(username);
    }

    @GetMapping("/usersList")
    public Iterable<User> getUsersList() {

        return userRepo.findAll();
    }

    @PostMapping("/addUser")
    public ResponseEntity<?> addOrder(@RequestBody @Valid User user) {

        userRepo.save(user);

        return new ResponseEntity<>(OK);

    }

    @GetMapping(value = {"/edit", "/edit/{id}"})
    public ResponseEntity<?> orderEditForm(@PathVariable (required = false, name = "id") int id) {
        Optional<User> optionalOrder = userRepo.findById(id);
        if ( optionalOrder.isPresent() ) {
            return new ResponseEntity<>(userRepo.findById(id), OK);
        } else {
            return new ResponseEntity<>(null, NOT_FOUND);
        }

    }

    @GetMapping("/delete/{id}")
    public void deleteOrder(@PathVariable("id") int id) {
        try {
            userRepo.deleteById(id);
        } catch (EmptyResultDataAccessException e) {}
    }



}

