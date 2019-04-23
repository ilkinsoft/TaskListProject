package com.wap.controller;

import com.google.gson.Gson;
import com.wap.model.dto.TeamDto;
import com.wap.model.result.Result;
import com.wap.service.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/EditTeam")
public class EditTeamController extends HttpServlet {

    private ITeamService teamService = new TeamServiceImpl();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");

        TeamDto teamDto = teamService.getTeamById(id);
        teamDto.setName(name);
        teamService.updateTeam(teamDto);

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

