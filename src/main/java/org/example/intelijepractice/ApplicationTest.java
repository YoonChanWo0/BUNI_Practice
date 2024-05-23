package org.example.intelijepractice;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ApplicationTest
 */
@WebServlet("/applicationt")
public class ApplicationTest extends HttpServlet {
	private static final long serialVersionUID = 1L;

       
	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Application 저장소 생성
		ServletContext application = request.getServletContext();
		response.setContentType("text/html;charset=utf-8");
		String str = request.getParameter("data");
		// 확인
		System.out.println("data: " + str);
		// 저장
		application.setAttribute("data", str);
		// 꺼내기
		str = (String) application.getAttribute("data");
		System.out.println("Adata: " + str);
		
	}
}
