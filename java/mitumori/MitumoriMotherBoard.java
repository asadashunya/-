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

import dao.MotherBoardDao;
import model.MotherBoard;

/**
 * Servlet implementation class MitumoriMotherBoard
 */
@WebServlet("/MitumoriMotherBoard")
public class MitumoriMotherBoard extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");
        // 受け取ったデータを取得
        String goodsName = request.getParameter("goodsName");
        int price = Integer.parseInt(request.getParameter("price"));
        
        // セッションからArrayListを取得するか、新しいArrayListを作成
        ArrayList<String> gmbcartList = (ArrayList<String>) request.getSession().getAttribute("gmbcartList");
        ArrayList<Integer> pmbList = (ArrayList<Integer>) request.getSession().getAttribute("pmbList");
        
        if (gmbcartList == null || pmbList == null) {
        	gmbcartList = new ArrayList<>();
            pmbList = new ArrayList<>();
        } else {
            // すでに要素があれば、最初の要素を削除して新しいデータで置き換える
            if (!gmbcartList.isEmpty()) {
            	gmbcartList.remove(0);
                pmbList.remove(0);
            }
        }
        // 新しい要素を追加
        gmbcartList.add(goodsName);
        pmbList.add(price);
        
        // セッションにArrayListをセット
        request.getSession().setAttribute("gmbcartList", gmbcartList);
        request.getSession().setAttribute("pmbList", pmbList);
        
        // doPostからdoGetを呼び出す
        doGet(request, response);
    }
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");

        MotherBoardDao mbd = new MotherBoardDao();
        ArrayList<MotherBoard> mbdlist;

     // 人気商品順にソートする処理
        String sortBy = request.getParameter("sortBy");
        if ("popularity".equals(sortBy)) {
        	mbdlist = mbd.findAllSortedByPopularity();
        } else if ("highprice".equals(sortBy)) {
        	mbdlist = mbd.findAllSortedByHighPrice();
        } else if ("lowprice".equals(sortBy)) {
        	mbdlist = mbd.findAllSortedByLowPrice();
        } else {
            // 検索パラメータが提供されている場合は、名前検索を行う
            // 提供されていない場合はすべての CPU を取得
            String searchKeyword = request.getParameter("PartName");
            if (searchKeyword != null && !searchKeyword.isEmpty()) {
            	mbdlist = mbd.findMotherBoardByName(searchKeyword);
            } else {
            	mbdlist = mbd.findAll();
            }
        }

        mbd.connectionClose();

        // 結果をセッション属性に格納
        HttpSession session = request.getSession();
        session.setAttribute("motherboardlist", mbdlist);

        // JSP ページにフォワード
        RequestDispatcher rd = request.getRequestDispatcher("/mitumorijsp/mitumoriMotherBoard.jsp");
        rd.forward(request, response);
	}

}
