package springoauth2.resourceserver1;

import org.springframework.security.oauth2.core.OAuth2Error;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import springoauth2.resourceserver1.objects.Info;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class InfoController {

    @GetMapping("/infos")
    public List<Info> photos(){

        Info info1 = InfoService.getBuild("1 ", "info1 title ", "info1 is nice ", "user1 ");
        Info info2 = InfoService.getBuild("2 ", "info2 title ", "info2 is nice ", "user2 ");

        return Arrays.asList(info1, info2);
    }
    @GetMapping("/tokenExpire")
    public Map<String, Object> tokenExpire(){

        Map<String, Object> result = new HashMap<>();
        result.put("error",new OAuth2Error("invalid token", "token is expired", null));

        return result;
    }
}