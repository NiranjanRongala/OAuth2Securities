package demo.example.demo.controller;


import io.swagger.v3.oas.models.responses.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Demo {
    @GetMapping ("/hi")
    @PreAuthorize("hasAuthority('admin')")
        public String m1(){
        return "hi";

        }

    @GetMapping("/myproject")
    @PreAuthorize("hasAuthority('user')")
    public String getRedirectUrl() {
        return "redirect:swagger-ui/";
    }

    @GetMapping("/bye")
    @PreAuthorize("hasAuthority('admin')||hasAuthority('offline_access')")
    public ResponseEntity<String> m2(){
        return ResponseEntity.status(HttpStatus.OK).body("bye");
      }

}
