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

import dao.PowerDao;
import model.Power;

/**
 * Servlet implementation class MitumoriPower
 */
@WebServlet("/MitumoriPower")
public class MitumoriPower extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");
        // 受け取ったデータを取得
        String goodsName = request.getParameter("goodsName");
        int price = Integer.parseInt(request.getParameter("price"));
        
        // セッションからArrayListを取得するか、新しいArrayListを作成
        ArrayList<String> gpocartList = (ArrayList<String>) request.getSession().getAttribute("gpocartList");
        ArrayList<Integer> ppoList = (ArrayList<Integer>) request.getSession().getAttribute("ppoList");

        if (gpocartList == null || ppoList == null) {
        	gpocartList = new ArrayList<>();
            ppoList = new ArrayList<>();
        } else {
            // すでに要素があれば、最初の要素を削除して新しいデータで置き換える
            if (!gpocartList.isEmpty()) {
            	gpocartList.remove(0);
                ppoList.remove(0);
            }
        }
        // 新しい要素を追加
        gpocartList.add(goodsName);
        ppoList.add(price);
        
        // セッションにArrayListをセット
        request.getSession().setAttribute("gpocartList", gpocartList);
        request.getSession().setAttribute("ppoList", ppoList);
        
        // doPostからdoGetを呼び出す
        doGet(request, response);
    }
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");

        PowerDao pd = new PowerDao();
        ArrayList<Power> pdlist;

     // 人気商品順にソートする処理
        String sortBy = request.getParameter("sortBy");
        if ("popularity".equals(sortBy)) {
        	pdlist = pd.findAllSortedByPopularity();
        } else if ("highprice".equals(sortBy)) {
        	pdlist = pd.findAllSortedByHighPrice();
        } else if ("lowprice".equals(sortBy)) {
        	pdlist = pd.findAllSortedByLowPrice();
        } else {
            // 検索パラメータが提供されている場合は、名前検索を行う
            // 提供されていない場合はすべての CPU を取得
            String searchKeyword = request.getParameter("PartName");
            if (searchKeyword != null && !searchKeyword.isEmpty()) {
            	pdlist = pd.findPowerByName(searchKeyword);
            } else {
            	pdlist = pd.findAll();
            }
        }

        pd.connectionClose();

        // 結果をセッション属性に格納
        HttpSession session = request.getSession();
        session.setAttribute("powerlist", pdlist);

        // JSP ページにフォワード
        RequestDispatcher rd = request.getRequestDispatcher("/mitumorijsp/mitumoriPower.jsp");
        rd.forward(request, response);
	}
}
