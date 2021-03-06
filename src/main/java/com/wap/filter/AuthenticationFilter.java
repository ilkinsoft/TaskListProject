package com.wap.filter;

import com.wap.security.JwtUtil;
import com.wap.security.UserJwt;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

//@WebFilter(urlPatterns = {"/*,/tasks*,/teams*,/userdetails*,/users*"})
@WebFilter(urlPatterns = {"/*"})
public class AuthenticationFilter implements Filter {
    private UserJwt userJwt;
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {

        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;
        HttpSession session = request.getSession();

        boolean loginRequest=false;

        String loginURI = request.getContextPath();
        if(
                request.getRequestURI().equals(loginURI)
                || request.getRequestURI().equals(loginURI+"/")
                || request.getRequestURI().equals(loginURI+"/index.jsp")
                        || request.getRequestURI().equals(loginURI+"/scripts/index.js")

                        || request.getRequestURI().equals(loginURI+"/LogIn")

        ){
            loginRequest = true;
        }

        boolean tokenOK=false;

        String token = (String) session.getAttribute("token");

        if(token!=null && !token.equals("")){
            userJwt = JwtUtil.validate(token);
            if(userJwt!=null){
                tokenOK=true;
                session.setAttribute("userJwt",userJwt);

                if(userJwt.getRole().toString().equals("DEVELOPER")
                        && (request.getRequestURI().equals(loginURI+"/users.jsp")
                        || request.getRequestURI().equals(loginURI+"/teams.jsp"))){

                    response.sendRedirect("tasks.jsp");

                }else {

                }


            }
        }

        if(loginRequest || tokenOK){

            chain.doFilter(req, resp);


        }else {
            response.sendRedirect("index.jsp");

        }


    }

    public void init(FilterConfig config) throws ServletException {

    }

}
