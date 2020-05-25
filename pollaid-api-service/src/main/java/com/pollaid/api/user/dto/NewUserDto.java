package com.pollaid.api.user.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;


@Data
@Builder
@AllArgsConstructor
public class NewUserDto {

    private String firstName;

    private String userName;

    private String email;

    private String password;

    private String passwordConfirmation;
}
