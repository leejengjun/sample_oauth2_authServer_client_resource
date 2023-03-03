package springoauth2.authorizationserver.domain.service;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import springoauth2.authorizationserver.domain.dto.security.CustomUserDetails;
import springoauth2.authorizationserver.domain.entity.User;
import springoauth2.authorizationserver.domain.repository.UserRepository;

@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

            User user = userRepository.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException("User not found"));

            CustomUserDetails customUserDetails = CustomUserDetails.createCustomUserDetails()
                    .username(user.getUsername())
                    .password(user.getPassword())
                    .role(user.getRole())
                    .build();

            return customUserDetails;
    }
}
