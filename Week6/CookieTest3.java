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
 * Servlet implementation class CookieTest3
 */
@WebServlet("/CookieTest3")
public class CookieTest3 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CookieTest3() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=utf-8");
		
		PrintWriter out = response.getWriter();
		
		Cookie[] cookies = request.getCookies();
		String ptr = "<br> <a href='CookieTest'>Home</a>";
		
		if(cookies == null) {
			out.println("없는 회원");
		}

		for(Cookie ck : cookies) {
		    if(ck.getName().equals("userID")&&!ck.getValue().equals("")){
		    	out.print("welcome2 " + ck.getValue());
		    	out.println(ptr);
		    	break;
		    }
		    else {
		    	out.print("없는 회원");
		    	out.println(ptr);
		    	break;
		    }
		}
;	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
