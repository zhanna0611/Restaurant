package carrent.microservices.data;

import carrent.microservices.*;
import carrent.microservices.Information;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
//import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Slf4j
public class car1Client {
    public static HttpHeaders httpHeaders;
    String token;
    public User getByUsername(String username) {
        try {
            RestTemplate rest = new RestTemplate();
//            Map<String, String> urlVariables = new HashMap<>();
//            urlVariables.put("username", username);
//            HttpHeaders headers = new HttpHeaders();
//            HttpServletRequest httpServletRequest;
//            try {
//                token = Files.readAllBytes(Paths.get("/Users/lessam07/Downloads/microservices 2/src/main/java/carrent/microservices/token/token.txt")).toString();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//            headers.add("Authorization", "Bearer eyJhbGciOiJIUzUxMiJ9.eyJz" +
//                    "dWIiOiJ3IiwiYXV0aG9yaXRpZXMiOlsiUk9MRV9BRE1JTiJdLCJpYXQiOjE1Nz" +
//                    "QwNzc2NjUsImV4cCI6MTU3NDE2NDA2NX0.jv9W-JSzN5rEhnpJ41Tw5MDxRishFo" +
//                    "ZE3BHVYlo_GYzk0exeAtUaGSE-5pxzW3_bPPEp35aKsCBvRRtrRnjyyA");
//            httpHeaders.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
//            String apiCredentials = "rest-client:p@ssword";
//            String base64Credentials = new String(Base64.encodeBase64(apiCredentials.getBytes()));
//            httpHeaders.add("Authorization", "Basic " + base64Credentials);
            System.out.println("assel httpheaders");
            HttpEntity<String> entity = new HttpEntity<>("Authorization", httpHeaders);

//            return rest.postForObject("http://localhost:8762/teachers/user/{username}" + username, entity, EditTimetable.class);

//            return rest.exchange("http://localhost:8762/teachers/user/" + username, HttpMethod.POST, entity, new ParameterizedTypeReference<EditTimetable>());
//            return rest.getForObject("http://localhost:8762/teachers/user/{username}",
//                    EditTimetable.class, username);

            User user = new User("lessam", "225736", "Assel","8606","ADMIN");
//            EditTimetable editTimetable = new EditTimetable();
//            editTimetable.setName(teacher.getName());
//            editTimetable.setPassword(teacher.getPassword());
//            editTimetable.setUsername(teacher.getUsername());
//            editTimetable.setRole(teacher.getRole());
//            editTimetable.setROLE_PREFIX(teacher.getROLE_PREFIX());
//            editTimetable.setId(teacher.getId());

            System.out.println("assel"+user);
//            System.out.println(editTimetable1.getPassword());
            return user;

        } catch (Exception e) {
            System.err.println("Exception in TacoCloudClient: " + e.getMessage());
            e.printStackTrace();
        }
        return null;
    }

    //
    // GET examples
    //


//     * Specify parameter as varargs argument
//     * Alternate implementations...
//     * The next three methods are alternative implementations of
//     * getIngredientById() as shown in chapter 6. If you'd like to try
//     * any of them out, comment out the previous method and uncomment
//     * the variant you want to use.
//     */

    /*
     * Specify parameters with a map
     */
    // public Ingredient getIngredientById(String ingredientId) {
    //   Map<String, String> urlVariables = new HashMap<>();
    //   urlVariables.put("id", ingredientId);
    //   return rest.getForObject("http://localhost:8080/ingredients/{id}",
    //       Ingredient.class, urlVariables);
    // }

    /*
     * Request with URI instead of String
     */
    // public Ingredient getIngredientById(String ingredientId) {
    //   Map<String, String> urlVariables = new HashMap<>();
    //   urlVariables.put("id", ingredientId);
    //   URI url = UriComponentsBuilder
    //             .fromHttpUrl("http://localhost:8080/ingredients/{id}")
    //             .build(urlVariables);
    //   return rest.getForObject(url, Ingredient.class);
    // }

    /*
     * Use getForEntity() instead of getForObject()
     */
    // public Ingredient getIngredientById(String ingredientId) {
    //   ResponseEntity<Ingredient> responseEntity =
    //       rest.getForEntity("http://localhost:8080/ingredients/{id}",
    //           Ingredient.class, ingredientId);
    //   log.info("Fetched time: " +
    //           responseEntity.getHeaders().getDate());
    //   return responseEntity.getBody();
    // }

    public List<Information> getAllBookings() {
        try {
            RestTemplate rest = new RestTemplate();


            return rest.exchange("http://localhost:8081/bookings",
                    HttpMethod.GET, null, new ParameterizedTypeReference<List<Information>>() {})
                    .getBody();
        } catch (Exception e) {
            System.err.println("Exception in TacoCloudClient: " + e.getMessage());
            e.printStackTrace();
        }
        return null;
    }

    public List<OrderHistory> getAllHistory() {
        try {
            RestTemplate rest = new RestTemplate();

            return rest.exchange("http://localhost:8082/api/history/3",
                    HttpMethod.GET, null, new ParameterizedTypeReference<List<OrderHistory>>() {})
                    .getBody();
        } catch (Exception e) {
            System.err.println("Exception in TacoCloudClient: " + e.getMessage());
            e.printStackTrace();
        }
        return null;
    }


//    public List<Information> getAllBookings() {
//        try {
//            RestTemplate rest = new RestTemplate();
//
//            return rest.exchange("http://localhost:8081/bookings",
//                    HttpMethod.GET, null, new ParameterizedTypeReference<List<Information>>() {})
//                    .getBody();
//        } catch (Exception e) {
//            System.err.println("Exception in TacoCloudClient: " + e.getMessage());
//            e.printStackTrace();
//        }
//        return null;
//    }


