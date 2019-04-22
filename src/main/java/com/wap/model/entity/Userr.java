package com.wap.model.entity;

import com.wap.model.enums.Role;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.Proxy;

import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.ManyToOne;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
//@Proxy(lazy = false)

public class Userr extends BaseEntity {

    private String email;
    private String firstName;
    private String lastName;
    private String password;
    private String phone;
    private String location;
    @CreationTimestamp
    private LocalDateTime createdAt;
    @Enumerated
    private Role role;

    @ManyToOne
    private Team team;

}
