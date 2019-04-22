package com.wap.controller;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.wap.model.dto.TaskDto;
import com.wap.model.dto.UserDto;
import com.wap.model.entity.Userr;
import com.wap.model.enums.Priority;
import com.wap.model.result.Result;
import com.wap.model.result.ResultData;
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
import java.util.List;

@WebServlet("/AddTask")
public class TaskController extends HttpServlet {

    private ITaskService taskService = new TaskServiceImpl();
    private IUserrService userService = new UserServiceImpl();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String textOfTask = request.getParameter("textOfTask");
        int assignedTo = Integer.parseInt(request.getParameter("assignedTo"));
        int createdBy = Integer.parseInt(request.getParameter("createdBy"));
        boolean isDone = Boolean.parseBoolean(request.getParameter("isDone"));
        LocalDate dueDate = LocalDate.parse(request.getParameter("dueDate"));
        Priority priority = Priority.valueOf(request.getParameter("priority"));

        TaskDto taskDto = new TaskDto();
        taskDto.setTextOfTask(textOfTask);
        taskDto.setAssignedTo(userService.getUserById(assignedTo));
        taskDto.setCreatedAt(LocalDate.now());
        taskDto.setCreatedBy(userService.getUserById(createdBy));
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

//        String color = request.getParameter("color");
//        request.setAttribute("result", "");

//        request.getRequestDispatcher("addtask.jsp").forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        List<UserDto> userrList = userService.getUsers();
        HttpSession session = request.getSession();
        session.setAttribute("userList", userrList);

    }
}

