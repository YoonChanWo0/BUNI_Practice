package org.example.intelijepractice;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/app")
public class app extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        저장소 생성
        ServletContext app = req.getServletContext();

        String str = req.getParameter("data");
//        확인
        System.out.println("data: " + str);
//        저장
        app.setAttribute("data", str);
//        꺼내기
        str = (String)app.getAttribute("data");
        System.out.println("Adata: " + str);
    }
}