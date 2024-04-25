package dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Mitumori;

/**
 * Servlet implementation class MitumoriSaveDao
 */
@WebServlet("/MitumoriSaveDao")
public class MitumoriSaveDao extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");
        HttpSession session = request.getSession();
        
        Connection connection = null;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(
                    "jdbc:mysql://10.64.144.5:3306/22jygr2-4?characterEncoding=UTF-8",
                    "22jy0201", "22jy0201");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        
        // cust_num を取得する
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
        
        // セッションにmitusave_idを保存するArrayList
        ArrayList<String> mitusaveIdList = new ArrayList<>();

        String getMitusaveIdQuery = "SELECT mitusave_id FROM mitumori_save WHERE mitusave_customer = ?";
        try (PreparedStatement getIdStmt = connection.prepareStatement(getMitusaveIdQuery)) {
            getIdStmt.setInt(1, cust_num);
            ResultSet rs = getIdStmt.executeQuery();
            while (rs.next()) {
                String mitusaveId = rs.getString("mitusave_id");
                mitusaveIdList.add(mitusaveId);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        // セッションにArrayListを保存
        session.setAttribute("mitusaveIdList", mitusaveIdList);
        

     // mitusave_mitumoriを保存するArrayList
        ArrayList<Integer> mitusaveMitumoriList = new ArrayList<>();
        String getMitusaveMitumoriQuery = "SELECT mitusave_mitumori FROM mitumori_save WHERE mitusave_customer = ?";
        try (PreparedStatement getIdStmt = connection.prepareStatement(getMitusaveMitumoriQuery)) {
            getIdStmt.setInt(1, cust_num);
            ResultSet rs = getIdStmt.executeQuery();
            while (rs.next()) {
                int mitusaveMitumori = rs.getInt("mitusave_mitumori");
                mitusaveMitumoriList.add(mitusaveMitumori);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        // セッションにmitumoriの内容をいれるArrayList
        ArrayList<Mitumori> mitumoriList = new ArrayList<>();
        String sql = "SELECT * FROM mitumori WHERE mitumori_id IN (";
        for (int i = 0; i < mitusaveMitumoriList.size(); i++) {
            sql += "?";
            if (i < mitusaveMitumoriList.size() - 1) {
                sql += ",";
            }
        }
        sql += ")";
        try {
            PreparedStatement state = connection.prepareStatement(sql);
            for (int i = 0; i < mitusaveMitumoriList.size(); i++) {
                state.setInt(i + 1, mitusaveMitumoriList.get(i));
            }
            ResultSet rs = state.executeQuery();
            while(rs.next()) {
                Mitumori mitumori = new Mitumori();
                mitumori.setMitumori_id(rs.getInt("mitumori_id"));
                mitumori.setMitumori_memory(rs.getString("mitumori_memory"));
                mitumori.setMitumori_power(rs.getString("mitumori_power"));
                mitumori.setMitumori_graphic(rs.getString("mitumori_graphic"));
                mitumori.setMitumori_cooler(rs.getString("mitumori_cooler"));
                mitumori.setMitumori_box(rs.getString("mitumori_box"));
                mitumori.setMitumori_motherboard(rs.getString("mitumori_motherboard"));
                mitumori.setMitumori_cpu(rs.getString("mitumori_cpu"));
                mitumori.setMitumori_ssd(rs.getString("mitumori_ssd"));
                mitumoriList.add(mitumori);
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
		
		// セッションにArrayListを保存
        session.setAttribute("mitumoriList", mitumoriList);
        
        RequestDispatcher rd = request.getRequestDispatcher("mitumori_save.jsp");
		rd.forward(request, response);
        
	}

}