    public Information saveBooking(Information information) {
        try {
            RestTemplate rest = new RestTemplate();
            rest.postForObject("http://localhost:8081/addOrder",
                    information, Information.class);
        } catch (Exception e) {
            System.err.println("Exception in TacoCloudClient: " + e.getMessage());
            e.printStackTrace();
        }
        return null;
    }


    public Information savePayment(Order order) {
        try {
            RestTemplate rest = new RestTemplate();
            rest.postForObject("http://localhost:8083/addPayment",
                    order, Order.class);
        } catch (Exception e) {
            System.err.println("Exception in TacoCloudClient: " + e.getMessage());
            e.printStackTrace();
        }
        return null;
    }

//    public List<User> getAllUsers() {
//        try {
//            RestTemplate rest = new RestTemplate();
//
//            return rest.exchange("http://localhost:8080/users",
//                    HttpMethod.GET, null, new ParameterizedTypeReference<List<User>>() {
//                    })
//                    .getBody();
//        } catch (Exception e) {
//            System.err.println("Exception in TacoCloudClient: " + e.getMessage());
//            e.printStackTrace();
//        }
//        return null;
//    }

    public void saveUser(RegistrationForm user) {
        try {
            RestTemplate rest = new RestTemplate();
            rest.postForObject("http://localhost:8090/register",
                    user, User.class);
        } catch (Exception e) {
            System.err.println("Exception in TacoCloudClient: " + e.getMessage());
            e.printStackTrace();
        }
    }


    public User getUserByUsername(String username)  {
        try {
            RestTemplate rest = new RestTemplate();
            Map<String, String> urlVariables = new HashMap<>();
            urlVariables.put("username", username);
            return rest.getForObject("http://localhost:8084/user/{username}",
                    User.class, urlVariables);
        } catch (Exception e) {
            System.err.println("Exception in TacoCloudClient: " + e.getMessage());
            e.printStackTrace();
        }
        return null;
    }

    public Information deleteById(int id)  {
        try {
            RestTemplate rest = new RestTemplate();
            Map<String, Integer> urlVariables = new HashMap<>();
            urlVariables.put("id", id);
            return rest.getForObject("http://localhost:8081/delete/{id}",
                    Information.class, urlVariables);
        } catch (Exception e) {
            System.err.println("Exception in TacoCloudClient: " + e.getMessage());
            e.printStackTrace();
        }
        return null;
    }
    public Information findById(int id)  {
        try {
            RestTemplate rest = new RestTemplate();
            Map<String, Integer> urlVariables = new HashMap<>();
            urlVariables.put("id", id);
            return rest.getForObject("http://localhost:8081/bookings/{id}",
                    Information.class, urlVariables);
        } catch (Exception e) {
            System.err.println("Exception in TacoCloudClient: " + e.getMessage());
            e.printStackTrace();
        }
        return null;
    }
//  public User getUserByUsername() {
//    RestTemplate rest = new RestTemplate();
//
//    return rest.exchange("/user/{username}",
//            HttpMethod.GET, null, new ParameterizedTypeReference<List<Ingredient>>() {})
//        .getBody();
//  }

    //
    // PUT examples
    //

//  public void updateIngredient(Ingredient ingredient) {
//    rest.put("http://localhost:8080/ingredients/{id}",
//          ingredient, ingredient.getId());
//  }
//
//  //
//  // POST examples
//  //
//  public Ingredient createIngredient(Ingredient ingredient) {
//    return rest.postForObject("http://localhost:8080/ingredients",
//        ingredient, Ingredient.class);
//  }
//
//  /*
//   * Alternate implementations...
//   * The next two methods are alternative implementations of
//   * createIngredient() as shown in chapter 6. If you'd like to try
//   * any of them out, comment out the previous method and uncomment
//   * the variant you want to use.
//   */
//
//  // public URI createIngredient(Ingredient ingredient) {
//  //   return rest.postForLocation("http://localhost:8080/ingredients",
//  //       ingredient, Ingredient.class);
//  // }
//
//  // public Ingredient createIngredient(Ingredient ingredient) {
//  //   ResponseEntity<Ingredient> responseEntity =
//  //          rest.postForEntity("http://localhost:8080/ingredients",
//  //                             ingredient,
//  //                             Ingredient.class);
//  //   log.info("New resource created at " +
//  //            responseEntity.getHeaders().getLocation());
//  //   return responseEntity.getBody();
//  // }
//
//  //
//  // DELETE examples
//  //
//
//  public void deleteIngredient(Ingredient ingredient) {
//    rest.delete("http://localhost:8080/ingredients/{id}",
//        ingredient.getId());
//  }
//
//  //
//  // Traverson with RestTemplate examples
//  //
//
//  public Iterable<Ingredient> getAllIngredientsWithTraverson() {
//    ParameterizedTypeReference<Resources<Ingredient>> ingredientType =
//        new ParameterizedTypeReference<Resources<Ingredient>>() {};
//
//    Resources<Ingredient> ingredientRes =
//        traverson
//          .follow("ingredients")
//          .toObject(ingredientType);
//
//    Collection<Ingredient> ingredients = ingredientRes.getContent();
//
//    return ingredients;
//  }
//
//  public Ingredient addIngredient(Ingredient ingredient) {
//    String ingredientsUrl = traverson
//        .follow("ingredients")
//        .asLink()
//        .getHref();
//    return rest.postForObject(ingredientsUrl,
//                              ingredient,
//                              Ingredient.class);
//  }
//
//

}
