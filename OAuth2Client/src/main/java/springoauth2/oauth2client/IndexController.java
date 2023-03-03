package springoauth2.oauth2client;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

    @GetMapping("/")
    public String index() {
        return "index";
    }

    /*@GetMapping("/login")
    public String loginForm() {
        return "";
    }*/

    @GetMapping("/home")
    public String mainPage() {
        return "main";
    }
}
