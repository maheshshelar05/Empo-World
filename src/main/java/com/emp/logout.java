package com.emp;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/logout")
public class logout extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        HttpSession session = req.getSession(false); // fetch existing session, don't create new
        if (session != null) {
            session.invalidate();  // destroy session
        }

        // Redirect to login page
        resp.sendRedirect("login.html");
    }
}

