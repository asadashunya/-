package take;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class registration_process
 */
@WebServlet("/registration_process")
public class registration_process extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		 PrintWriter out = response.getWriter();
		 String cust_username = request.getParameter("cust_username");
		 String cust_fname = request.getParameter("cust_fname");
		 String cust_lname = request.getParameter("cust_lname");
		 String cust_fkana = request.getParameter("cust_fkana");
		 String cust_lkana = request.getParameter("cust_lkana");
		 String cust_mail = request.getParameter("cust_mail");
		 String cust_pass = request.getParameter("cust_pass");
		 String cust_tel = request.getParameter("cust_tel");
		 String cust_postnum = request.getParameter("cust_postnum");
		 String cust_address = request.getParameter("cust_address");		 
		 
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
				 String inquery = "INSERT INTO customer (cust_username, cust_fname, cust_lname, cust_fkana, cust_lkana , cust_mail "
				 		+ ", cust_pass,cust_tel,cust_postnum,cust_address) VALUES (?, ?, ?, ?, ?,?,?,?,?,?)";
		            preparedStatement = connection.prepareStatement(inquery);
		            // SQLクエリのプレースホルダーに値を設定
		            preparedStatement.setString(1, cust_username);
		            preparedStatement.setString(2, cust_fname);
		            preparedStatement.setString(3, cust_lname);
		            preparedStatement.setString(4, cust_fkana);
		            preparedStatement.setString(5, cust_lkana);
		            preparedStatement.setString(6, cust_mail);
		            preparedStatement.setString(7, cust_pass);
		            preparedStatement.setString(8, cust_tel);
		            preparedStatement.setString(9, cust_postnum);
		            preparedStatement.setString(10, cust_address);
		            
		            
		           
		            // SQLクエリを実行してデータを挿入
		            int rowsInserted = preparedStatement.executeUpdate();
		            if (rowsInserted > 0) {
		                System.out.println("データをデータベースに挿入しました。");
		                response.sendRedirect("home.jsp");
		                return;
		            }
		        } catch (SQLException | ClassNotFoundException e) {
		            System.out.println("データベースエラー: " + e.getMessage());
		            // データの挿入が失敗した場合、エラーメッセージを表示してお問い合わせページに戻る
		            response.sendRedirect("registration_check.jsp?error=に失敗しました。もう一度お試しください。");
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