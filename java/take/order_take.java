package take;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDateTime;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/order_take")
public class order_take extends HttpServlet {
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
	   	PrintWriter out = response.getWriter();
	   	HttpSession session = request.getSession();
   	 
     String assemblyname = request.getParameter("selectedProductName");
     String username = (String)session.getAttribute("userId");
     String keyboard = request.getParameter("selectedKeyboardText");
     String mouse = request.getParameter("selectedMouseText");
     String tel = request.getParameter("phonenum");
     String name1 = request.getParameter("name1");
     String address = request.getParameter("address");
     String postnum = request.getParameter("postnum");
     String price = request.getParameter("totalPriceValue");
     
     LocalDateTime now = LocalDateTime.now();
     String orderDate = now.toString();
     
     Connection connection = null;
		PreparedStatement preparedStatement = null;


		try {
			// データベースに接続
			Class.forName("com.mysql.jdbc.Driver");
			String jdbcUrl = "jdbc:mysql://10.64.144.5:3306/22jygr2-4?useUnicode=true&characterEncoding=UTF-8";
			String dbUser = "22jy0221";
			String dbPassword = "22jy0221";
			connection = DriverManager.getConnection(jdbcUrl, dbUser, dbPassword);
			// ユーザー情報を検証するクエリを実行
			String orderQuery  = "INSERT INTO `order` (order_assembly, order_customer, order_keyboard, order_mouse, order_tel, order_name, order_address, order_postnum, order_price , order_date) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

	            preparedStatement = connection.prepareStatement(orderQuery);
	            // SQLクエリのプレースホルダーに値を設定
	            preparedStatement.setString(1, assemblyname);
	            preparedStatement.setString(2, username);
	            preparedStatement.setString(3, keyboard );
	            preparedStatement.setString(4, mouse);
	            preparedStatement.setString(5, tel);
	            preparedStatement.setString(6, name1);
	            preparedStatement.setString(7, address);
	            preparedStatement.setString(8, postnum);
	            preparedStatement.setString(9, price);
	            preparedStatement.setString(10, orderDate);
	            
	           
	            // SQLクエリを実行してデータを挿入
	            int rowsInserted = preparedStatement.executeUpdate();
	            if (rowsInserted > 0) {
	             
	                out.println("<script>alert('注文が成功しました。');</script>");
	                response.sendRedirect("home.jsp");
	                return;
	            }
	        } catch (SQLException | ClassNotFoundException e) {
	            System.out.println("データベースエラー: " + e.getMessage());
	            out.println("<script>alert('間違いがあります');</script>");
	            // データの挿入が失敗した場合、エラーメッセージを表示してお問い合わせページに戻る
	            response.sendRedirect("pay_detail.jsp");
	        } finally {
	            // リソースの解放
	            try {
	                if (preparedStatement != null) {
	                    preparedStatement.close();
	                }
	                if (connection != null) {
	                    connection.close();
	                }
	            } catch (SQLException ex) {
	                System.out.println("データベースリソースの解放エラー: " + ex.getMessage());
	            }
	        }
	    }
	}