package springoauth2.resourceserver1.objects;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class MyInfo {
    private List<Info> infos;
    private List<Friend> friends;
}
