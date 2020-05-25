package com.pollaid.api.user.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class UpdateUserDto {

    private String firstName;

    private String userName;

    private String email;

    private String password;

    private String passwordConfirmation;
}
