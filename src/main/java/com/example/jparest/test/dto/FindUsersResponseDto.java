package com.example.jparest.test.dto;

import com.example.jparest.test.domain.Users;
import lombok.Data;

@Data
public class FindUsersResponseDto {

    private Long id;
    private String name;

    public FindUsersResponseDto(Users users) {
        this.id = users.getId();
        this.name = users.getName();
    }

}
