package springoauth2.authorizationserver.domain.service;

import springoauth2.authorizationserver.domain.dto.request.SignUpRequest;

public interface GiantStepUserService {

    public String saveUser(SignUpRequest signUpRequest);
}
