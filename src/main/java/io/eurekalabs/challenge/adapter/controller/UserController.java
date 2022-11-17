package io.eurekalabs.challenge.adapter.controller;

import io.eurekalabs.challenge.application.port.in.LoginUser;
import io.eurekalabs.challenge.dto.UserDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {

    private final LoginUser loginUser;

    public UserController(LoginUser loginUser) {
        this.loginUser = loginUser;
    }

    @PostMapping("/login")
    public ResponseEntity<UserDto> createToken(@RequestBody UserDto request) {
        return ResponseEntity.ok(
                UserDto.fromDomain(
                        loginUser.apply(request)
                )
        );
    }

}
