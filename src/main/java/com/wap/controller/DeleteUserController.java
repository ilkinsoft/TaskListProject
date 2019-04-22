package com.wap.controller;

import com.google.gson.Gson;
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

@WebServlet("/DeleteUser")
public class DeleteUserController extends HttpServlet {

    private IUserrService userService = new UserServiceImpl();
    private Gson gson = new Gson();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userID = request.getParameter("userID");


        Result result = userService.deleteUser(Integer.parseInt(userID));

        String f = gson.toJson(result);

        PrintWriter out = response.getWriter();
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        out.println(f);
        out.flush();
    }
}

