package Judgment;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class MitumoriSave
 */
@WebServlet("/MitumoriSave")
public class MitumoriSave extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");

        String sCpu = request.getParameter("sCpu");
        String sCoo = request.getParameter("sCoo");
        String sMob = request.getParameter("sMob");
        String sMem = request.getParameter("sMem");
        String sGra = request.getParameter("sGra");
        String sSsd = request.getParameter("sSsd");
        String sBox = request.getParameter("sBox");
        String sPow = request.getParameter("sPow");
        String sName = request.getParameter("sName");

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
        String insertQuery = "INSERT INTO mitumori (mitumori_id, mitumori_memory, mitumori_power,"
                + "mitumori_graphic, mitumori_cooler, mitumori_box, mitumori_motherboard, mitumori_cpu, mitumori_ssd) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement insertStmt = connection.prepareStatement(insertQuery)) {
            insertStmt.setInt(1, mitumoriId);
            insertStmt.setString(2, sMem);
            insertStmt.setString(3, sPow);
            insertStmt.setString(4, sGra);
            insertStmt.setString(5, sCoo);
            insertStmt.setString(6, sBox);
            insertStmt.setString(7, sMob);
            insertStmt.setString(8, sCpu);
            insertStmt.setString(9, sSsd);

            int rowsInserted = insertStmt.executeUpdate();

            if (rowsInserted > 0) {
                System.out.println("データが正常に挿入されました。");
            } else {
                System.out.println("データの挿入に失敗しました。");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        // cust_num を取得する
        HttpSession session = request.getSession();
        String userId = (String) session.getAttribute("userId");
        int cust_num = 0;
        String getNumQuery = "SELECT cust_num FROM customer WHERE cust_username = ?";
        try (PreparedStatement getIdStmt2 = connection.prepareStatement(getNumQuery)) {
            getIdStmt2.setString(1, userId); // userId をクエリにセット
            ResultSet rs = getIdStmt2.executeQuery();
            if (rs.next()) {
                cust_num = rs.getInt("cust_num");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        // mitumori_id を取得する
        int mitusave = 0;
        String getMitusaveQuery = "SELECT MAX(mitumori_id) FROM mitumori";
        try (PreparedStatement getIdStmt3 = connection.prepareStatement(getMitusaveQuery)) {
            ResultSet rs = getIdStmt3.executeQuery();
            if (rs.next()) {
                mitusave = rs.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        // 新しいデータの挿入処理
        String insertQuery2 = "INSERT INTO mitumori_save (mitusave_id, mitusave_customer, mitusave_mitumori)"
                + "VALUES (?, ?, ?)";
        try (PreparedStatement insertStmt2 = connection.prepareStatement(insertQuery2)) {
            insertStmt2.setString(1, sName);
            insertStmt2.setInt(2, cust_num);
            insertStmt2.setInt(3, mitusave);

            int rowsInserted = insertStmt2.executeUpdate();

            if (rowsInserted > 0) {
                System.out.println("データが正常に挿入されました。");
            } else {
                System.out.println("データの挿入に失敗しました。");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        // リダイレクト先のURL
        String redirectURL = "savecomplete.jsp";

        // リダイレクトの実行
        response.sendRedirect(redirectURL);
    }
}