package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.http.HttpServlet;

import model.Order;

public class OrderDao extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Connection con = null;
	public OrderDao() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
			System.exit(1);
		}
		try {
			con = DriverManager.getConnection(
					"jdbc:mysql://10.64.144.5:3306/22jygr2-4?characterEncoding=UTF-8"
					,"22jy0221","22jy0221");
		} catch (SQLException e) {
			e.printStackTrace();
			System.exit(1);
		}
	}
	
	public void connectionClose() {
		try {
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public ArrayList<Order> findAll(){
		ArrayList<Order> ar = new ArrayList<>();
		String sql = "select * from `order`";
		try {
			PreparedStatement state = con.prepareStatement(sql);
			ResultSet rs = state.executeQuery();
			while(rs.next()) {
				Order order = new Order();
				order.setOrder_id(rs.getInt("order_id"));
				order.setOrder_customer(rs.getString("order_customer"));
				order.setOrder_date(rs.getString("order_date"));
				order.setOrder_price(rs.getInt("order_price"));
				order.setOrder_mitumori(rs.getInt("order_mitumori"));
				order.setOrder_assembly(rs.getString("order_assembly"));
				ar.add(order);
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
		return ar;
	}
	
	public Order findOrderById(int order_id) {
		Order order = new Order();
		String sql = "select * from `order` where order_id = ?";
		try {
			PreparedStatement state = con.prepareStatement(sql);
			state.setInt(1, order_id); //
			ResultSet rs = state.executeQuery();
			rs.next(); //
			order.setOrder_id(rs.getInt("order_id"));
			order.setOrder_customer(rs.getString("order_customer"));
			order.setOrder_date(rs.getString("order_date"));
			order.setOrder_price(rs.getInt("order_price"));
			order.setOrder_mitumori(rs.getInt("order_mitumori"));
			order.setOrder_assembly(rs.getString("order_assembly"));
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return order;
	}
}
