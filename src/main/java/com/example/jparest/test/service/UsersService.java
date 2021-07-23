package com.example.jparest.test.service;

import com.example.jparest.test.domain.Users;
import com.example.jparest.test.dto.SignUpRequestDto;
import com.example.jparest.test.repository.UsersRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UsersService {

    private final UsersRepository usersRepository;
    private final ModelMapper modelMapper;

    public Users signUp(SignUpRequestDto user) {
        Users saveUser = modelMapper.map(user, Users.class);
        return usersRepository.save(saveUser);
    }

    public Users findById(Long id) {
        return usersRepository.findById(id).get();
    }
}
