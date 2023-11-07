package com.img.OAuth2Demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.RedirectView;

import java.security.Principal;

@RestController
//@RequestMapping("/api")
public class ControllerDemo {

    @GetMapping("/message")
    public String message(){
        return "hi";
        //return "Hello Everyone...!"+"https://accounts.google.com/o/oauth2/v2/auth/oauthchooseaccount?response_type=code&client_id=424046835023-m0abk66mvtq32s57tkmlve4ad7qk8tve.apps.googleusercontent.com&scope=openid%20profile%20email&state=p6LCnTaCX-4zkr_2mlYII5xe75Aey0aupwalxMUyteY%3D&redirect_uri=http%3A%2F%2Flocalhost%3A8080%2Flogin%2Foauth2%2Fcode%2Fgoogle&nonce=ZFwagyNA3IUkgihBLQr0fo2i9f_a-ocVTcsJqXDd1iA&service=lso&o2v=2&theme=glif&flowName=GeneralOAuthFlow";
    }

    @GetMapping("/hi")
    public RedirectView redirectToSpringIO() {
        String springIOUrl = "google.com/o/oauth2/v2/auth/oauthchooseaccount?response_type=code&client_id=424046835023-m0abk66mvtq32s57tkmlve4ad7qk8tve.apps.googleusercontent.com&scope=openid%20profile%20email&state=p6LCnTaCX-4zkr_2mlYII5xe75Aey0aupwalxMUyteY%3D&redirect_uri=http%3A%2F%2Flocalhost%3A8080";
        return new RedirectView(springIOUrl);
    }

    @GetMapping("/user")
    public Principal user(Principal principal){
        return principal;
    }
}
