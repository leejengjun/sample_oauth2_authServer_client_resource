package springoauth2.resourceserver1;


import lombok.RequiredArgsConstructor;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import springoauth2.resourceserver1.objects.Friend;
import springoauth2.resourceserver1.objects.MyInfo;
import springoauth2.resourceserver1.objects.Info;

import java.util.Arrays;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class MyInfoController {

    private final RestTemplate restTemplate;

    @GetMapping("/myInfo")
    public MyInfo myInfo(JwtAuthenticationToken authenticationToken){

        HttpHeaders header = new HttpHeaders();
        header.add("Authorization", "Bearer " + authenticationToken.getToken().getTokenValue());
        HttpEntity<?> entity = new HttpEntity<>(header);
        String url = "http://localhost:8084/friends";
        ResponseEntity<List<Friend>> response = restTemplate.exchange(url, HttpMethod.GET, entity, new ParameterizedTypeReference<>(){});

        Info info1 = InfoService.getBuild("1 ", "Album1 title ", "Album is nice ", "user1");
        Info info2 = InfoService.getBuild("2 ", "Album2 title ", "Album is beautiful ", "user2");

        return MyInfo.builder().infos(Arrays.asList(info1, info2)).friends(response.getBody()).build();
    }
}