package com.wap.controller;

import com.google.gson.Gson;
import com.wap.service.ITaskService;
import com.wap.service.IUserrService;
import com.wap.service.TaskServiceImpl;
import com.wap.service.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/users")
public class GetAllUsers extends HttpServlet {

    private IUserrService userService = new UserServiceImpl();


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {



        String responseJSON = new Gson().toJson(userService.getAllUsers());

        PrintWriter out = response.getWriter();
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        out.println(responseJSON);
        out.flush();

    }
}
