package com.wap.security;


import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;


@Getter
@Setter
public class UserJwt {


    public UserJwt() {
    }

    public UserJwt(String name, String email, LocalDateTime createdDate) {
        this.name = name;
        this.email = email;
        this.createdDate = createdDate;
    }

    private String name;
    private String email;

    private LocalDateTime createdDate;


}
