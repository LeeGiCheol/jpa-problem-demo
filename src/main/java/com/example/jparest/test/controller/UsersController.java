package com.example.jparest.test.controller;

import com.example.jparest.test.domain.Users;
import com.example.jparest.test.dto.SignUpRequestDto;
import com.example.jparest.test.dto.SignUpResponseDto;
import com.example.jparest.test.service.UsersService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UsersController {

    private final UsersService usersService;


    @PostMapping("/signUp")
    public ResponseEntity<SignUpResponseDto> signUp(@RequestBody SignUpRequestDto request) {
        Users users = usersService.signUp(request);

        return ResponseEntity.ok(new SignUpResponseDto(users.getId(), users.getName()));
    }

}
