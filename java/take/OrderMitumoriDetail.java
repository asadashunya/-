package take;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.MitumoriDao;
import model.Mitumori;

/**
 * Servlet implementation class OrderMitumoriDetail
 */
@WebServlet("/OrderMitumoriDetail")
public class OrderMitumoriDetail extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8"); 
		
		// リクエストパラメータからmituidを取得
		int mituid = Integer.parseInt(request.getParameter("mituid"));
        
		MitumoriDao md = new MitumoriDao();
		ArrayList<Mitumori> mdlist = md.findMitumoriByMitusave_id(mituid);
		System.out.println(mdlist);
		md.connectionClose();
		
		HttpSession session = request.getSession();
		session.setAttribute("mdlist", mdlist);
		
		RequestDispatcher rd = request.getRequestDispatcher("order_list_detail.jsp");
		rd.forward(request, response);
	}

}
