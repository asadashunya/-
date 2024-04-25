package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Power;

public class PowerDao {
	private Connection con = null;
	public PowerDao() {
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
	
	public ArrayList<Power> findAll(){
		ArrayList<Power> ar = new ArrayList<>();
		String sql = "select * from power";
		try {
			PreparedStatement state = con.prepareStatement(sql);
			ResultSet rs = state.executeQuery();
			while(rs.next()) {
				Power power = new Power();
				power.setPower_name(rs.getString("power_name"));
				power.setPower_socket(rs.getString("power_socket"));
				power.setPower_capacity(rs.getInt("power_capacity"));
				power.setPower_price(rs.getInt("power_price"));
				power.setPower_plug(rs.getString("power_plug"));
				power.setPower_80plus(rs.getString("power_80plus"));
				power.setPower_maker(rs.getString("power_maker"));
				power.setPower_img(rs.getString("power_img"));
				power.setPower_width(rs.getInt("power_width"));
				power.setPower_height(rs.getInt("power_height"));
				power.setPower_depth(rs.getInt("power_depth"));
				power.setPower_id(rs.getInt("power_id"));
				power.setPower_recid(rs.getInt("power_recid"));
				ar.add(power);
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
		return ar;
	}
	
	public ArrayList<Power> findPowerByName(String power_name) {
	    ArrayList<Power> powerList = new ArrayList<>();
	    String sql = "select * from power where power_name like ?";
	    try {
	        PreparedStatement state = con.prepareStatement(sql);
	        state.setString(1, "%" + power_name + "%");
	        ResultSet rs = state.executeQuery();

	        while (rs.next()) {
	        	Power power = new Power();
				power.setPower_name(rs.getString("power_name"));
				power.setPower_socket(rs.getString("power_socket"));
				power.setPower_capacity(rs.getInt("power_capacity"));
				power.setPower_price(rs.getInt("power_price"));
				power.setPower_plug(rs.getString("power_plug"));
				power.setPower_80plus(rs.getString("power_80plus"));
				power.setPower_maker(rs.getString("power_maker"));
				power.setPower_img(rs.getString("power_img"));
				power.setPower_width(rs.getInt("power_width"));
				power.setPower_height(rs.getInt("power_height"));
				power.setPower_depth(rs.getInt("power_depth"));
				power.setPower_id(rs.getInt("power_id"));
				power.setPower_recid(rs.getInt("power_recid"));
				powerList.add(power);
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return powerList;
	}
	
	public ArrayList<Power> findPerPowerByName(String power_name) {
	    ArrayList<Power> powerList = new ArrayList<>();
	    String sql = "select * from power where power_name = ?";
	    try {
	        PreparedStatement state = con.prepareStatement(sql);
	        state.setString(1, power_name);
	        ResultSet rs = state.executeQuery();

	        while (rs.next()) {
	        	Power power = new Power();
				power.setPower_name(rs.getString("power_name"));
				power.setPower_socket(rs.getString("power_socket"));
				power.setPower_capacity(rs.getInt("power_capacity"));
				power.setPower_price(rs.getInt("power_price"));
				power.setPower_plug(rs.getString("power_plug"));
				power.setPower_80plus(rs.getString("power_80plus"));
				power.setPower_maker(rs.getString("power_maker"));
				power.setPower_img(rs.getString("power_img"));
				power.setPower_width(rs.getInt("power_width"));
				power.setPower_height(rs.getInt("power_height"));
				power.setPower_depth(rs.getInt("power_depth"));
				power.setPower_id(rs.getInt("power_id"));
				power.setPower_recid(rs.getInt("power_recid"));
				powerList.add(power);
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return powerList;
	}
	
	public ArrayList<Power> findAllSortedByPopularity() {
	    ArrayList<Power> ar = new ArrayList<>();
	    String sql = "SELECT * FROM power ORDER BY power_recid ASC";
	    try {
	        PreparedStatement state = con.prepareStatement(sql);
	        ResultSet rs = state.executeQuery();
	        while(rs.next()) {
	        	Power power = new Power();
				power.setPower_name(rs.getString("power_name"));
				power.setPower_socket(rs.getString("power_socket"));
				power.setPower_capacity(rs.getInt("power_capacity"));
				power.setPower_price(rs.getInt("power_price"));
				power.setPower_plug(rs.getString("power_plug"));
				power.setPower_80plus(rs.getString("power_80plus"));
				power.setPower_maker(rs.getString("power_maker"));
				power.setPower_img(rs.getString("power_img"));
				power.setPower_width(rs.getInt("power_width"));
				power.setPower_height(rs.getInt("power_height"));
				power.setPower_depth(rs.getInt("power_depth"));
				power.setPower_id(rs.getInt("power_id"));
				power.setPower_recid(rs.getInt("power_recid"));
				ar.add(power);
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return ar;
	}
	
	public ArrayList<Power> findAllSortedByHighPrice() {
	    ArrayList<Power> ar = new ArrayList<>();
	    String sql = "SELECT * FROM power ORDER BY power_price DESC";
	    try {
	        PreparedStatement state = con.prepareStatement(sql);
	        ResultSet rs = state.executeQuery();
	        while(rs.next()) {
	        	Power power = new Power();
				power.setPower_name(rs.getString("power_name"));
				power.setPower_socket(rs.getString("power_socket"));
				power.setPower_capacity(rs.getInt("power_capacity"));
				power.setPower_price(rs.getInt("power_price"));
				power.setPower_plug(rs.getString("power_plug"));
				power.setPower_80plus(rs.getString("power_80plus"));
				power.setPower_maker(rs.getString("power_maker"));
				power.setPower_img(rs.getString("power_img"));
				power.setPower_width(rs.getInt("power_width"));
				power.setPower_height(rs.getInt("power_height"));
				power.setPower_depth(rs.getInt("power_depth"));
				power.setPower_id(rs.getInt("power_id"));
				power.setPower_recid(rs.getInt("power_recid"));
				ar.add(power);
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return ar;
	}

	public ArrayList<Power> findAllSortedByLowPrice() {
	    ArrayList<Power> ar = new ArrayList<>();
	    String sql = "SELECT * FROM power ORDER BY power_price ASC";
	    try {
	        PreparedStatement state = con.prepareStatement(sql);
	        ResultSet rs = state.executeQuery();
	        while(rs.next()) {
	        	Power power = new Power();
				power.setPower_name(rs.getString("power_name"));
				power.setPower_socket(rs.getString("power_socket"));
				power.setPower_capacity(rs.getInt("power_capacity"));
				power.setPower_price(rs.getInt("power_price"));
				power.setPower_plug(rs.getString("power_plug"));
				power.setPower_80plus(rs.getString("power_80plus"));
				power.setPower_maker(rs.getString("power_maker"));
				power.setPower_img(rs.getString("power_img"));
				power.setPower_width(rs.getInt("power_width"));
				power.setPower_height(rs.getInt("power_height"));
				power.setPower_depth(rs.getInt("power_depth"));
				power.setPower_id(rs.getInt("power_id"));
				power.setPower_recid(rs.getInt("power_recid"));
				ar.add(power);
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return ar;
	}
}
