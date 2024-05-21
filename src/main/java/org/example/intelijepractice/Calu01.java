package org.example.intelijepractice;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "Calu01", urlPatterns = "/calu")
public class Calu01 extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int n1 = Integer.parseInt(request.getParameter("n1"));
        int n2 = Integer.parseInt(request.getParameter("n2"));
        String nn = request.getParameter("nn");

        long result = 0;

        switch(nn) {
            case "1": result = n1 + n2; break;
            case "2": result = n1 - n2; break;
            case "3": result = n1 * n2; break;
            case "4": result = n1 / n2; break;
            default: throw new ServletException("Invalid operation");
        }

        response.setContentType("text/html; charset=utf-8"); // text로 만들어진 html문서이다. 인코딩 방식은 utf-8로 설정하겠다.
        PrintWriter out = response.getWriter(); // 서블릿이 클라이언트에게 응답을 작성하려면, 응답 본문을 작성할 수 있는 출력 스트림이 필요한데 출력 스트림을 사용하기 위한 코드
        out.append("<html><body><h2>계산기 서블릿</h2><hr>");
        out.append("계산결과 : " + result + "</body></html>"); // 문자하고 정수하고 더하면 문자로 바뀌어서 출력이 가능하다. .append(result); 는 사용x
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
