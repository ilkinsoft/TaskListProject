package com.wap.model.dto;

import com.wap.model.entity.Team;
import com.wap.model.entity.Userr;
import com.wap.model.enums.Role;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class UserDto extends BaseDto {


    public UserDto(){

        super.typeTdto=UserDto.class;
        super.typeTEntoty= Userr.class;

    }

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
