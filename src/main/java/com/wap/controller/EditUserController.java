package com.wap.controller;

import com.google.gson.Gson;
import com.wap.model.dto.UserDto;
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

@WebServlet("/EditUser")
public class EditUserController extends HttpServlet {

    private IUserrService userService = new UserServiceImpl();
    private ITeamService teamService = new TeamServiceImpl();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        int userID = Integer.parseInt(request.getParameter("userID"));

        UserDto userDto=userService.getUserById(userID).getData();

        MyUtil.mapUserObject(request,userDto);






        String responseJSON = new Gson().toJson(userService.updateUser(userDto));

        PrintWriter out = response.getWriter();
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        out.println(responseJSON);
        out.flush();

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
}

