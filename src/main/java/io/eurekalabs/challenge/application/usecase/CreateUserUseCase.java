package io.eurekalabs.challenge.application.usecase;

import io.eurekalabs.challenge.adapter.repository.UserRepository;
import io.eurekalabs.challenge.application.port.in.CreateUser;
import io.eurekalabs.challenge.domain.User;
import io.eurekalabs.challenge.dto.UserDto;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class CreateUserUseCase implements CreateUser {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public CreateUserUseCase(UserRepository userRepository,
            BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userRepository = userRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @Override
    public User apply(UserDto userDto) {
        userDto.setPassword(bCryptPasswordEncoder.encode(userDto.getPassword()));

        return userRepository.save(UserDto.toDomain(userDto));
    }
}
