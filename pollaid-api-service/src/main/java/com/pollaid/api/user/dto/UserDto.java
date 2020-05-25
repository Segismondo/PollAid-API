package com.pollaid.api.user.dto;

import com.pollaid.api.user.model.UserEntity;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class UserDto {
    private String firstName;

    private String userName;

    private String email;

    private String password;
    
    public static UserDto fromEntity(UserEntity userEntity) {
        return UserDto.builder()
                .firstName(userEntity.getFirstName())
                .userName(userEntity.getUserName())
                .email(userEntity.getEmail())
                .password(userEntity.getPassword())
                .build();
    }
}
