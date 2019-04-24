package com.wap.controller;

import com.wap.model.dto.TeamDto;
import com.wap.model.dto.UserDto;
import com.wap.model.enums.Role;
import com.wap.service.ITeamService;
import com.wap.service.TeamServiceImpl;

import javax.servlet.http.HttpServletRequest;

public class MyUtil {

    public static void mapUserObject(HttpServletRequest request,UserDto userDto) {

        ITeamService teamService = new TeamServiceImpl();


        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String location = request.getParameter("location");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");
        int teamId = Integer.parseInt(request.getParameter("team"));
        String password = request.getParameter("password");

        Role role = Role.valueOf(request.getParameter("role"));


        TeamDto teamDto =teamService.getTeamById(teamId);


        userDto.setFirstName(firstName);
        userDto.setTeam(teamDto);
        userDto.setLocation(location);
        userDto.setLastName(lastName);
        userDto.setEmail(email);
        userDto.setPhone(phone);
        userDto.setPassword(password);
        userDto.setRole(role);

    }
}
