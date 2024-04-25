package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Cooler;

public class CoolerDao {
	private Connection con = null;
	public CoolerDao() {
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
	
	public ArrayList<Cooler> findAll(){
		ArrayList<Cooler> ar = new ArrayList<>();
		String sql = "select * from cooler";
		try {
			PreparedStatement state = con.prepareStatement(sql);
			ResultSet rs = state.executeQuery();
			while(rs.next()) {
				Cooler cl = new Cooler();
				cl.setCooler_name(rs.getString("cooler_name"));
				cl.setCooler_socket(rs.getString("cooler_socket"));
				cl.setCooler_price(rs.getInt("cooler_price"));
				cl.setCooler_power(rs.getInt("cooler_power"));
				cl.setCooler_maker(rs.getString("cooler_maker"));
				cl.setCooler_fans(rs.getInt("cooler_fans"));
				cl.setCooler_conector(rs.getInt("cooler_conector"));
				cl.setCooler_img(rs.getString("cooler_img"));
				cl.setCooler_width(rs.getInt("cooler_width"));
				cl.setCooler_height(rs.getInt("cooler_height"));
				cl.setCooler_depth(rs.getInt("cooler_depth"));
				cl.setCooler_id(rs.getInt("cooler_id"));
				cl.setCooler_recid(rs.getInt("cooler_recid"));
				ar.add(cl);
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
		return ar;
	}
	
	public ArrayList<Cooler> findCoolerByName(String cooler_name) {
	    ArrayList<Cooler> coolerList = new ArrayList<>();
	    String sql = "select * from cooler where cooler_name like ?";
	    try {
	        PreparedStatement state = con.prepareStatement(sql);
	        state.setString(1, "%" + cooler_name + "%");
	        ResultSet rs = state.executeQuery();

	        while (rs.next()) {
	        	Cooler cl = new Cooler();
				cl.setCooler_name(rs.getString("cooler_name"));
				cl.setCooler_socket(rs.getString("cooler_socket"));
				cl.setCooler_price(rs.getInt("cooler_price"));
				cl.setCooler_power(rs.getInt("cooler_power"));
				cl.setCooler_maker(rs.getString("cooler_maker"));
				cl.setCooler_fans(rs.getInt("cooler_fans"));
				cl.setCooler_conector(rs.getInt("cooler_conector"));
				cl.setCooler_img(rs.getString("cooler_img"));
				cl.setCooler_width(rs.getInt("cooler_width"));
				cl.setCooler_height(rs.getInt("cooler_height"));
				cl.setCooler_depth(rs.getInt("cooler_depth"));
				cl.setCooler_id(rs.getInt("cooler_id"));
				cl.setCooler_recid(rs.getInt("cooler_recid"));
				coolerList.add(cl);
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return coolerList;
	}
	
	public ArrayList<Cooler> findPerCoolerByName(String cooler_name) {
	    ArrayList<Cooler> coolerList = new ArrayList<>();
	    String sql = "select * from cooler where cooler_name = ?";
	    try {
	        PreparedStatement state = con.prepareStatement(sql);
	        state.setString(1, cooler_name);
	        ResultSet rs = state.executeQuery();

	        while (rs.next()) {
	        	Cooler cl = new Cooler();
				cl.setCooler_name(rs.getString("cooler_name"));
				cl.setCooler_socket(rs.getString("cooler_socket"));
				cl.setCooler_price(rs.getInt("cooler_price"));
				cl.setCooler_power(rs.getInt("cooler_power"));
				cl.setCooler_maker(rs.getString("cooler_maker"));
				cl.setCooler_fans(rs.getInt("cooler_fans"));
				cl.setCooler_conector(rs.getInt("cooler_conector"));
				cl.setCooler_img(rs.getString("cooler_img"));
				cl.setCooler_width(rs.getInt("cooler_width"));
				cl.setCooler_height(rs.getInt("cooler_height"));
				cl.setCooler_depth(rs.getInt("cooler_depth"));
				cl.setCooler_id(rs.getInt("cooler_id"));
				cl.setCooler_recid(rs.getInt("cooler_recid"));
				coolerList.add(cl);
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return coolerList;
	}
	
	public ArrayList<Cooler> findAllSortedByPopularity() {
	    ArrayList<Cooler> ar = new ArrayList<>();
	    String sql = "SELECT * FROM cooler ORDER BY cooler_recid ASC";
	    try {
	        PreparedStatement state = con.prepareStatement(sql);
	        ResultSet rs = state.executeQuery();
	        while(rs.next()) {
	        	Cooler cl = new Cooler();
				cl.setCooler_name(rs.getString("cooler_name"));
				cl.setCooler_socket(rs.getString("cooler_socket"));
				cl.setCooler_price(rs.getInt("cooler_price"));
				cl.setCooler_power(rs.getInt("cooler_power"));
				cl.setCooler_maker(rs.getString("cooler_maker"));
				cl.setCooler_fans(rs.getInt("cooler_fans"));
				cl.setCooler_conector(rs.getInt("cooler_conector"));
				cl.setCooler_img(rs.getString("cooler_img"));
				cl.setCooler_width(rs.getInt("cooler_width"));
				cl.setCooler_height(rs.getInt("cooler_height"));
				cl.setCooler_depth(rs.getInt("cooler_depth"));
				cl.setCooler_id(rs.getInt("cooler_id"));
				cl.setCooler_recid(rs.getInt("cooler_recid"));
				ar.add(cl);
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return ar;
	}
	
	public ArrayList<Cooler> findAllSortedByHighPrice() {
	    ArrayList<Cooler> ar = new ArrayList<>();
	    String sql = "SELECT * FROM cooler ORDER BY cooler_price DESC";
	    try {
	        PreparedStatement state = con.prepareStatement(sql);
	        ResultSet rs = state.executeQuery();
	        while(rs.next()) {
	        	Cooler cl = new Cooler();
				cl.setCooler_name(rs.getString("cooler_name"));
				cl.setCooler_socket(rs.getString("cooler_socket"));
				cl.setCooler_price(rs.getInt("cooler_price"));
				cl.setCooler_power(rs.getInt("cooler_power"));
				cl.setCooler_maker(rs.getString("cooler_maker"));
				cl.setCooler_fans(rs.getInt("cooler_fans"));
				cl.setCooler_conector(rs.getInt("cooler_conector"));
				cl.setCooler_img(rs.getString("cooler_img"));
				cl.setCooler_width(rs.getInt("cooler_width"));
				cl.setCooler_height(rs.getInt("cooler_height"));
				cl.setCooler_depth(rs.getInt("cooler_depth"));
				cl.setCooler_id(rs.getInt("cooler_id"));
				cl.setCooler_recid(rs.getInt("cooler_recid"));
				ar.add(cl);
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return ar;
	}

	public ArrayList<Cooler> findAllSortedByLowPrice() {
	    ArrayList<Cooler> ar = new ArrayList<>();
	    String sql = "SELECT * FROM cooler ORDER BY cooler_price ASC";
	    try {
	        PreparedStatement state = con.prepareStatement(sql);
	        ResultSet rs = state.executeQuery();
	        while(rs.next()) {
	        	Cooler cl = new Cooler();
				cl.setCooler_name(rs.getString("cooler_name"));
				cl.setCooler_socket(rs.getString("cooler_socket"));
				cl.setCooler_price(rs.getInt("cooler_price"));
				cl.setCooler_power(rs.getInt("cooler_power"));
				cl.setCooler_maker(rs.getString("cooler_maker"));
				cl.setCooler_fans(rs.getInt("cooler_fans"));
				cl.setCooler_conector(rs.getInt("cooler_conector"));
				cl.setCooler_img(rs.getString("cooler_img"));
				cl.setCooler_width(rs.getInt("cooler_width"));
				cl.setCooler_height(rs.getInt("cooler_height"));
				cl.setCooler_depth(rs.getInt("cooler_depth"));
				cl.setCooler_id(rs.getInt("cooler_id"));
				cl.setCooler_recid(rs.getInt("cooler_recid"));
				ar.add(cl);
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return ar;
	}
}
