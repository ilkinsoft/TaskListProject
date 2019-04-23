package com.wap.controller;

import com.google.gson.Gson;
import com.wap.model.result.Result;
import com.wap.service.ITaskService;
import com.wap.service.ITeamService;
import com.wap.service.TaskServiceImpl;
import com.wap.service.TeamServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/DeleteTeam")
public class DeleteTeamController extends HttpServlet {

    private ITeamService teamService = new TeamServiceImpl();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Result result = teamService.deleteTeam(id);

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

