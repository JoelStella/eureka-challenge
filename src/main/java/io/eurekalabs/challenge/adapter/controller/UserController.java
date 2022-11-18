package io.eurekalabs.challenge.adapter.controller;

import io.eurekalabs.challenge.application.port.in.CreateUser;
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
    private final CreateUser createUser;

    public UserController(LoginUser loginUser,
            CreateUser createUser) {
        this.loginUser = loginUser;
        this.createUser = createUser;
    }

    @PostMapping("/login")
    public ResponseEntity<UserDto> createToken(@RequestBody UserDto request) {
        return ResponseEntity.ok(
                UserDto.fromDomain(
                        loginUser.apply(request)
                )
        );
    }

    @PostMapping
    public ResponseEntity<UserDto> createUser(@RequestBody UserDto request) {
        return ResponseEntity.ok(
                UserDto.fromDomain(
                        createUser.apply(request)
                )
        );
    }

}
