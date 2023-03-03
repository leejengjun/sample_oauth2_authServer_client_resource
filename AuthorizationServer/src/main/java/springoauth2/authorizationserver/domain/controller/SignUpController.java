package springoauth2.authorizationserver.domain.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import springoauth2.authorizationserver.domain.dto.request.SignUpRequest;
import springoauth2.authorizationserver.domain.service.GiantStepUserService;

@Controller
@RequiredArgsConstructor
public class SignUpController {

    private final GiantStepUserService giantStepUserService;

    @GetMapping("/signUp")
    public String signUp(){
        return "signUpForm";
    }

    @PostMapping("/signUp")
    public String signUpDone(@ModelAttribute SignUpRequest signUpRequest) {
        System.out.println("signUpRequest = " + signUpRequest.getUsername());
        String saveUserName = giantStepUserService.saveUser(signUpRequest);

        return "redirect:login";
    }
}
