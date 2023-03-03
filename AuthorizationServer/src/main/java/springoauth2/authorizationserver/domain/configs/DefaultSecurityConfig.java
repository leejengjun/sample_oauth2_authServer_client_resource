
package springoauth2.authorizationserver.domain.configs;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.password.Pbkdf2PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import springoauth2.authorizationserver.domain.dto.security.CustomUserDetails;
import springoauth2.authorizationserver.domain.entity.User;
import springoauth2.authorizationserver.domain.repository.UserRepository;
import springoauth2.authorizationserver.domain.service.CustomUserDetailsService;


@EnableWebSecurity
@RequiredArgsConstructor
public class DefaultSecurityConfig {

	private final CustomUserDetailsService customUserDetailsService;

	@Bean
	public SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {

		http
				.authorizeRequests(request -> request
						.antMatchers("/login", "/signUp", "/css/**").permitAll()
						.anyRequest().authenticated())
				.formLogin(login -> login
						.loginPage("/login")
						.permitAll())
				.logout(logout -> logout
						.logoutUrl("/")
						.permitAll())
				.csrf().disable();
		DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
		daoAuthenticationProvider.setUserDetailsService(customUserDetailsService);
		daoAuthenticationProvider.setPasswordEncoder(passwordEncoder());
		http.authenticationProvider(daoAuthenticationProvider);

		return http.build();
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
}