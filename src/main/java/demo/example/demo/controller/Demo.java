package demo.example.demo.controller;


import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.models.responses.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.RedirectView;

@RestController
@SecurityRequirement(name = "Keycloak")
public class Demo {
    @GetMapping ("/hi")
    @PreAuthorize("hasAuthority('admin')")
        public String m1(){
        return "hi";

        }

    @GetMapping("/myproject")
    public String getRedirectUrl() {
        return "redirect:swagger-ui/";
    }

    @GetMapping("/bye")
    @PreAuthorize("hasAuthority('admin')||hasAuthority('offline_access')")
    public ResponseEntity<String> m2(){
        return ResponseEntity.status(HttpStatus.OK).body("bye");
      }
      @GetMapping("/my")
    public String getmy(){
        return "hello";
      }

//    @GetMapping("/redirect")
//    public RedirectView redirectToSpringIO() {
//        String springIOUrl = "https://start.spring.io/";
//        return new RedirectView(springIOUrl);
//    }
//    @GetMapping("/redirect1")
//    public RedirectView redirectToGitHub() {
//        String springIOUrl = "https://github.com/";
//        return new RedirectView(springIOUrl);
//    }
//    @GetMapping("/redirect2")
//    public RedirectView redirect() {
//        // Redirect to the external URL
//        RedirectView redirectView = new RedirectView();
//        redirectView.setUrl("https://start.spring.io/");
//        return redirectView;
//    }




}
