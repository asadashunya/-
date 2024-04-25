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

import dao.SaveDao;
import model.Save;

/**
 * Servlet implementation class Mitusave
 */
@WebServlet("/Mitusave")
public class Mitusave extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");
        
        SaveDao saved = new SaveDao();
        ArrayList<Save> savedlist;
        
        HttpSession session = request.getSession();
        String userId = (String) session.getAttribute("userId");
        
        savedlist = saved.findCustByName(userId);
        
        saved.connectionClose();

        // 結果をセッション属性に格納
        session.setAttribute("savedlist", savedlist);

        // JSP ページにフォワード
        RequestDispatcher rd = request.getRequestDispatcher("save.jsp");
        rd.forward(request, response);
	}

}
