package com.wap.controller;

import com.wap.model.dto.TeamDto;
import com.wap.service.ITeamService;
import com.wap.service.TeamServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/AddTeam")
public class TeamController extends HttpServlet {

    private ITeamService teamService = new TeamServiceImpl();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String name = request.getParameter("name");
        TeamDto team = new TeamDto();
        team.setName(name);
        teamService.addTeam(team);

//        String color = request.getParameter("color");
//        request.setAttribute("result", "");


        request.getRequestDispatcher("addteam.jsp").forward(request, response);
    }
}

