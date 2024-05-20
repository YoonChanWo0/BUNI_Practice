package org.example.intelijepractice;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "helloServlet", urlPatterns = "/regform")
public class signsing extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Set the response content type
        resp.setContentType("text/html;charset=UTF-8");

        // Get the form data
        String name = req.getParameter("name");
        String email = req.getParameter("email");

        // Write the response
        resp.getWriter().write("<html><body>");
        resp.getWriter().write("<p>Name: " + name + "</p>");
        resp.getWriter().write("<p>Email: " + email + "</p>");
        resp.getWriter().write("</body></html>");
    }
}
