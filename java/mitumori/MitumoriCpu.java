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

import dao.CpuDao;
import model.Cpu;

/**
 * Servlet implementation class Top
 */
@WebServlet("/MitumoriCpu")
public class MitumoriCpu extends HttpServlet {
    private static final long serialVersionUID = 1L;
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");
        // 受け取ったデータを取得
        String goodsName = request.getParameter("goodsName");
        int price = Integer.parseInt(request.getParameter("price"));
        
        // セッションからArrayListを取得するか、新しいArrayListを作成
        ArrayList<String> gcpcartList = (ArrayList<String>) request.getSession().getAttribute("gcpcartList");
        ArrayList<Integer> pcpList = (ArrayList<Integer>) request.getSession().getAttribute("pcpList");
        
        if (gcpcartList == null || pcpList == null) {
        	gcpcartList = new ArrayList<>();
        	pcpList = new ArrayList<>();
        } else {
            // すでに要素があれば、最初の要素を削除して新しいデータで置き換える
            if (!gcpcartList.isEmpty()) {
            	gcpcartList.remove(0);
            	pcpList.remove(0);
            }
        }
        // 新しい要素を追加
        gcpcartList.add(goodsName);
        pcpList.add(price);
        
        // セッションにArrayListをセット
        request.getSession().setAttribute("gcpcartList", gcpcartList);
        request.getSession().setAttribute("pcpList", pcpList);
        
        // doPostからdoGetを呼び出す
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");

        CpuDao cd = new CpuDao();
        ArrayList<Cpu> cdlist;

     // 人気商品順にソートする処理
        String sortBy = request.getParameter("sortBy");
        if ("popularity".equals(sortBy)) {
            cdlist = cd.findAllSortedByPopularity();
        } else if ("highprice".equals(sortBy)) {
            cdlist = cd.findAllSortedByHighPrice();
        } else if ("lowprice".equals(sortBy)) {
            cdlist = cd.findAllSortedByLowPrice();
        } else {
            // 検索パラメータが提供されている場合は、名前検索を行う
            // 提供されていない場合はすべての CPU を取得
            String searchKeyword = request.getParameter("PartName");
            if (searchKeyword != null && !searchKeyword.isEmpty()) {
                cdlist = cd.findCpuByName(searchKeyword);
            } else {
                cdlist = cd.findAll();
            }
        }

        cd.connectionClose();

        // 結果をセッション属性に格納
        HttpSession session = request.getSession();
        session.setAttribute("cpulist", cdlist);

        // JSP ページにフォワード
        RequestDispatcher rd = request.getRequestDispatcher("/mitumorijsp/mitumoriCpu.jsp");
        rd.forward(request, response);
    }
}