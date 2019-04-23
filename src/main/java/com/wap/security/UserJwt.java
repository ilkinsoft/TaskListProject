package com.wap.security;


import com.wap.model.dto.TeamDto;
import com.wap.model.enums.Role;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class UserJwt {


    public UserJwt() {
    }

    public UserJwt(Role role, String email, int userID, String firstName, String lastName, TeamDto teamDto) {
        this.email = email;
        this.role = role;
        this.userID = userID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.teamDto=teamDto;

    }

    private String email;
    private Role role;
    private int userID;
    private String firstName;
    private String lastName;
    private TeamDto teamDto;


}
