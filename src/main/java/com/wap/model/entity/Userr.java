package com.wap.model.entity;

import com.wap.model.enums.Role;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.ManyToOne;

@Entity
@Getter
@Setter
public class Userr extends BaseEntity {

    private String email;
    private String firstName;
    private String lastName;
    private String password;
    private String phone;
    private String location;

    @Enumerated
    private Role role;

    @ManyToOne
    private Team team;

}
