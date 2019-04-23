package com.wap.security;


import com.wap.model.enums.Role;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class UserJwt {


    public UserJwt() {
    }

    public UserJwt(Role role, String email, int userID) {
        this.email = email;
        this.role = role;
        this.userID=userID;
    }

    private String email;
    private Role role;
    private int userID;


}
