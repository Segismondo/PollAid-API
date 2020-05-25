package com.pollaid.api.user.service;

import com.pollaid.api.user.dto.UserDto;
import com.pollaid.api.user.dto.NewUserDto;
import com.pollaid.api.user.dto.UpdateUserDto;
import com.pollaid.api.user.model.UserEntity;
import com.pollaid.api.user.repository.UserRepository;
import com.pollaid.api.common.dto.IdResponseDto;
import com.pollaid.api.common.exception.EntityNotFound;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

@Validated
@Service
@Slf4j
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private static final String ENTITY = "User";

    private final UserRepository userRepository;

    @Override
    public IdResponseDto createUser(NewUserDto userDto) {
        UserEntity userEntity = userRepository.save(UserEntity.builder()
        .firstName(userDto.getFirstName())
        .userName(userDto.getUserName())
        .email(userDto.getEmail())
        .password(userDto.getPassword())
        .passwordConfirmation(userDto.getPasswordConfirmation())
                .build());

        return IdResponseDto.builder()
                .id(userEntity.getId())
                .build();
    }

    @Override
    public UserDto getUser(Long userId) {
        return userRepository.findById(userId)
                .map(UserDto::fromEntity)
                .orElseThrow(() -> new EntityNotFound(ENTITY, userId));
    }

    @Override
    public IdResponseDto updateUser(UpdateUserDto userDto, Long userId) {

        UserEntity userEntity = userRepository.findById(userId)
                .orElseThrow(() -> new EntityNotFound(ENTITY, userId));

        userEntity.setFirstName(userDto.getFirstName());
        userEntity.setUserName(userDto.getUserName());
        userEntity.setEmail(userDto.getEmail());
        userEntity.setPassword(userDto.getPassword());
        userEntity.setPasswordConfirmation(userDto.getPasswordConfirmation());
        userRepository.save(userEntity);

        return IdResponseDto.builder()
                .id(userEntity.getId())
                .build();

    }

    @Override
    public void deleteUser(Long userId) {
        userRepository.findById(userId).ifPresent(user -> userRepository.deleteById(user.getId()));
    }
}
