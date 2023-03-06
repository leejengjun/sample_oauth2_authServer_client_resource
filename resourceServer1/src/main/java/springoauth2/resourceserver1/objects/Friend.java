package springoauth2.resourceserver1.objects;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Friend implements Serializable {
    private String name;
    private int age;
    private String gender;
}
