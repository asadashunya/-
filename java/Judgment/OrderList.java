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

import dao.OrderDao;
import model.Order;

/**
 * Servlet implementation class OrderList
 */
@WebServlet("/OrderList")
public class OrderList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8"); 
		OrderDao cs = new OrderDao();
		ArrayList<Order> orlist = cs.findAll();
		System.out.println(orlist);
		cs.connectionClose();
		
		HttpSession session = request.getSession();
		session.setAttribute("Orderlist", orlist);
		
		RequestDispatcher rd = request.getRequestDispatcher("order_list.jsp");
		rd.forward(request, response);
	}

}
