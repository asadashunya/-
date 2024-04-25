package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Graphic_board;

public class Graphic_boardDao {
	private Connection con = null;
	public Graphic_boardDao() {
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
	
	public ArrayList<Graphic_board> findAll(){
		ArrayList<Graphic_board> ar = new ArrayList<>();
		String sql = "select * from graphic_board";
		try {
			PreparedStatement state = con.prepareStatement(sql);
			ResultSet rs = state.executeQuery();
			while(rs.next()) {
				Graphic_board gb = new Graphic_board();
				gb.setGraphic_name(rs.getString("graphic_name"));
				gb.setGraphic_chip(rs.getString("graphic_chip"));
				gb.setGraphic_memory(rs.getString("graphic_memory"));
				gb.setGraphic_monitor(rs.getString("graphic_monitor"));
				gb.setGraphic_cool(rs.getString("graphic_cool"));
				gb.setGraphic_clock(rs.getInt("graphic_clock"));
				gb.setGraphic_price(rs.getInt("graphic_price"));
				gb.setGraphic_power(rs.getInt("graphic_power"));
				gb.setGraphic_maker(rs.getString("graphic_maker"));
				gb.setGraphic_img(rs.getString("graphic_img"));
				gb.setGraphic_id(rs.getInt("graphic_id"));
				gb.setGraphic_recid(rs.getInt("graphic_recid"));
				ar.add(gb);
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
		return ar;
	}
	
	public ArrayList<Graphic_board> findGraphic_boardByName(String graphic_name) {
	    ArrayList<Graphic_board> graphicList = new ArrayList<>();
	    String sql = "select * from graphic_board where graphic_name like ?";
	    try {
	        PreparedStatement state = con.prepareStatement(sql);
	        state.setString(1, "%" + graphic_name + "%");
	        ResultSet rs = state.executeQuery();

	        while (rs.next()) {
	        	Graphic_board gb = new Graphic_board();
				gb.setGraphic_name(rs.getString("graphic_name"));
				gb.setGraphic_chip(rs.getString("graphic_chip"));
				gb.setGraphic_memory(rs.getString("graphic_memory"));
				gb.setGraphic_monitor(rs.getString("graphic_monitor"));
				gb.setGraphic_cool(rs.getString("graphic_cool"));
				gb.setGraphic_clock(rs.getInt("graphic_clock"));
				gb.setGraphic_price(rs.getInt("graphic_price"));
				gb.setGraphic_power(rs.getInt("graphic_power"));
				gb.setGraphic_maker(rs.getString("graphic_maker"));
				gb.setGraphic_img(rs.getString("graphic_img"));
				gb.setGraphic_id(rs.getInt("graphic_id"));
				gb.setGraphic_recid(rs.getInt("graphic_recid"));
				graphicList.add(gb);
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return graphicList;
	}
	
	public ArrayList<Graphic_board> findPerGraphic_boardByName(String graphic_name) {
	    ArrayList<Graphic_board> graphicList = new ArrayList<>();
	    String sql = "select * from graphic_board where graphic_name = ?";
	    try {
	        PreparedStatement state = con.prepareStatement(sql);
	        state.setString(1, graphic_name);
	        ResultSet rs = state.executeQuery();

	        while (rs.next()) {
	        	Graphic_board gb = new Graphic_board();
				gb.setGraphic_name(rs.getString("graphic_name"));
				gb.setGraphic_chip(rs.getString("graphic_chip"));
				gb.setGraphic_memory(rs.getString("graphic_memory"));
				gb.setGraphic_monitor(rs.getString("graphic_monitor"));
				gb.setGraphic_cool(rs.getString("graphic_cool"));
				gb.setGraphic_clock(rs.getInt("graphic_clock"));
				gb.setGraphic_price(rs.getInt("graphic_price"));
				gb.setGraphic_power(rs.getInt("graphic_power"));
				gb.setGraphic_maker(rs.getString("graphic_maker"));
				gb.setGraphic_img(rs.getString("graphic_img"));
				gb.setGraphic_id(rs.getInt("graphic_id"));
				gb.setGraphic_recid(rs.getInt("graphic_recid"));
				graphicList.add(gb);
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return graphicList;
	}
	
	public ArrayList<Graphic_board> findAllSortedByPopularity() {
	    ArrayList<Graphic_board> ar = new ArrayList<>();
	    String sql = "SELECT * FROM graphic_board ORDER BY graphic_recid ASC";
	    try {
	        PreparedStatement state = con.prepareStatement(sql);
	        ResultSet rs = state.executeQuery();
	        while(rs.next()) {
	        	Graphic_board gb = new Graphic_board();
				gb.setGraphic_name(rs.getString("graphic_name"));
				gb.setGraphic_chip(rs.getString("graphic_chip"));
				gb.setGraphic_memory(rs.getString("graphic_memory"));
				gb.setGraphic_monitor(rs.getString("graphic_monitor"));
				gb.setGraphic_cool(rs.getString("graphic_cool"));
				gb.setGraphic_clock(rs.getInt("graphic_clock"));
				gb.setGraphic_price(rs.getInt("graphic_price"));
				gb.setGraphic_power(rs.getInt("graphic_power"));
				gb.setGraphic_maker(rs.getString("graphic_maker"));
				gb.setGraphic_img(rs.getString("graphic_img"));
				gb.setGraphic_id(rs.getInt("graphic_id"));
				gb.setGraphic_recid(rs.getInt("graphic_recid"));
				ar.add(gb);
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return ar;
	}
	
	public ArrayList<Graphic_board> findAllSortedByHighPrice() {
	    ArrayList<Graphic_board> ar = new ArrayList<>();
	    String sql = "SELECT * FROM graphic_board ORDER BY graphic_price DESC";
	    try {
	        PreparedStatement state = con.prepareStatement(sql);
	        ResultSet rs = state.executeQuery();
	        while(rs.next()) {
	        	Graphic_board gb = new Graphic_board();
				gb.setGraphic_name(rs.getString("graphic_name"));
				gb.setGraphic_chip(rs.getString("graphic_chip"));
				gb.setGraphic_memory(rs.getString("graphic_memory"));
				gb.setGraphic_monitor(rs.getString("graphic_monitor"));
				gb.setGraphic_cool(rs.getString("graphic_cool"));
				gb.setGraphic_clock(rs.getInt("graphic_clock"));
				gb.setGraphic_price(rs.getInt("graphic_price"));
				gb.setGraphic_power(rs.getInt("graphic_power"));
				gb.setGraphic_maker(rs.getString("graphic_maker"));
				gb.setGraphic_img(rs.getString("graphic_img"));
				gb.setGraphic_id(rs.getInt("graphic_id"));
				gb.setGraphic_recid(rs.getInt("graphic_recid"));
				ar.add(gb);
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return ar;
	}

	public ArrayList<Graphic_board> findAllSortedByLowPrice() {
	    ArrayList<Graphic_board> ar = new ArrayList<>();
	    String sql = "SELECT * FROM graphic_board ORDER BY graphic_price ASC";
	    try {
	        PreparedStatement state = con.prepareStatement(sql);
	        ResultSet rs = state.executeQuery();
	        while(rs.next()) {
	        	Graphic_board gb = new Graphic_board();
				gb.setGraphic_name(rs.getString("graphic_name"));
				gb.setGraphic_chip(rs.getString("graphic_chip"));
				gb.setGraphic_memory(rs.getString("graphic_memory"));
				gb.setGraphic_monitor(rs.getString("graphic_monitor"));
				gb.setGraphic_cool(rs.getString("graphic_cool"));
				gb.setGraphic_clock(rs.getInt("graphic_clock"));
				gb.setGraphic_price(rs.getInt("graphic_price"));
				gb.setGraphic_power(rs.getInt("graphic_power"));
				gb.setGraphic_maker(rs.getString("graphic_maker"));
				gb.setGraphic_img(rs.getString("graphic_img"));
				gb.setGraphic_id(rs.getInt("graphic_id"));
				gb.setGraphic_recid(rs.getInt("graphic_recid"));
				ar.add(gb);
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return ar;
	}
}
