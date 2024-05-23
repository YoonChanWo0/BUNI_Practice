package org.example.intelijepractice;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SingleForm
 */
@WebServlet("/SingleForm")
public class SingleForm extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Application 저장소 생성
		ServletContext application = request.getServletContext();
		
		int data = Integer.parseInt(request.getParameter("data"));
		String opt = request.getParameter("opt");
		
		int result = 0;
		
		if(opt.equals("=")) {		// input value가 "="일 때
			// 꺼내기
			int aData = (int) application.getAttribute("aData");
			String aOpt = (String) application.getAttribute("aOpt");
			
			if(aOpt.equals("+")) {
				System.out.println("num: " + aData);
				System.out.println("num: " + data);
				result = aData + data;
			}
		
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.append("<!doctype html><html><head><title>Calculator Servlet</title></head><body>")
		.append("계산결과 : " + result)
		.append("</body></html>");
		
		} else {		// "="이 아닐 때는 값을 저장해준다.
			application.setAttribute("aData", data);
			application.setAttribute("aOpt", opt);
			
		}
	}

}
