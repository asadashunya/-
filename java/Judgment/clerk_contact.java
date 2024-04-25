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

import dao.InquiryDao;
import model.Inquiry;

/**
 * Servlet implementation class clerk_member
 */
@WebServlet("/clerk_contact")
public class clerk_contact extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8"); 
		InquiryDao cs = new InquiryDao();
		ArrayList<Inquiry> inlist = cs.findAll();
		System.out.println(inlist);
		cs.connectionClose();
		
		HttpSession session = request.getSession();
		session.setAttribute("Inquirylist", inlist);
		
		RequestDispatcher rd = request.getRequestDispatcher("contact_us.jsp");
		rd.forward(request, response);
		
	}

}
