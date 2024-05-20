package org.example.intelijepractice;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "FormTest", urlPatterns = "/form")
public class FormTest extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String data1 = request.getParameter("data1");
        String data2 = request.getParameter("data2");
        response.setContentType("text/html; charset=utf-8");
        PrintWriter out = response.getWriter();
        out.append("<!doctype html><html><head><title>Data</title></head><body>")
                .append("입력받은 값 : " + data1 + ", " + data2)
                .append("</body></html>");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
