package io.eurekalabs.challenge.application.usecase;

import io.eurekalabs.challenge.application.port.in.LoginUser;
import io.eurekalabs.challenge.config.security.JwtManager;
import io.eurekalabs.challenge.config.security.JwtUserDetailsService;
import io.eurekalabs.challenge.domain.User;
import io.eurekalabs.challenge.dto.UserDto;
import io.eurekalabs.challenge.exception.CustomResponseException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class LoginUserUseCase implements LoginUser {

    private final JwtUserDetailsService jwtUserDetailsService;
    private final AuthenticationManager authenticationManager;
    private final JwtManager jwtManager;

    public LoginUserUseCase(JwtUserDetailsService jwtUserDetailsService,
            AuthenticationManager authenticationManager,
            JwtManager jwtManager) {
        this.jwtUserDetailsService = jwtUserDetailsService;
        this.authenticationManager = authenticationManager;
        this.jwtManager = jwtManager;
    }

    @Override
    public User apply(UserDto userDto) {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            userDto.getUserName(),
                            userDto.getPassword()
                    )
            );
        } catch (DisabledException e) {
            throw new CustomResponseException(
                    HttpStatus.UNAUTHORIZED, "The user was disabled"
            );
        } catch (BadCredentialsException e) {
            throw new CustomResponseException(
                    HttpStatus.UNAUTHORIZED, "Invalid credentials"
            );
        }
        final var userDetails = jwtUserDetailsService.loadUserByUsername(userDto.getUserName());
        final var jwtToken = jwtManager.generateJwtToken(userDetails);

        return User.builder()
                .token(jwtToken)
                .build();
    }
}
