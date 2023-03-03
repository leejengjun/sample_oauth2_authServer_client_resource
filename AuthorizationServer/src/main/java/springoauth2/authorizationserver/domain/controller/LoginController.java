package springoauth2.authorizationserver.domain.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

    @GetMapping("/login")
    public String login() {
        return "index";
    }

    /*@PostMapping("/login")
    public String loginAfter(@ModelAttribute LoginRequest loginRequest){

        return "redirect:/oauth/authorize ";
    }*/
}
