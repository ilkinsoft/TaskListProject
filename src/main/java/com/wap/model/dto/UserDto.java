package com.wap.model.dto;

import com.wap.model.entity.Team;
import com.wap.model.enums.Role;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class UserDto extends BaseDto {

    private String username;
    private String firstName;
    private String lastName;
    private String password;
    private String email;
    private String phone;
    private String location;

    private Role role;

    private Team team;


}
