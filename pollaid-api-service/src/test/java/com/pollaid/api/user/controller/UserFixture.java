package com.pollaid.api.user.controller;

import com.pollaid.api.user.dto.NewUserDto;
import com.pollaid.api.user.dto.UpdateUserDto;

public class UserFixture {

    static final String USER_FIRSTNAME = "Miguel";
    static final String USER_USERNAME = "sanchezbr";
    static final String USER_EMAIL = "miguel@gmail.com";
    static final String USER_PASSWORD = "password";
    static final String USER_PASSWORD_CONFIRMATION = "password";

    static final String UPDATED_USER_FIRSTNAME = "Adrian";
    static final String UPDATED_USER_USERNAME = "adrdie";
    static final String UPDATED_USER_EMAIL = "adrian@gmail.com";
    static final String UPDATED_USER_PASSWORD = "updatedPassword";
    static final String UPDATED_USER_PASSWORD_CONFIRMATION = "updatedPassword";

    public static NewUserDto newUser(){
        return NewUserDto.builder()
                .firstName(USER_FIRSTNAME)
                .userName(USER_USERNAME)
                .email(USER_EMAIL)
                .password(USER_PASSWORD)
                .passwordConfirmation(USER_PASSWORD_CONFIRMATION)
                .build();
    }

    public static UpdateUserDto updatedUser(){
        return UpdateUserDto.builder()
                .firstName(UPDATED_USER_FIRSTNAME)
                .userName(UPDATED_USER_USERNAME)
                .email(UPDATED_USER_EMAIL)
                .password(UPDATED_USER_PASSWORD)
                .passwordConfirmation(UPDATED_USER_PASSWORD_CONFIRMATION)
                .build();
    }

}
