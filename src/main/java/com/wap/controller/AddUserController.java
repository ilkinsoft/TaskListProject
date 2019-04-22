package com.wap.controller;

import com.google.gson.Gson;
import com.wap.model.dto.UserDto;
import com.wap.model.result.Result;
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
import java.io.PrintWriter;


@WebServlet("/AddUser")
public class AddUserController extends HttpServlet {

    private IUserrService userService = new UserServiceImpl();
    private ITeamService teamService = new TeamServiceImpl();
    private Gson gson= new Gson();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
/*        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        //String location = request.getParameter("location");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");
        //int teamId = Integer.parseInt(request.getParameter("teamId"));
        String password = request.getParameter("password");

        Role role = Role.valueOf(request.getParameter("role"));


        //todo get team by name


        UserDto userDto = new UserDto();
        userDto.setFirstName(firstName);
        userDto.setLastName(lastName);
        userDto.setEmail(email);
        userDto.setPhone(phone);
        userDto.setPassword(password);
        userDto.setRole(role);*/

        UserDto userDto = new UserDto();

        MyUtil.mapUserObject(request,userDto);



        Result result= userService.addUser(userDto);



        String f =gson.toJson(result);

        PrintWriter out = response.getWriter();
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        out.println(f);
        out.flush();
    }
}

