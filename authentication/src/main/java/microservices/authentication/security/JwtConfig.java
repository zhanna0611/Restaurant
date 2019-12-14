package microservices.authentication.security;

import lombok.Getter;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Value;

import java.sql.Blob;

@Getter
@ToString
public class JwtConfig {

   @Value("${security.jwt.uri:/auth/**}")
   private String Uri;

   @Value("${security.jwt.header:Authorizationn}")
   private String header;

   @Value("${security.jwt.prefix:Bearer }")
   private String prefix;

   @Value("${security.jwt.expiration:#{24*60*60}}")
   private int expiration;

   @Value("${security.jwt.secret:JwtSecretKey}")
   private String secret;



    public String getUri (){
        return Uri;
    }

   public int getExpiration() {
       return expiration;
   }

   public String getSecret() {
       return secret;
   }

   public String getHeader() {
       return header;
   }

   public String getPrefix() {
       return prefix;
   }
}
