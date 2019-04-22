package com.wap.controller;

import com.google.gson.Gson;
import com.wap.model.dto.TaskDto;
import com.wap.model.dto.UserDto;
import com.wap.model.enums.Priority;
import com.wap.model.result.Result;
import com.wap.service.ITaskService;
import com.wap.service.IUserrService;
import com.wap.service.TaskServiceImpl;
import com.wap.service.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.util.List;

@WebServlet("/DeleteTask")
public class DeleteTaskController extends HttpServlet {

    private ITaskService taskService = new TaskServiceImpl();
    private IUserrService userService = new UserServiceImpl();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Result result = taskService.deleteTask(id);

        String responseJSON = new Gson().toJson(result);

        PrintWriter out = response.getWriter();
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        out.println(responseJSON);
        out.flush();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


    }

}

