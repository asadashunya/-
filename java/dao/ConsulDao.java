package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Consul;

public class ConsulDao  {
	private Connection con = null;
	public ConsulDao() {
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
		public ArrayList<Consul> findAll(){
			ArrayList<Consul> ar = new ArrayList<>();
			String sql = "select * from Consul";
			try {
				PreparedStatement state = con.prepareStatement(sql);
				ResultSet rs = state.executeQuery();
				while(rs.next()) {
					Consul consul = new Consul();
					consul.setConsul_id(rs.getInt("consul_id"));
					consul.setConsul_mitumori(rs.getInt("consul_mitumori"));
					consul.setConsul_content(rs.getString("consul_content"));
					consul.setConsul_customer(rs.getInt("consul_customer"));
					ar.add(consul);
				}
			}catch(SQLException e){
				e.printStackTrace();
			}
			return ar;
		}
		public Consul findConsulById(int consul_id) {
			Consul consul = new Consul();
			String sql = "select * from consul where consul_id  = ?";
			try {
				PreparedStatement state = con.prepareStatement(sql);
				state.setInt(1, consul_id); //
				ResultSet rs = state.executeQuery();
				rs.next(); //
				consul.setConsul_id(rs.getInt("consul_id"));
				consul.setConsul_mitumori(rs.getInt("consul_id"));
				consul.setConsul_content(rs.getString("consul_id"));
				consul.setConsul_customer(rs.getInt("consul_id"));
			}catch(SQLException e) {
				e.printStackTrace();
			}
			return consul;
	}
}