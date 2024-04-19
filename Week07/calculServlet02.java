package com.test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class testServlet02
 */
@WebServlet("/testServlet02")
public class testServlet02 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public testServlet02() {
        super();
    }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=utf-8");
		
		PrintWriter out = response.getWriter();
		
		/*HttpSession session = request.getSession();
		
		String id = (String)session.getAttribute("userID");
		String pw = (String)session.getAttribute("user_pw");

		if(id.equals("")) {
			out.println("로그인 불가능");
		}
		
		out.println("세션 설정이 성공했습니다 <br>");
		out.println(id + "님 환영합니다");*/
		
		/*ServletContext application = request.getServletContext();
		
		out.print("<html><title></title><body>");
		String uid = request.getParameter("uid");
		String res = "<h3>User ID: " + uid + "</h3>";
		out.print(res);
		out.print("</body></html>");*/
		
		int num = 0;
		String n1 = request.getParameter("n1");
		String n2 = request.getParameter("n2");
		String op = request.getParameter("op");
		
		switch(op) {
		case "+":
			num = Integer.parseInt(n1) + Integer.parseInt(n2);
			break;
		case "-":
			num = Integer.parseInt(n1) - Integer.parseInt(n2);
			break;
		case "*":
			num = Integer.parseInt(n1) * Integer.parseInt(n2);
			break;
		case "/":
			num = Integer.parseInt(n1) / Integer.parseInt(n2);
			break;
		}
		
		out.append("<html><body><h2>계산기 서블릿</h2><hr>").append("계산 결과: "+ num +"</body></html>");
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
