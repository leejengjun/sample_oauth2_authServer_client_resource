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
public class Info implements Serializable {
    private String userId;
    private String infoId;
    private String infoTitle;
    private String infoDescription;
}
