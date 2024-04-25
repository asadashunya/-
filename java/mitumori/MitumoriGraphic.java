package mitumori;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.Graphic_boardDao;
import model.Graphic_board;

/**
 * Servlet implementation class MitumoriGraphic
 */
@WebServlet("/MitumoriGraphic")
public class MitumoriGraphic extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");
        // 受け取ったデータを取得
        String goodsName = request.getParameter("goodsName");
        int price = Integer.parseInt(request.getParameter("price"));
        
        // セッションからArrayListを取得するか、新しいArrayListを作成
        ArrayList<String> ggraphiccartList = (ArrayList<String>) request.getSession().getAttribute("ggraphiccartList");
        ArrayList<Integer> pgraphicList = (ArrayList<Integer>) request.getSession().getAttribute("pgraphicList");
        
        if (ggraphiccartList == null || pgraphicList == null) {
        	ggraphiccartList = new ArrayList<>();
        	pgraphicList = new ArrayList<>();
        } else {
            // すでに要素があれば、最初の要素を削除して新しいデータで置き換える
            if (!ggraphiccartList.isEmpty()) {
            	ggraphiccartList.remove(0);
            	pgraphicList.remove(0);
            }
        }
        // 新しい要素を追加
        ggraphiccartList.add(goodsName);
        pgraphicList.add(price);
        
        // セッションにArrayListをセット
        request.getSession().setAttribute("ggraphiccartList", ggraphiccartList);
        request.getSession().setAttribute("pgraphicList", pgraphicList);
        
        // doPostからdoGetを呼び出す
        doGet(request, response);
    }
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");

        Graphic_boardDao gbd = new Graphic_boardDao();
        ArrayList<Graphic_board> gbdlist;

     // 人気商品順にソートする処理
        String sortBy = request.getParameter("sortBy");
        if ("popularity".equals(sortBy)) {
        	gbdlist = gbd.findAllSortedByPopularity();
        } else if ("highprice".equals(sortBy)) {
        	gbdlist = gbd.findAllSortedByHighPrice();
        } else if ("lowprice".equals(sortBy)) {
        	gbdlist = gbd.findAllSortedByLowPrice();
        } else {
            // 検索パラメータが提供されている場合は、名前検索を行う
            // 提供されていない場合はすべての CPU を取得
            String searchKeyword = request.getParameter("PartName");
            if (searchKeyword != null && !searchKeyword.isEmpty()) {
            	gbdlist = gbd.findGraphic_boardByName(searchKeyword);
            } else {
            	gbdlist = gbd.findAll();
            }
        }

        gbd.connectionClose();

        // 結果をセッション属性に格納
        HttpSession session = request.getSession();
        session.setAttribute("graphiclist", gbdlist);

        // JSP ページにフォワード
        RequestDispatcher rd = request.getRequestDispatcher("/mitumorijsp/mitumoriGraphic_board.jsp");
        rd.forward(request, response);
	}

}
