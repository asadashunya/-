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

import dao.BoxDao;
import model.Box;

@WebServlet("/MitumoriBox")
public class MitumoriBox extends HttpServlet {
    private static final long serialVersionUID = 1L;
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");
        // 受け取ったデータを取得
        String goodsName = request.getParameter("goodsName");
        int price = Integer.parseInt(request.getParameter("price"));
        
        // セッションからArrayListを取得するか、新しいArrayListを作成
        ArrayList<String> gboxcartList = (ArrayList<String>) request.getSession().getAttribute("gboxcartList");
        ArrayList<Integer> pboxList = (ArrayList<Integer>) request.getSession().getAttribute("pboxList");
        
        if (gboxcartList == null || pboxList == null) {
            gboxcartList = new ArrayList<>();
            pboxList = new ArrayList<>();
        } else {
            // すでに要素があれば、最初の要素を削除して新しいデータで置き換える
            if (!gboxcartList.isEmpty()) {
                gboxcartList.remove(0);
                pboxList.remove(0);
            }
        }
        // 新しい要素を追加
        gboxcartList.add(goodsName);
        pboxList.add(price);
        
        // セッションにArrayListをセット
        request.getSession().setAttribute("gboxcartList", gboxcartList);
        request.getSession().setAttribute("pboxList", pboxList);
        
        // doPostからdoGetを呼び出す
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");

        BoxDao bd = new BoxDao();
        ArrayList<Box> bdlist;

        // 人気商品順にソートする処理
        String sortBy = request.getParameter("sortBy");
        if ("popularity".equals(sortBy)) {
            bdlist = bd.findAllSortedByPopularity();
        } else if ("highprice".equals(sortBy)) {
            bdlist = bd.findAllSortedByHighPrice();
        } else if ("lowprice".equals(sortBy)) {
            bdlist = bd.findAllSortedByLowPrice();
        } else {
            // 検索パラメータが提供されている場合は、名前検索を行う
            // 提供されていない場合はすべての CPU を取得
            String searchKeyword = request.getParameter("PartName");
            if (searchKeyword != null && !searchKeyword.isEmpty()) {
                bdlist = bd.findBoxByName(searchKeyword);
            } else {
                bdlist = bd.findAll();
            }
        }

        bd.connectionClose();

        // 結果をセッション属性に格納
        HttpSession session = request.getSession();
        session.setAttribute("boxlist", bdlist);

        // JSP ページにフォワード
        RequestDispatcher rd = request.getRequestDispatcher("/mitumorijsp/mitumoriBox.jsp");
        rd.forward(request, response);
    }

}
