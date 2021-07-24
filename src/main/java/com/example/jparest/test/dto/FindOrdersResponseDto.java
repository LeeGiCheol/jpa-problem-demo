package com.example.jparest.test.dto;

import com.example.jparest.test.domain.Orders;
import lombok.Data;

@Data
public class FindOrdersResponseDto {
    public FindOrdersResponseDto(Orders order) {
        this.orderId = order.getId();
        this.name = order.getName();
        this.users = new FindUsersResponseDto(order.getUsers());
    }

    private Long orderId;
    private String name;
    private FindUsersResponseDto users;
}
