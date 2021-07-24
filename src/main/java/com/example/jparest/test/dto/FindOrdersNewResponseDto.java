package com.example.jparest.test.dto;

import com.example.jparest.test.domain.Users;
import lombok.Data;

@Data
public class FindOrdersNewResponseDto {
    public FindOrdersNewResponseDto(String orderName, Long userId, String userName) {
        this.orderName = orderName;
        this.users = new FindUsersNewResponseDto(userId, userName);
    }

    private String orderName;
    private FindUsersNewResponseDto users;

}
