package Judgment;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class login
 */
@WebServlet("/login")
public class login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");

		PrintWriter out = response.getWriter();
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String clerk_name = request.getParameter("clerk_name");
		String clerk_pass = request.getParameter("clerk_pass");

		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		
		Connection connection1 = null;
		PreparedStatement preparedStatement1 = null;
		ResultSet resultSet1 = null;

		String userId = "exampleUserId";
		// ここでユーザー名とパスワードの検証を行うべきです
		// 実際のプロジェクトではデータベースと連携して検証するなどの方法があります

		try {
			// データベースに接続
			Class.forName("com.mysql.jdbc.Driver");
			String jdbcUrl = "jdbc:mysql://10.64.144.5:3306/22jygr2-4?characterEncoding=UTF-8";
			String dbUser = "22jy0221";
			String dbPassword = "22jy0221";
			connection = DriverManager.getConnection(jdbcUrl, dbUser, dbPassword);

			// ユーザー情報を検証するクエリを実行
			String query = "SELECT * FROM customer WHERE cust_username=?";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, username);
			resultSet = preparedStatement.executeQuery();
			
			String clerk = "SELECT * FROM clerk WHERE clerk_name=?";
			preparedStatement1 = connection.prepareStatement(clerk);
			preparedStatement1.setString(1, clerk_name);
			resultSet1 = preparedStatement1.executeQuery();
			
			if(resultSet1.next()) {
				String plaintextPasswordFromDB = resultSet1.getString("clerk_pass");
				if(plaintextPasswordFromDB.equals(clerk_pass)) {
					HttpSession session = request.getSession();
			        session.setAttribute("clerkId", clerk_name);
			        response.sendRedirect("clerkpage/clerkpage.jsp");
				}else{
					out.println("ID又はPASSWORDが間違っています。もう一度確認お願いします。");
					response.setContentType("text/html; charset=UTF-8");
					PrintWriter out1 = response.getWriter();
					out1.println("<HTML>");
					out1.println("<HEAD>");
					out1.println("<TITLE>HTMLを出力するサーブレット</TITLE>");
					out1.println("</HEAD>");
					out1.println("<BODY>");
					out1.println("<br><button type=\"button\" onclick=\"history.back()\">戻る</button>");
					out1.println("</BODY>");
					out1.println("</HTML>");
				}	
			}
			if (resultSet.next()) {
				// ログイン成功
				String plaintextPasswordFromDB = resultSet.getString("cust_pass");
				
				if (plaintextPasswordFromDB.equals(password)) {
					HttpSession session = request.getSession();
			        session.setAttribute("userId", username);
			        response.sendRedirect("home.jsp");
				} else {
					out.println("ID又はPASSWORDが間違っています。もう一度確認お願いします。");
					response.setContentType("text/html; charset=UTF-8");
					PrintWriter out1 = response.getWriter();
					out1.println("<HTML>");
					out1.println("<HEAD>");
					out1.println("<TITLE>HTMLを出力するサーブレット</TITLE>");
					out1.println("</HEAD>");
					out1.println("<BODY>");
					out1.println("<br><button type=\"button\" onclick=\"history.back()\">戻る</button>");
					out1.println("</BODY>");
					out1.println("</HTML>");
				}
			} else {
				// ログイン失敗
				out.println("ID又はPASSWORDが間違っています。もう一度確認お願いします。");
				response.setContentType("text/html; charset=UTF-8");
				PrintWriter out1 = response.getWriter();
				out1.println("<HTML>");
				out1.println("<HEAD>");
				out1.println("<TITLE>HTMLを出力するサーブレット</TITLE>");
				out1.println("</HEAD>");
				out1.println("<BODY>");
				out1.println("<br><button type=\"button\" onclick=\"history.back()\">戻る</button>");
				out1.println("</BODY>");
				out1.println("</HTML>");
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				// リソースを解放
				if (resultSet != null)
					resultSet.close();
				if (preparedStatement != null)
					preparedStatement.close();
				if (connection != null)
					connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}