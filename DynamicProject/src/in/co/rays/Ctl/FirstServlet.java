package in.co.rays.Ctl;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/First")
public class FirstServlet extends HttpServlet {
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		System.out.println("In first servlet do get !!!!!");
		
		resp.sendRedirect("Second");
	}

	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String name = req.getParameter("name");
		System.out.println("In first  servlet do post " +name);
		req.setAttribute("surname", "jat");
		
		RequestDispatcher rd = req.getRequestDispatcher("Second");
		rd.forward(req, resp);
	}
}
