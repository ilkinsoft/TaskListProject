package com.wap.controller;

import com.google.gson.Gson;
import com.wap.model.dto.TaskDto;
import com.wap.model.dto.TeamDto;
import com.wap.model.result.ResultData;
import com.wap.service.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/Teams")
public class GetTeamsController extends HttpServlet {

    private ITeamService teamService = new TeamServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        ResultData<List<TeamDto>> teamDtos = teamService.getTeams();

        String responseJSON = new Gson().toJson(teamDtos);
        PrintWriter out = response.getWriter();
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        out.println(responseJSON);
        out.flush();
    }
}

