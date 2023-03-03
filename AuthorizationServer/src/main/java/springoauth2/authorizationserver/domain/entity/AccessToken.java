package springoauth2.authorizationserver.domain.entity;

import lombok.Data;

import java.io.Serializable;

@Data
public class AccessToken implements Serializable {
    private String token;
}
