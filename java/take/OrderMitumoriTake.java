package take;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class OrderMitumoriTake
 */
@WebServlet("/OrderMitumoriTake")
public class OrderMitumoriTake extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		
		String cpu = request.getParameter("cpu");
        String cooler = request.getParameter("cooler");
        String mb = request.getParameter("mb");
        String memory = request.getParameter("memory");
        String gb = request.getParameter("gb");
        String ssd = request.getParameter("ssd");
        String box = request.getParameter("box");
        String power = request.getParameter("power");

        Connection connection = null;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(
                    "jdbc:mysql://10.64.144.5:3306/22jygr2-4?characterEncoding=UTF-8",
                    "22jy0201", "22jy0201");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

        // mitumori_id を取得して +1 する処理
        int mitumoriId = 0;
        String getIdQuery = "SELECT MAX(mitumori_id) FROM mitumori";
        try (PreparedStatement getIdStmt1 = connection.prepareStatement(getIdQuery)) {
            ResultSet rs = getIdStmt1.executeQuery();
            if (rs.next()) {
                mitumoriId = rs.getInt(1) + 1;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        // 新しいデータの挿入処理
        String insertmituQuery = "INSERT INTO mitumori (mitumori_id, mitumori_memory, mitumori_power,"
                + "mitumori_graphic, mitumori_cooler, mitumori_box, mitumori_motherboard, mitumori_cpu, mitumori_ssd) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement insertStmt = connection.prepareStatement(insertmituQuery)) {
            insertStmt.setInt(1, mitumoriId);
            insertStmt.setString(2, memory);
            insertStmt.setString(3, power);
            insertStmt.setString(4, gb);
            insertStmt.setString(5, cooler);
            insertStmt.setString(6, box);
            insertStmt.setString(7, mb);
            insertStmt.setString(8, cpu);
            insertStmt.setString(9, ssd);

            int rowsInserted = insertStmt.executeUpdate();

            if (rowsInserted > 0) {
                System.out.println("データが正常に挿入されました。");
            } else {
                System.out.println("データの挿入に失敗しました。");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        String username = (String)session.getAttribute("userId");
        String keyboard = request.getParameter("selectedKeyboardText");
        String mouse = request.getParameter("selectedMouseText");
        String tel = request.getParameter("phonenum");
        String name = request.getParameter("name");
        String address = request.getParameter("address");
        String postnum = request.getParameter("postnum");
        String price = request.getParameter("totalPriceValue");
        
        LocalDateTime now = LocalDateTime.now();
        String orderDate = now.toString();
        
     // 新しいデータの挿入処理
        String insertOrderQuery = "INSERT INTO `order` (order_customer, order_date, order_price, order_mitumori, order_postnum, order_address, order_name, order_tel, order_keyboard, order_mouse) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement insertStmt = connection.prepareStatement(insertOrderQuery)) {
            insertStmt.setString(1, username);
            insertStmt.setString(2, orderDate);
            insertStmt.setString(3, price);
            insertStmt.setInt(4, mitumoriId);
            insertStmt.setString(5, postnum);
            insertStmt.setString(6, address);
            insertStmt.setString(7, name);
            insertStmt.setString(8, tel);
            insertStmt.setString(9, keyboard);
            insertStmt.setString(10, mouse);

            int rowsInserted = insertStmt.executeUpdate();

            if (rowsInserted > 0) {
            	out.println("<script>alert('注文が成功しました。');</script>");
            	response.sendRedirect("home.jsp");
                return;
            } else {
                System.out.println("データの挿入に失敗しました。");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
	}

}
