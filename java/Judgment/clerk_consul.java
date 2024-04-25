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

import dao.ConsulDao;
import model.Consul;

/**
 * Servlet implementation class clerk_member
 */
@WebServlet("/clerk_consul")
public class clerk_consul extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8"); 
		ConsulDao co = new ConsulDao();
		ArrayList<Consul> colist = co.findAll();
		System.out.println(colist);
		co.connectionClose();
		
		HttpSession session = request.getSession();
		session.setAttribute("Consullist", colist);
		
		RequestDispatcher rd = request.getRequestDispatcher("purchase_counseling.jsp");
		rd.forward(request, response);
		
	}

}
