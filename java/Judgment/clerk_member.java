package Judgment;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.CustomerDao;
import model.Customer;

/**
 * Servlet implementation class clerk_member
 */
@WebServlet("/clerk_member")
public class clerk_member extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8"); 
		CustomerDao cs = new CustomerDao();
		ArrayList<Customer> cslist = cs.findAll();
		System.out.println(cslist);
		cs.connectionClose();
		
		HttpSession session = request.getSession();
		session.setAttribute("Customerlist", cslist);
		
		RequestDispatcher rd = request.getRequestDispatcher("member_info.jsp");
		rd.forward(request, response);
		
	}

}
