package com.wap.controller;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.wap.model.dto.TaskDto;
import com.wap.model.dto.UserDto;
import com.wap.model.entity.Userr;
import com.wap.model.enums.Priority;
import com.wap.model.result.Result;
import com.wap.model.result.ResultData;
import com.wap.security.UserJwt;
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
import java.util.List;

@WebServlet("/AddTask")
public class AddTaskController extends HttpServlet {

    private ITaskService taskService = new TaskServiceImpl();
    private IUserrService userService = new UserServiceImpl();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String textOfTask = request.getParameter("textOfTask");
        int assignedTo = Integer.parseInt(request.getParameter("assignedTo"));
        //int createdBy = Integer.parseInt(request.getParameter("createdBy"));
        boolean isDone = Boolean.parseBoolean(request.getParameter("isDone"));
        LocalDateTime dueDate = LocalDateTime.parse(request.getParameter("dueDate"));
        Priority priority = Priority.valueOf(request.getParameter("priority"));


        UserJwt userJwt = (UserJwt) request.getSession().getAttribute("userJwt");

        TaskDto taskDto = new TaskDto();
        taskDto.setTextOfTask(textOfTask);
        taskDto.setAssignedTo(userService.getUserById(assignedTo).getData());
        taskDto.setCreatedBy(userService.getUserById(userJwt.getUserID()).getData());
        taskDto.setDone(isDone);
        taskDto.setDueDate(dueDate);
        taskDto.setPriority(priority);
        taskService.addTask(taskDto);

        String responseJSON = new Gson().toJson(new Result().makeSuccess());

        PrintWriter out = response.getWriter();
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        out.println(responseJSON);
        out.flush();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        List<UserDto> userrList = userService.getUsers();
        HttpSession session = request.getSession();
        session.setAttribute("userList", userrList);

    }
}

