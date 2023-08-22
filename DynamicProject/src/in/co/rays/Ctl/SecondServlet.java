package in.co.rays.Ctl;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Second")
public class SecondServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		System.out.println("In Second servlet do get !!!!!");
		
		
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	String name = req.getParameter("name");
	String surname = (String) req.getAttribute("surname");
		System.out.println("In Second servlet do post " + name +" "+ surname );
	//	resp.sendRedirect("First");
	//RequestDispatcher rd = req.getRequestDispatcher("First");
		
		
	}
	
	
}
