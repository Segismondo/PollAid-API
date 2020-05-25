package com.pollaid.api.user.model;


import com.pollaid.api.common.validator.FieldsMatch;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;


@Entity(name = "User")
@Table(name = "Client")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldsMatch(
        field = "password",
        fieldMatch = "passwordConfirmation",
        message = "Passwords do not match!"
)
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty
    private String firstName;

    @NotEmpty
    @Column(unique = true)
    private String userName;

    @Email
    @Column(unique = true)
    private String email;

    @Size(min = 6)
    private String password;

    @Transient
    private String passwordConfirmation;
}

