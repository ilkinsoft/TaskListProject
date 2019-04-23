package com.wap.controller;

import com.google.gson.Gson;
import com.wap.model.dto.TaskDto;
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
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;

@WebServlet("/EditTaskStatus")
public class EditTaskStatusController extends HttpServlet {

    private ITaskService taskService = new TaskServiceImpl();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int id = Integer.parseInt(request.getParameter("id"));
        boolean isDone = Boolean.parseBoolean(request.getParameter("isDone"));

        TaskDto taskDto = taskService.getTaskById(id);
        taskDto.setDone(isDone);
        taskService.updateTask(taskDto);

        String responseJSON = new Gson().toJson(new Result().makeSuccess());

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

