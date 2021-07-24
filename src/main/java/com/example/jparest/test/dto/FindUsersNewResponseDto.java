package com.example.jparest.test.dto;

import com.example.jparest.test.domain.Users;
import lombok.Data;

@Data
public class FindUsersNewResponseDto {

    public FindUsersNewResponseDto(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    private Long id;
    private String name;

}
