package microservices.authentication.security;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import static org.apache.logging.log4j.util.Base64Util.encode;

@Service(value="userDetailsService")   // It has to be annotated with @Service.
public class UserDetailsServiceImpl implements UserDetailsService  {
//    private UserRepository userRepo;

////    @Autowired
//    private RestTemplate restTemplate;
@Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

//        microservices.authentication.security.User userInfo =  restTemplate.getForObject(
//                "http://user-details/usersList/",
//                microservices.authentication.security.User.class);
////                (User) userRepo.findAll();
//
//
//
//        List<User> userHistoryList = Arrays.asList(
//                userInfo
//        );
//        System.out.println(userHistoryList);

//         hard coding the users. All passwords must be encoded.



        final List<AppUser> users = Arrays.asList(
//                new AppUser(1, "omar", encoder.encode("12345"), "USER"),
                new AppUser(2, "lessam", passwordEncoder().encode("225736"), "ADMIN")

        );


//        final List<microservices.authentication.security.User> users = new ArrayList<>();
//
//        microservices.authentication.security.User editTimetable = new microservices.authentication.security.User();
//        editTimetable.setRole("ADMIN");
//        editTimetable.setUsername("s");
//        editTimetable.setPassword("27f6edbc106f28c29f1ebaa43679be09c937d9bf409449ecc7fe3b66a1c6e3907307905d322d71b0");
//        editTimetable.setFullName("s");

        for( AppUser appUser: users) {
            if(appUser.getUsername().equals(username)) {

                // Remember that Spring needs roles to be in this format: "ROLE_" + userRole (i.e. "ROLE_ADMIN")
                // So, we need to set it to that format, so we can verify and compare roles (i.e. hasRole("ADMIN")).
                List<GrantedAuthority> grantedAuthorities = AuthorityUtils
                        .commaSeparatedStringToAuthorityList("ROLE_" + appUser.getRole());

                // The "User" class is provided by Spring and represents a model class for user to be returned by UserDetailsService
                // And used by auth manager to verify and check user authentication.
                return new User(appUser.getUsername(),appUser.getPassword(),grantedAuthorities);
            }
        }

        // If user not found. Throw this exception.
        throw new UsernameNotFoundException("Username: " + username + " not found");
    }


//    public ArrayList<microservices.authentication.security.User> getAllUsers() {
//        try {
//            RestTemplate rest = new RestTemplate();
//            String apiCredentials = "rest-client:p@ssword";
//            String base64Credentials = new String(Base64.encodeBase64(apiCredentials.getBytes()));
//
//            HttpHeaders headers = new HttpHeaders();
//            headers.add("Authorizationn", "Basic " + base64Credentials);
//            HttpEntity<String> entity = new HttpEntity<>(headers);
//            return rest.exchange("http://localhost:8762/usersList",
//                    HttpMethod.GET, entity, new ParameterizedTypeReference<ArrayList<microservices.authentication.security.User>>() {
//                    }
//            )
//                    .getBody();
//
//
//        } catch (Exception e) {
//            System.err.println("Exception in TacoCloudClient: " + e.getMessage());
//            e.printStackTrace();
//        }
//        return null;
//    }

//     A (temporary) class represent the user saved in the database.
    private static class AppUser {
        private Integer id;
        private String username, password;
        private String role;

        public AppUser(Integer id, String username, String password, String role) {
            this.id = id;
            this.username = username;
            this.password = password;
            this.role = role;
        }

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }
        public String getRole() {
            return role;
        }

        public void setRole(String role) {
            this.role = role;
        }
    }
}
