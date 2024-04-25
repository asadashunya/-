package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Puroduct
 */
@WebServlet("/Detail")
public class Detail extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");
        // 受け取ったデータを取得
        String goodsName = request.getParameter("goodsName");
        ArrayList<String> detail = (ArrayList<String>) request.getSession().getAttribute("detail");
        
     // detailがnullであれば新しいArrayListを作成してセッションに保存
        if (detail == null) {
            detail = new ArrayList<>();
            request.getSession().setAttribute("detail", detail);
        }
        
        // 新しい要素を追加
        detail.add(goodsName);
        
        // JSP ページにフォワード
        RequestDispatcher rd = request.getRequestDispatcher("detail.jsp");
        rd.forward(request, response);
	}

}
