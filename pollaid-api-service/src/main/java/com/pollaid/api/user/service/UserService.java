package com.pollaid.api.user.service;

import com.pollaid.api.common.dto.IdResponseDto;
import com.pollaid.api.user.dto.NewUserDto;
import com.pollaid.api.user.dto.UserDto;
import com.pollaid.api.user.dto.UpdateUserDto;

import javax.transaction.Transactional;

public interface UserService {

    @Transactional
    public IdResponseDto createUser(NewUserDto userDto);

    public UserDto getUser(Long userId);

    @Transactional
    public IdResponseDto updateUser(UpdateUserDto userDto, Long userId);

    @Transactional
    public void deleteUser(Long userId);
}
