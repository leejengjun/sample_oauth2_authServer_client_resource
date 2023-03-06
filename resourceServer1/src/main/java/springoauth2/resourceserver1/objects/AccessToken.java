package springoauth2.resourceserver1.objects;

import lombok.Data;

import java.io.Serializable;

@Data
public class AccessToken implements Serializable {
    private String token;
}
