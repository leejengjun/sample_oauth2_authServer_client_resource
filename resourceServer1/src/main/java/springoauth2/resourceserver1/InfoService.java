package springoauth2.resourceserver1;


import springoauth2.resourceserver1.objects.Info;

public class InfoService {

    public static Info getBuild(String infoId, String infoTitle, String infoDescription, String user1) {
        return Info.builder()
                .infoId(infoId)
                .infoTitle(infoTitle)
                .infoDescription(infoDescription)
                .userId(user1)
                .build();
    }

}
