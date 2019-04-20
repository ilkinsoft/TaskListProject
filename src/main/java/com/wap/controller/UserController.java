package com.wap.controller;

import com.wap.model.dto.UserDto;
import com.wap.model.entity.Team;
import com.wap.model.enums.Role;
import com.wap.service.IUserrService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/User")
public class UserController extends HttpServlet {

    private IUserrService userService;
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        UserDto userDto = new UserDto();
        userDto.setEmail("e-ilkin@msn.com");
        userDto.setFirstName("ilkin");
        userDto.setLastName("alimov");
        userDto.setLocation("Fairfield");
        userDto.setUsername("ilkin");
        userDto.setPassword("123");
        userDto.setPhone("123-456-78");
        userDto.setRole(Role.DEVELOPER);
        userDto.setTeam(new Team());

        userService.addUser(userDto);

//        String color = request.getParameter("color");
//        request.setAttribute("result", "");

        request.getRequestDispatcher("result.jsp").forward(request, response);

    }
}

