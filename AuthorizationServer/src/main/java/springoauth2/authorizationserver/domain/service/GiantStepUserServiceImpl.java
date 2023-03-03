package springoauth2.authorizationserver.domain.service;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import springoauth2.authorizationserver.domain.dto.request.SignUpRequest;
import springoauth2.authorizationserver.domain.repository.UserRepository;

@Service
@RequiredArgsConstructor
public class GiantStepUserServiceImpl implements GiantStepUserService{

    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    @Override
    @Transactional
    public String saveUser(SignUpRequest signUpRequest) {
        signUpRequest.setPassword(passwordEncoder.encode(signUpRequest.getPassword()));
        return userRepository.save(signUpRequest.insertToEntity()).getUsername();
    }
}
