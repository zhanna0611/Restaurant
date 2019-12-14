package carrent.microservices.security;

import carrent.microservices.Login;
import carrent.microservices.Person;
import carrent.microservices.User;

import carrent.microservices.data.car1Client;
import org.springframework.context.annotation.Bean;
import org.springframework.http.*;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.password.StandardPasswordEncoder;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static org.apache.logging.log4j.util.Base64Util.encode;

public class UserDetailsServiceImp implements UserDetailsService {
  @Bean
  public PasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
  }
  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

    /*Here we are using dummy data, you need to load user data from
     database or other third party application*/
    System.out.println("im here");
  User user = findUserbyUername(username);

//    User user = new User("lessam", encode("225736"), "Assel","8606","ADMIN");


//    EditTimetable editTimetable = findUserbyUername(username);

    UserBuilder builder = null;
    if (user != null) {
      System.out.println("builder");
      builder = org.springframework.security.core.userdetails.User.withUsername(username);
      builder.password(new BCryptPasswordEncoder().encode(user.getPassword()));
//      builder.password(new StandardPasswordEncoder("53cr3t").encode(user.getPassword()));

//      builder.password(user.getPassword());
      builder.roles(user.getRole());
    } else {
      throw new UsernameNotFoundException("User not found.");
    }

    return builder.build();
  }

  private User findUserbyUername(String username) {
//    if(username.equals("ADMIN")) {
//      return new User(username, passwordEncoder().encode("225736"), "as","8","ADMIN");
//    }

    try {
      RequestFactory requestFactory = new RequestFactory();
      RestTemplate rest = requestFactory.getRestTemplate();




      HttpHeaders headers = new HttpHeaders();
      headers.setContentType(MediaType.APPLICATION_JSON);
      ResponseEntity<User> responseEntity = rest.exchange("http://localhost:8762/auth",
              HttpMethod.POST, new HttpEntity<>(new Person("zhan", "111"), headers), User.class);

      if (responseEntity.getStatusCode().is2xxSuccessful()) {
//        System.out.println("argynbody" + responseEntity.getBody());
//        EditTimetable editTimetable = responseEntity.getBody();

//        String token = responseEntity.getHeaders().getFirst("Authorization");
//        HttpHeaders httpHeaders = responseEntity.getHeaders();
//        token = token.substring(6);
//        Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJ3IiwiYXV0aG9yaXRpZXMiOlsiUk9MRV9BRE1JTiJdLCJpYXQiOjE1NzQwNzc2NjUsImV4cCI6MTU3NDE2NDA2NX0.jv9W-JSzN5rEhnpJ41Tw5MDxRishFoZE3BHVYlo_GYzk0exeAtUaGSE-5pxzW3_bPPEp35aKsCBvRRtrRnjyyA
//        try {
//          Files.write(Paths.get("/Users/lessam07/Downloads/microservices 2/src/main/java/carrent/microservices/token/token.txt"), token.getBytes());
////          Files.write(Paths.get("C:\\Users\\user\\IdeaProjects\\Timetable1_client\\src\\main\\java\\com\\example\\Timetable1\\token\\token.txt"), httpHeaders.toString().getBytes());
//        } catch (IOException e) {
//          e.printStackTrace();
//        }
//        assert editTimetable != null;
//        System.out.println("argynusername: " + editTimetable.getUsername());
//        System.out.println("argynpassword: " + editTimetable.getPassword());
//        System.out.println("argynname: " + editTimetable.getName());
//        System.out.println("argyntitle: " + editTimetable.getTitle());
//        System.out.println("argynrole: " + editTimetable.getRole());
//        return new Teacher(editTimetable.getUsername(), editTimetable.getPassword(), editTimetable.getName(),
//                editTimetable.getTitle(), editTimetable.getRole());

        car1Client timetableClient = new car1Client();
        car1Client.httpHeaders = responseEntity.getHeaders();
        User editTimetable = timetableClient.getByUsername(username);
        return editTimetable;
//        return new User(editTimetable.getUsername(), editTimetable.getPassword(),  editTimetable.getFullname(),  editTimetable.getPhone(), editTimetable.getRole());
//        return editTimetable;


//        return new Teacher("w", "27f6edbc106f28c29f1ebaa43679be09c937d9bf409449ecc7fe3b66a1c6e3907307905d322d71b0", "w", "ws", "ADMIN");


//        log.info("FullName: {}", response.getFullName());
      }




//      String url = "http://localhost:8762/auth";
//      EditTimetable editTimetable = rest.exchange(url,
//              HttpMethod.GET, null, new ParameterizedTypeReference<EditTimetable>() {
//              })
//              .getBody();
//      return new Teacher(editTimetable.getUsername(), editTimetable.getPassword(), editTimetable.getName(),
//              editTimetable.getTitle(), editTimetable.getRole());
    }

    catch (Exception e) {
      System.err.println("Exception in TacoCloudClient: " + e.getMessage());
      e.printStackTrace();
    }
    return new User(username, passwordEncoder().encode("111"), "as","8","ADMIN");
  }
}
