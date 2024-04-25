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

import dao.CoolerDao;
import model.Cooler;

/**
 * Servlet implementation class MitumoriCooler
 */
@WebServlet("/MitumoriCooler")
public class MitumoriCooler extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");
        // 受け取ったデータを取得
        String goodsName = request.getParameter("goodsName");
        int price = Integer.parseInt(request.getParameter("price"));
        
        // セッションからArrayListを取得するか、新しいArrayListを作成
        ArrayList<String> gcocartList = (ArrayList<String>) request.getSession().getAttribute("gcocartList");
        ArrayList<Integer> pcoList = (ArrayList<Integer>) request.getSession().getAttribute("pcoList");
        
        if (gcocartList == null || pcoList == null) {
        	gcocartList = new ArrayList<>();
        	pcoList = new ArrayList<>();
        } else {
            // すでに要素があれば、最初の要素を削除して新しいデータで置き換える
            if (!gcocartList.isEmpty()) {
            	gcocartList.remove(0);
            	pcoList.remove(0);
            }
        }
        // 新しい要素を追加
        gcocartList.add(goodsName);
        pcoList.add(price);
        
        // セッションにArrayListをセット
        request.getSession().setAttribute("gcocartList", gcocartList);
        request.getSession().setAttribute("pcoList", pcoList);
        
        // doPostからdoGetを呼び出す
        doGet(request, response);
    }
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");

        CoolerDao cld = new CoolerDao();
        ArrayList<Cooler> cldlist;

     // 人気商品順にソートする処理
        String sortBy = request.getParameter("sortBy");
        if ("popularity".equals(sortBy)) {
        	cldlist = cld.findAllSortedByPopularity();
        } else if ("highprice".equals(sortBy)) {
        	cldlist = cld.findAllSortedByHighPrice();
        } else if ("lowprice".equals(sortBy)) {
        	cldlist = cld.findAllSortedByLowPrice();
        } else {
            // 検索パラメータが提供されている場合は、名前検索を行う
            // 提供されていない場合はすべての CPU を取得
            String searchKeyword = request.getParameter("PartName");
            if (searchKeyword != null && !searchKeyword.isEmpty()) {
            	cldlist = cld.findCoolerByName(searchKeyword);
            } else {
            	cldlist = cld.findAll();
            }
        }

        cld.connectionClose();

        // 結果をセッション属性に格納
        HttpSession session = request.getSession();
        session.setAttribute("coolerlist", cldlist);

        // JSP ページにフォワード
        RequestDispatcher rd = request.getRequestDispatcher("/mitumorijsp/mitumoriCooler.jsp");
        rd.forward(request, response);
	}

}
