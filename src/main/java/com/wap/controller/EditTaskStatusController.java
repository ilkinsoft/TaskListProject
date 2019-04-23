package com.wap.controller;

import com.google.gson.Gson;
import com.wap.model.dto.TaskDto;
import com.wap.model.enums.ResultCode;
import com.wap.model.result.Result;
import com.wap.security.UserJwt;
import com.wap.service.ITaskService;
import com.wap.service.TaskServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/EditTaskStatus")
public class EditTaskStatusController extends HttpServlet {

    private ITaskService taskService = new TaskServiceImpl();


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Result result = new Result();
        String responseJSON;

        int id = Integer.parseInt(request.getParameter("id"));
        boolean isDone = Boolean.parseBoolean(request.getParameter("isDone"));

        TaskDto taskDto = taskService.getTaskById(id);


        UserJwt userJwt = (UserJwt) request.getSession().getAttribute("userJwt");

        if (userJwt.getRole().toString().equals("DEVELOPER")) {
            //developer can assign done only if it is assigned to him
            if (taskDto.getAssignedTo().getEmail().equals(userJwt.getEmail())){
                taskDto.setDone(isDone);
                taskService.updateTask(taskDto);
                responseJSON = new Gson().toJson(result.makeSuccess());

            }else {
                result.setResultCode(ResultCode.YOU_ARE_NOT_ASSIGNED_TO_THIS_TASK);
                responseJSON = new Gson().toJson(result);

            }

        }else{
            taskDto.setDone(isDone);
            taskService.updateTask(taskDto);
            responseJSON = new Gson().toJson(result.makeSuccess());
        }




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

