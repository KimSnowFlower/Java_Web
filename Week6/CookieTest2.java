package com.Cookie;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CookieTest2
 */
@WebServlet("/CookieTest2")
public class CookieTest2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public CookieTest2() {
        super();
    }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=utf-8");
		
		PrintWriter out = response.getWriter();
		
		Cookie[] cookies = request.getCookies();
		String ptr = "<br> <a href='CookieTest3'>Another page</a>";
		
		if(cookies == null) {
			String user_id = request.getParameter("id");
			String user_pw = request.getParameter("passwd");
			
			Cookie cookie_id = new Cookie("userID", user_id);
			Cookie cookie_pw = new Cookie("userPW", user_pw);
			response.addCookie(cookie_id);
			response.addCookie(cookie_pw);
				
			out.println("welcome1 " + user_id);
			out.println(ptr);
		}
		
		for(Cookie ck : cookies) {
			if(ck.getName().equals("userID")&&!ck.getValue().equals("")) {
				//out.println(ptr);
				out.println("welcome1 " + ck.getValue());
			}
		}
		out.println(ptr);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
