package springoauth2.oauth2client;

import lombok.Data;

import java.io.Serializable;

@Data
public class AccessToken implements Serializable {
    private String token;
}
