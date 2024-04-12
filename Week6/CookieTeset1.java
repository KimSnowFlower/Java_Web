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
 * Servlet implementation class CookieTest
 */
@WebServlet("/CookieTest")
public class CookieTest extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public CookieTest() {
        super();
    }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=utf-8");

		PrintWriter out = response.getWriter();

		Cookie[] cookies = request.getCookies();

		out.println("<html><body>Welcome");
		String ptr = "<a href='CookieTest01.html'>Login</a>";
		if(cookies == null) {
			out.println(ptr);
		}

		for(Cookie ck : cookies) {
		    if(ck.getName().equals("userID")&&!ck.getValue().equals("")){
		    	String url = "CookieTest2";
		    	response.sendRedirect(url);
		    	break;
		    }
		    else {
		    	out.print(ptr);
		    	break;
		    }
		}
		out.println("</body></html>");	
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
