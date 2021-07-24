package com.example.jparest.test.controller;

import com.example.jparest.test.domain.Orders;
import com.example.jparest.test.domain.Users;
import com.example.jparest.test.dto.FindOrdersNewResponseDto;
import com.example.jparest.test.dto.FindOrdersResponseDto;
import com.example.jparest.test.dto.SaveOrdersRequestDto;
import com.example.jparest.test.service.OrdersService;
import com.example.jparest.test.service.UsersService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

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

    @PostMapping("/findAllOrders/NPlusOne")
    public ResponseEntity<?> findAllNPlusOne() {
        List<Orders> orders = ordersService.findAll();

        List<FindOrdersResponseDto> orderDto = orders.stream()
                .map(FindOrdersResponseDto::new)
                .collect(Collectors.toList());

        return ResponseEntity.ok(orderDto);
    }

    @PostMapping("/findAllOrders/fetchJoin")
    public ResponseEntity<?> findAllFetchJoin() {
        List<Orders> orders = ordersService.findAllFetchJoin();

        List<FindOrdersResponseDto> orderDto = orders.stream()
                .map(FindOrdersResponseDto::new)
                .collect(Collectors.toList());

        return ResponseEntity.ok(orderDto);
    }

    @PostMapping("/findAllOrders/new")
    public ResponseEntity<?> findAllNew() {
        List<FindOrdersNewResponseDto> orders = ordersService.findAllNew();

        for (FindOrdersNewResponseDto order : orders) {
            order.getUsers().getName();
        }
        return ResponseEntity.ok(orders);
    }


}
