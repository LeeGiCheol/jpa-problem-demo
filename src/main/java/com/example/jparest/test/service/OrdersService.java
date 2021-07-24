package com.example.jparest.test.service;

import com.example.jparest.test.domain.Orders;
import com.example.jparest.test.domain.Users;
import com.example.jparest.test.dto.FindOrdersNewResponseDto;
import com.example.jparest.test.dto.SaveOrdersRequestDto;
import com.example.jparest.test.repository.OrdersRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import java.util.List;

@Service
@RequiredArgsConstructor
public class OrdersService {

    private final OrdersRepository ordersRepository;
    private final ModelMapper modelMapper;
    private final EntityManager em;

    public void saveOrders(Users users, SaveOrdersRequestDto request) {
        Orders item = modelMapper.map(request, Orders.class);
        item.relationSetUsers(users);
        ordersRepository.save(item);
    }

    public List<Orders> findAll() {
        return ordersRepository.findAll();
    }


    public List<Orders> findAllFetchJoin() {
        return ordersRepository.findAllFetchJoin();
    }

    public List<FindOrdersNewResponseDto> findAllNew() {
        return ordersRepository.findAllNew();
    }
}
