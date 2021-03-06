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
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@WebServlet("/EditTask")
public class EditTaskController extends HttpServlet {

    private ITaskService taskService = new TaskServiceImpl();
    private IUserrService userService = new UserServiceImpl();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int id = Integer.parseInt(request.getParameter("id"));
        String textOfTask = request.getParameter("textOfTask");
        int assignedTo = Integer.parseInt(request.getParameter("assignedTo"));
        //int createdBy = Integer.parseInt(request.getParameter("createdBy"));
        boolean isDone = Boolean.parseBoolean(request.getParameter("isDone"));
//        LocalDateTime createdAt = LocalDateTime.parse(request.getParameter("createdAt"));
        LocalDateTime dueDate = LocalDateTime.parse(request.getParameter("dueDate"));
        Priority priority = Priority.valueOf(request.getParameter("priority"));

        TaskDto taskDto = taskService.getTaskById(id);
        taskDto.setTextOfTask(textOfTask);
        taskDto.setAssignedTo(userService.getUserById(assignedTo).getData());
//        taskDto.setCreatedAt(createdAt);
        //taskDto.setCreatedBy(userService.getUserById(createdBy).getData());
        taskDto.setDone(isDone);
        taskDto.setDueDate(dueDate);
        taskDto.setPriority(priority);
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

