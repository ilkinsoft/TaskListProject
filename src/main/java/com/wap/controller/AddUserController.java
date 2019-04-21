package com.wap.controller;

import com.wap.model.dto.UserDto;
import com.wap.model.entity.Team;
import com.wap.model.enums.Role;
import com.wap.service.ITeamService;
import com.wap.service.IUserrService;
import com.wap.service.TeamServiceImpl;
import com.wap.service.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/AddUser")
public class AddUserController extends HttpServlet {

    private IUserrService userService = new UserServiceImpl();
    private ITeamService teamService = new TeamServiceImpl();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        //String location = request.getParameter("location");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");
        //int teamId = Integer.parseInt(request.getParameter("teamId"));
        String password = request.getParameter("password");
        String password2 = request.getParameter("password2");

        Role role = Role.valueOf(request.getParameter("role"));


        //todo get team by name
        //todo check 2 passwords


        UserDto userDto = new UserDto();
        userDto.setFirstName(firstName);
        userDto.setLastName(lastName);
        userDto.setEmail(email);
        userDto.setPhone(phone);
        userDto.setPassword(password);
        userDto.setRole(role);

        userService.addUser(userDto);

        request.getRequestDispatcher("adduser.jsp").forward(request, response);
    }
}

