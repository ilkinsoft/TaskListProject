package com.wap.controller;

import com.google.gson.Gson;
import com.wap.model.dto.UserDto;
import com.wap.model.result.Result;
import com.wap.service.IUserrService;
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
    private Gson gson = new Gson();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        UserDto userDto = new UserDto();

        MyUtil.mapUserObject(request, userDto);


        Result result = userService.addUser(userDto);


        String f = gson.toJson(result);

        PrintWriter out = response.getWriter();
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        out.println(f);
        out.flush();
    }
}

