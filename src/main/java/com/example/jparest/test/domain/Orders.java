package com.example.jparest.test.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter @Setter
public class Orders {

    @Id @GeneratedValue
    private Long id;

    @Column(name = "ORDER_NAME")
    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "USER_ID")
    private Users users;

    public void relationSetUsers(Users users) {
        this.users = users;
        users.getOrders().add(this);
    }

}
