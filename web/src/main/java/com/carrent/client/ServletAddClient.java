package com.carrent.client;

import com.prokat.entity.Client;
import com.prokat.service.ClientService;
import com.sun.security.ntlm.Client;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/register", name = "Registation")
public class ServletAddClient extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

            req.getServletContext()
                    .getRequestDispatcher("/WEB-INF/jsp/client/register.jsp")
                    .forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String passport = req.getParameter("passport");
        String address = req.getParameter("address");
        String phoneStr = req.getParameter("phone");
        String password = req.getParameter("password");
        int phone = Integer.parseInt(phoneStr);

        Client client = new Client(name, passport,address,phone,password);
        ClientService.getInstance().addClient(client);
        resp.getWriter().println("Success");
    }
}


