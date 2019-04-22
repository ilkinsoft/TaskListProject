package com.wap.controller;

import com.wap.model.dto.UserDto;
import com.wap.model.enums.Role;

import javax.servlet.http.HttpServletRequest;

public class MyUtil {

    public static void mapUserObject(HttpServletRequest request,UserDto userDto) {

        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        //String location = request.getParameter("location");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");
        //int teamId = Integer.parseInt(request.getParameter("teamId"));
        String password = request.getParameter("password");

        Role role = Role.valueOf(request.getParameter("role"));


        //todo get team by name


        userDto.setFirstName(firstName);
        userDto.setLastName(lastName);
        userDto.setEmail(email);
        userDto.setPhone(phone);
        userDto.setPassword(password);
        userDto.setRole(role);

    }
}
