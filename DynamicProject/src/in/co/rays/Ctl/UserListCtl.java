package in.co.rays.Ctl;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.co.rays.bean.UserBean;
import in.co.rays.model.UserModel;
@WebServlet("/UserListCtl")
public class UserListCtl extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		UserModel model = new UserModel();
		int pageNo =1;
		int pageSize =5;
		try {
			
          List list= model.search(null, pageNo, pageSize);
          
          List nextList = model.search(null, pageNo +1, pageSize);
          
			req.setAttribute("list", list);
			req.setAttribute("pageNo", pageNo);
			req.setAttribute("nextListSize", nextList.size());
			RequestDispatcher rd = req.getRequestDispatcher("UserListView.jsp");
			rd.forward(req, resp);
			
		} catch (Exception e) {
          e.printStackTrace();
		}

	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		

		
		
		String op = req.getParameter("operation");

		int pageNo = Integer.parseInt(req.getParameter("pageNo"));
		
		int pageSize = 5;
		
		UserBean bean = new UserBean();
		
		UserModel model = new UserModel();
		
		
		if (op.equals("search")) {
			

	     	String firstName = req.getParameter("firstName");
			
	     	bean.setFirstName(firstName);
			
		}
		
		if (op.equals("next")) {
			pageNo++;
			
		}
		if (op.equals("previous")) {
           pageNo--;			
		}
		

		try {
		List list =	model.search(bean, pageNo, pageSize);
		
		 List nextList = model.search(bean, pageNo, pageSize);
		 
		req.setAttribute("list", list);
		
		req.setAttribute("pageNo", pageNo);
		
		req.setAttribute("nextListSize", nextList.size());
			
			RequestDispatcher rd = req.getRequestDispatcher("UserListView.jsp");
			
			rd.forward(req, resp);
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
		
	}
		
	}

