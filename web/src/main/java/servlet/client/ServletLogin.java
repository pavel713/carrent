package com.prokat.web.servlet.client;

import com.prokat.entity.Client;
import com.prokat.service.ClientService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.Buffer;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

@WebServlet(urlPatterns = "/login", name = "Login")
public class ServletLogin extends HttpServlet {

    private static final Map<String, String> CLIENT = new HashMap<>();

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getServletContext()
                .getRequestDispatcher("/WEB-INF/jsp/client/login.jsp")
                .forward(req, resp);
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        String name = req.getParameter("name");
        String password = req.getParameter("password");

        if (CLIENT.containsKey(name) && CLIENT.get(name).equals(password)) {

            req.getSession().setAttribute("currentClient", new Client(name, password));

            resp.getWriter().write(" Success");
        } else {
            resp.sendRedirect("/index.jsp");
        }
    }
}






