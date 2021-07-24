package com.example.jparest.test.repository;

import com.example.jparest.test.domain.Orders;
import com.example.jparest.test.dto.FindOrdersNewResponseDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface OrdersRepository extends JpaRepository<Orders, Long> {

    @Query("SELECT o FROM Orders o JOIN FETCH o.users")
    List<Orders> findAllFetchJoin();

    @Query("SELECT new com.example.jparest.test.dto.FindOrdersNewResponseDto(o.name, u.id, u.name) FROM Orders o JOIN o.users u")
    List<FindOrdersNewResponseDto> findAllNew();

}
