package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession; // HttpSessionをインポートする

import dao.AssemblyDao;
import model.Assembly;

/**
 * Servlet implementation class Product_price
 */
@WebServlet("/Product_price")
public class Product_price extends HttpServlet {
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

        // 結果をセッション属性に格納
        HttpSession session = request.getSession();
        session.setAttribute("assemblylist", adlist);

        // JSP ページにフォワード
        RequestDispatcher rd = request.getRequestDispatcher("/product_price.jsp");
        rd.forward(request, response);
    }
}