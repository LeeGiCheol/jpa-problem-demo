package com.example.jparest.test.controller;

import com.example.jparest.test.domain.Orders;
import com.example.jparest.test.domain.Users;
import com.example.jparest.test.dto.SaveOrdersRequestDto;
import com.example.jparest.test.service.OrdersService;
import com.example.jparest.test.service.UsersService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class OrdersController {

    private final OrdersService ordersService;
    private final UsersService usersService;

    @PostMapping("/saveOrders")
    public ResponseEntity<?> saveItem(@RequestBody SaveOrdersRequestDto request) {
        Users users = usersService.findById(request.getUserId());
        ordersService.saveOrders(users, request);

        return ResponseEntity.ok(request.getName());
    }

    @PostMapping("/findAllOrders")
    public ResponseEntity<?> findAll() {
        List<Orders> orders = ordersService.findAll();

        return ResponseEntity.ok(orders);
    }

}
