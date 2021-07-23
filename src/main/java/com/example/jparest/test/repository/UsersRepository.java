package com.example.jparest.test.repository;

import com.example.jparest.test.domain.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersRepository extends JpaRepository<Users, Long> {
}
