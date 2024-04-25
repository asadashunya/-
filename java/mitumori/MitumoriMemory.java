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

import dao.MemoryDao;
import model.Memory;

/**
 * Servlet implementation class MitumoriMemory
 */
@WebServlet("/MitumoriMemory")
public class MitumoriMemory extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");
        // 受け取ったデータを取得
        String goodsName = request.getParameter("goodsName");
        int price = Integer.parseInt(request.getParameter("price"));
        
        // セッションからArrayListを取得するか、新しいArrayListを作成
        ArrayList<String> gmcartList = (ArrayList<String>) request.getSession().getAttribute("gmcartList");
        ArrayList<Integer> pmList = (ArrayList<Integer>) request.getSession().getAttribute("pmList");
        
        if (gmcartList == null || pmList == null) {
        	gmcartList = new ArrayList<>();
        	pmList = new ArrayList<>();
        } else {
            // すでに要素があれば、最初の要素を削除して新しいデータで置き換える
            if (!gmcartList.isEmpty()) {
            	gmcartList.remove(0);
                pmList.remove(0);
            }
        }
        // 新しい要素を追加
        gmcartList.add(goodsName);
        pmList.add(price);
        
        // セッションにArrayListをセット
        request.getSession().setAttribute("gmcartList", gmcartList);
        request.getSession().setAttribute("pmList", pmList);
        
        // doPostからdoGetを呼び出す
        doGet(request, response);
    }
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");

        MemoryDao md = new MemoryDao();
        ArrayList<Memory> mdlist;

     // 人気商品順にソートする処理
        String sortBy = request.getParameter("sortBy");
        if ("popularity".equals(sortBy)) {
        	mdlist = md.findAllSortedByPopularity();
        } else if ("highprice".equals(sortBy)) {
        	mdlist = md.findAllSortedByHighPrice();
        } else if ("lowprice".equals(sortBy)) {
        	mdlist = md.findAllSortedByLowPrice();
        } else {
            // 検索パラメータが提供されている場合は、名前検索を行う
            // 提供されていない場合はすべての CPU を取得
            String searchKeyword = request.getParameter("PartName");
            if (searchKeyword != null && !searchKeyword.isEmpty()) {
            	mdlist = md.findMemoryByName(searchKeyword);
            } else {
            	mdlist = md.findAll();
            }
        }

        md.connectionClose();

        // 結果をセッション属性に格納
        HttpSession session = request.getSession();
        session.setAttribute("memorylist", mdlist);

        // JSP ページにフォワード
        RequestDispatcher rd = request.getRequestDispatcher("/mitumorijsp/mitumoriMemory.jsp");
        rd.forward(request, response);
	}

}
