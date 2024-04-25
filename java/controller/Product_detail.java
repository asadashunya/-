package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.AssemblyDao;
import model.Assembly;

/**
 * Servlet implementation class Puroduct
 */
@WebServlet("/Product_detail")
public class Product_detail extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8"); 
		AssemblyDao ad = new AssemblyDao();
		ArrayList<Assembly> adlist = ad.findAll();
		ad.connectionClose();
		 //セッションに格納する 
		 HttpSession session = request.getSession(); 
		 session.setAttribute("assemblylist", adlist);
		 //forward する 
		 RequestDispatcher rd = request.getRequestDispatcher("product_detail.jsp"); 
		 rd.forward(request, response);
	}

}
