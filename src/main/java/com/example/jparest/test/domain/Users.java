package com.example.jparest.test.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter
public class Users {

    @Id @GeneratedValue
    private Long id;

    @Column(name = "USER_NAME")
    private String name;


    @JsonIgnore
    @OneToMany(mappedBy = "users")
    private List<Orders> orders = new ArrayList<>();

}
