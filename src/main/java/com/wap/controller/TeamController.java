package com.wap.controller;

import com.wap.service.ITeamService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/Team")
public class TeamController extends HttpServlet {

    private ITeamService teamService;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        String color = request.getParameter("color");
        request.setAttribute("result", "");


        request.getRequestDispatcher("result.jsp").forward(request, response);
    }
}

