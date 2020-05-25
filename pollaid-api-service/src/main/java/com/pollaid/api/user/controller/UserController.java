package com.pollaid.api.user.controller;

import com.pollaid.api.user.dto.UserDto;
import com.pollaid.api.user.dto.NewUserDto;
import com.pollaid.api.user.dto.UpdateUserDto;
import com.pollaid.api.user.service.UserServiceImpl;
import com.pollaid.api.common.dto.IdResponseDto;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class UserController {

    private final UserServiceImpl userService;

    @GetMapping(path= UserRoutes.GET_USER)
    public ResponseEntity<UserDto> getUser(@PathVariable Long userId) {
        return ResponseEntity.ok(userService.getUser(userId));
    }

    @PostMapping(path = UserRoutes.CREATE_USER)
    public ResponseEntity<IdResponseDto> createUser(@RequestBody NewUserDto userDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.createUser(userDto));
    }

    @DeleteMapping(path = UserRoutes.DELETE_USER)
    public ResponseEntity<Void> deleteById(@PathVariable Long userId){
        userService.deleteUser(userId);
        return ResponseEntity.ok().build();
    }

    @PutMapping(path = UserRoutes.UPDATE_USER)
    public ResponseEntity<IdResponseDto> updateUser(@RequestBody UpdateUserDto userDto, @PathVariable Long userId) {
        return ResponseEntity.ok(userService.updateUser(userDto, userId));
    }
}
