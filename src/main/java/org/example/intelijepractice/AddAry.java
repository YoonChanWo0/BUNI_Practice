package org.example.intelijepractice;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/addary")
public class AddAry extends HttpServlet {
    private static final long serialVersionUID = 1L;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String[] n = request.getParameterValues("n[]");
        long result = 0;
        if(n != null){
            for(String s : n){ // n배열에 있는 각각의 요소를 s변수에 할당하여 for문을 돌린다.
                try {
                    result += Long.parseLong(s); // 문자열 s를 Long 타입으로 변환.
                }catch (NumberFormatException e){

                }
            }
        }

        response.setContentType("text/html; charset=utf-8");
        PrintWriter out = response.getWriter();
        out.append("<html><body><h2>계산기 서블릿</h2><hr>");
        out.append("계산결과 : " + result + "</body></html>");
    }
}
