package com.wap.controller;

import com.wap.model.dto.TaskDto;
import com.wap.model.entity.Userr;
import com.wap.model.enums.Priority;
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
import java.time.LocalDate;
import java.util.List;

@WebServlet("/Tasks")
public class TaskListController extends HttpServlet {

    private ITaskService taskService = new TaskServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        List<TaskDto> taskDtos = taskService.getTasks();
        HttpSession session = request.getSession();
        session.setAttribute("taskList", taskDtos);
        session.setAttribute("tt", "ilkinsoft");

//        request.getRequestDispatcher("tasks.jsp").forward(request, response);

//        String textOfTask = request.getParameter("textOfTask");
//        int assignedTo = Integer.parseInt(request.getParameter("assignedTo"));
//        int createdBy = Integer.parseInt(request.getParameter("createdBy"));
//        boolean isDone = Boolean.parseBoolean(request.getParameter("isDone"));
//        LocalDate dueDate = LocalDate.parse(request.getParameter("dueDate"));
//        Priority priority = Priority.valueOf(request.getParameter("priority"));
//
//        TaskDto taskDto = new TaskDto();
//        taskDto.setTextOfTask(textOfTask);
//        taskDto.setAssignedTo((Userr)userService.getUserById(assignedTo).toEntity());
//        taskDto.setCreatedAt(LocalDate.now());
//        taskDto.setCreatedBy((Userr) userService.getUserById(createdBy).toEntity());
//        taskDto.setDone(isDone);
//        taskDto.setDueDate(dueDate);
//        taskDto.setPriority(priority);
//        taskService.addTask(taskDto);

//        request.getRequestDispatcher("addtask.jsp").forward(request, response);
    }
}

