package in.kce.servlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String user = request.getParameter("username");
		String pass = request.getParameter("password");
		
		response.setContentType("text/html");
		
		//PrintWriter out = response.getWriter();
		//out.print("<html><body>");
		
		HttpSession session = request.getSession();
		
		session.setAttribute("username", user);
		
		if(user.equals("Admin")) {
			//out.print("<h3>Admin page</h3>" + user);
			RequestDispatcher rd = request.getRequestDispatcher("AdminServlet");
			rd.forward(request, response);
		}else {
			//out.print("<h3>User page</h3>" + user);
			RequestDispatcher rd = request.getRequestDispatcher("UserServlet");
			rd.forward(request, response);
		}
		//out.print("</body></html>");
	}
}
