package in.kce.servlet;


import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;


@WebServlet("/AdminServlet")
public class AdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//HttpSession session = request.getSession();
		
		//String username = (String) session.getAttribute("username");
			
		Cookie[] cookies= request.getCookies();
		String user = "";
		
		PrintWriter out = response.getWriter();
		
		if(cookies == null) {
			out.print("<html><body><h1>Admin Page : " + "Cookie is null" + "</h1></body></html>");
			return;
		}
		
		for(Cookie cookie:cookies ) {
			if ("username".equals(cookie.getName())) { // IMPORTANT
                user += cookie.getValue();
                break;
            }
		}
		
		//generate response
		response.setContentType("text/html");
		
		out.print("<html><body><h1>Admin Page : " + user + "</h1></body></html>");
		
	}

}
