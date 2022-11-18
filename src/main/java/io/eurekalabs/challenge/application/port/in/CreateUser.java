package io.eurekalabs.challenge.application.port.in;

import io.eurekalabs.challenge.domain.User;
import io.eurekalabs.challenge.dto.UserDto;

@FunctionalInterface
public interface CreateUser {

    User apply(UserDto userDto);

}
