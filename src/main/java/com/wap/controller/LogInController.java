package com.wap.controller;

import com.google.gson.Gson;
import com.wap.model.dto.UserDto;
import com.wap.model.enums.ResultCode;
import com.wap.model.result.Result;
import com.wap.model.result.ResultData;
import com.wap.security.JwtUtil;
import com.wap.security.UserJwt;
import com.wap.service.ITeamService;
import com.wap.service.IUserrService;
import com.wap.service.TeamServiceImpl;
import com.wap.service.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;


@WebServlet("/LogIn")
public class LogInController extends HttpServlet {

    private IUserrService userService = new UserServiceImpl();
    private ITeamService teamService = new TeamServiceImpl();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Result result = new Result();
        String responseJSON;
        HttpSession session = request.getSession();

        //System.out.println("token: " + session.getAttribute("token"));


        String email = request.getParameter("email");
        String password = request.getParameter("password");

        UserDto userDto = null;
        try {
            userDto = userService.getUserByEmail(email).getData();
        } catch (Exception e) {
            e.printStackTrace();

        }

        if (userDto == null) {
            result.setResultCode(ResultCode.NO_SUCH_USER);
            responseJSON = new Gson().toJson(result);


        } else if (!userDto.getPassword().equals(password)) {
            //password doesnt match
            result.setResultCode(ResultCode.WRONG_PASSWORD);
            responseJSON = new Gson().toJson(result);


        } else {
            UserJwt userJwt = new UserJwt(userDto.getRole(),userDto.getEmail(),userDto.getId(),userDto.getFirstName(),userDto.getLastName(),userDto .getTeam());


            ResultData<UserDto> resultData = new ResultData<>();
            resultData.setData((userDto));
            resultData.setResultCode(ResultCode.SUCCESS);
            responseJSON = new Gson().toJson(resultData);

            session.setAttribute("token", JwtUtil.generate(userJwt));

        }


        PrintWriter out = response.getWriter();
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        out.println(responseJSON);
        out.flush();

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
}
