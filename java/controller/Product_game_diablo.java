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
 * Servlet implementation class Product_price
 */
@WebServlet("/Product_game_diablo")
public class Product_game_diablo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8"); 
		AssemblyDao ad = new AssemblyDao();
		ArrayList<Assembly> adlist = new ArrayList<>();

        String sortBy = request.getParameter("sortBy");
        if ("highprice".equals(sortBy)) {
            adlist = ad.findAllSortedByHighPrice();
        } else if ("lowprice".equals(sortBy)) {
            adlist = ad.findAllSortedByLowPrice();
        } else {
            adlist = ad.findAll();
        }
        
		ad.connectionClose();
		 //セッションに格納する 
		 HttpSession session = request.getSession(); 
		 session.setAttribute("assemblylist", adlist);
		 //forward する 
		 RequestDispatcher rd = request.getRequestDispatcher("product_game_diablo.jsp"); 
		 rd.forward(request, response);
	}

}
