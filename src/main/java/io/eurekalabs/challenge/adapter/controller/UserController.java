package io.eurekalabs.challenge.adapter.controller;

import io.eurekalabs.challenge.application.port.in.CreateUser;
import io.eurekalabs.challenge.application.port.in.LoginUser;
import io.eurekalabs.challenge.dto.UserDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
@Api(tags = "users")
public class UserController {

    private final LoginUser loginUser;
    private final CreateUser createUser;

    public UserController(LoginUser loginUser,
            CreateUser createUser) {
        this.loginUser = loginUser;
        this.createUser = createUser;
    }

    @PostMapping("/login")
    @ApiOperation(value = "Login user")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "User logged in successfully"),
            @ApiResponse(code = 401, message = "Disabled user"),
            @ApiResponse(code = 401, message = "Invalid credentials")})
    public ResponseEntity<UserDto> createToken(@RequestBody UserDto request) {
        return ResponseEntity.ok(
                UserDto.fromDomain(
                        loginUser.apply(request)
                )
        );
    }

    @PostMapping
    @ApiOperation(value = "Create user")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "User created ok")})
    public ResponseEntity<UserDto> createUser(@RequestBody UserDto request) {
        return ResponseEntity.ok(
                UserDto.fromDomain(
                        createUser.apply(request)
                )
        );
    }

}
