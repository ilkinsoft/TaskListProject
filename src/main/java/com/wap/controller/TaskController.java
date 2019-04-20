package com.wap.controller;

import com.wap.model.dto.TaskDto;
import com.wap.model.entity.Userr;
import com.wap.model.enums.Priority;
import com.wap.service.ITaskService;
import com.wap.service.TaskServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;

@WebServlet("/Task")
public class TaskController extends HttpServlet {

    private ITaskService taskService = new TaskServiceImpl();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        TaskDto taskDto = new TaskDto();
        taskDto.setTextOfTask("New Task");
        taskDto.setAssignedTo(new Userr());
        taskDto.setCreatedAt(LocalDate.now());
        taskDto.setCreatedBy(new Userr());
        taskDto.setDone(false);
        taskDto.setDueDate(LocalDate.now());
        taskDto.setPriority(Priority.HIGH);
        taskService.addTask(taskDto);

        String color = request.getParameter("color");
        request.setAttribute("result", "");


        request.getRequestDispatcher("result.jsp").forward(request, response);

    }
}

