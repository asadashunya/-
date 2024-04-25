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

@WebServlet("/Contact")
public class Contact extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	response.setContentType("text/html;charset=UTF-8");
    	 PrintWriter out = response.getWriter();
        // フォームから送信されたデータを取得
        String name = request.getParameter("name");
        String tel = request.getParameter("tel");
        String mail = request.getParameter("mail");
        String title = request.getParameter("title");
        String main = request.getParameter("main");
        String consent1 = request.getParameter("consent_1");
        String consent2 = request.getParameter("consent_2");
        
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
			 String inquery = "INSERT INTO inquiry (inquiry_name, inquiry_tel, inquiry_mail, inquiry_title, inquiry_main) VALUES (?, ?, ?, ?, ?)";
	            preparedStatement = connection.prepareStatement(inquery);
	            // SQLクエリのプレースホルダーに値を設定
	            preparedStatement.setString(1, name);
	            preparedStatement.setString(2, tel);
	            preparedStatement.setString(3, mail);
	            preparedStatement.setString(4, title);
	            preparedStatement.setString(5, main);
	           
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
	            response.sendRedirect("contact.jsp?error=お問い合わせの送信に失敗しました。もう一度お試しください。");
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