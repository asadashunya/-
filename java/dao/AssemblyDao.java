package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Assembly;

public class AssemblyDao {
	private Connection con = null;
	public AssemblyDao() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
			System.exit(1);
		}
		try {
			con = DriverManager.getConnection(
					"jdbc:mysql://10.64.144.5:3306/22jygr2-4?characterEncoding=UTF-8"
					,"22jy0201","22jy0201");
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
	
	public ArrayList<Assembly> findAll(){
		ArrayList<Assembly> ar = new ArrayList<>();
		String sql = "select * from assembly";
		try {
			PreparedStatement state = con.prepareStatement(sql);
			ResultSet rs = state.executeQuery();
			while(rs.next()) {
				Assembly assembly = new Assembly();
				assembly.setAssembly_name(rs.getString("assembly_name"));
				assembly.setAssembly_price(rs.getInt("assembly_price"));
				assembly.setAssembly_img(rs.getString("assembly_img"));
				assembly.setAssembly_game(rs.getString("assembly_game"));
				assembly.setAssembly_memory(rs.getString("assembly_memory"));
				assembly.setAssembly_power(rs.getString("assembly_power"));
				assembly.setAssembly_graphic(rs.getString("assembly_graphic"));
				assembly.setAssembly_cooler(rs.getString("assembly_cooler"));
				assembly.setAssembly_box(rs.getString("assembly_box"));
				assembly.setAssembly_motherboard(rs.getString("assembly_motherboard"));
				assembly.setAssembly_cpu(rs.getString("assembly_cpu"));
				assembly.setAssembly_ssd(rs.getString("assembly_ssd"));
				ar.add(assembly);
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
		return ar;
	}

	public ArrayList<Assembly> findAllSortedByHighPrice() {
	    ArrayList<Assembly> ar = new ArrayList<>();
	    String sql = "SELECT * FROM assembly ORDER BY assembly_price DESC";
	    try {
	        PreparedStatement state = con.prepareStatement(sql);
	        ResultSet rs = state.executeQuery();
	        while(rs.next()) {
	        	Assembly assembly = new Assembly();
	        	assembly.setAssembly_name(rs.getString("assembly_name"));
				assembly.setAssembly_price(rs.getInt("assembly_price"));
				assembly.setAssembly_img(rs.getString("assembly_img"));
				assembly.setAssembly_game(rs.getString("assembly_game"));
				assembly.setAssembly_memory(rs.getString("assembly_memory"));
				assembly.setAssembly_power(rs.getString("assembly_power"));
				assembly.setAssembly_graphic(rs.getString("assembly_graphic"));
				assembly.setAssembly_cooler(rs.getString("assembly_cooler"));
				assembly.setAssembly_box(rs.getString("assembly_box"));
				assembly.setAssembly_motherboard(rs.getString("assembly_motherboard"));
				assembly.setAssembly_cpu(rs.getString("assembly_cpu"));
				assembly.setAssembly_ssd(rs.getString("assembly_ssd"));
				ar.add(assembly);
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return ar;
	}

	public ArrayList<Assembly> findAllSortedByLowPrice() {
		ArrayList<Assembly> ar = new ArrayList<>();
	    String sql = "SELECT * FROM assembly ORDER BY assembly_price ASC";
	    try {
	        PreparedStatement state = con.prepareStatement(sql);
	        ResultSet rs = state.executeQuery();
	        while(rs.next()) {
	        	Assembly assembly = new Assembly();
	        	assembly.setAssembly_name(rs.getString("assembly_name"));
				assembly.setAssembly_price(rs.getInt("assembly_price"));
				assembly.setAssembly_img(rs.getString("assembly_img"));
				assembly.setAssembly_game(rs.getString("assembly_game"));
				assembly.setAssembly_memory(rs.getString("assembly_memory"));
				assembly.setAssembly_power(rs.getString("assembly_power"));
				assembly.setAssembly_graphic(rs.getString("assembly_graphic"));
				assembly.setAssembly_cooler(rs.getString("assembly_cooler"));
				assembly.setAssembly_box(rs.getString("assembly_box"));
				assembly.setAssembly_motherboard(rs.getString("assembly_motherboard"));
				assembly.setAssembly_cpu(rs.getString("assembly_cpu"));
				assembly.setAssembly_ssd(rs.getString("assembly_ssd"));
				ar.add(assembly);
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return ar;
	}
}
