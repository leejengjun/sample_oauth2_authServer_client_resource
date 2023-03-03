package springoauth2.authorizationserver.domain.dto.request;

import lombok.Data;
import lombok.extern.java.Log;
import springoauth2.authorizationserver.domain.entity.User;

import javax.validation.constraints.NotBlank;

@Data
public class SignUpRequest {

    private long id;
    @NotBlank
    private String username;
    @NotBlank
    private String password;
    @NotBlank
    private String email;
    private String rule;
    public User insertToEntity() {
        User user = User.builder()
                .id(id)
                .username(username)
                .password(password)
                .email(email)
                .role("ROLE_USER")
                .build();
        return user;
    }
}
