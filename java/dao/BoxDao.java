package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Box;

public class BoxDao {
	private Connection con = null;
	public BoxDao() {
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
	
	public ArrayList<Box> findAll(){
		ArrayList<Box> ar = new ArrayList<>();
		String sql = "select * from box";
		try {
			PreparedStatement state = con.prepareStatement(sql);
			ResultSet rs = state.executeQuery();
			while(rs.next()) {
				Box box = new Box();
				box.setBox_name(rs.getString("box_name"));
				box.setBox_size(rs.getString("box_size"));
				box.setBox_water(rs.getString("box_water"));
				box.setBox_mother(rs.getString("box_mother"));
				box.setBox_cpu(rs.getInt("box_cpu"));
				box.setBox_graphic(rs.getInt("box_graphic"));
				box.setBox_power(rs.getInt("box_power"));
				box.setBox_price(rs.getInt("box_price"));
				box.setBox_maker(rs.getString("box_maker"));
				box.setBox_img(rs.getString("box_img"));
				box.setBox_id(rs.getInt("box_id"));
				box.setBox_recid(rs.getInt("box_recid"));
				ar.add(box);
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
		return ar;
	}
	
	public ArrayList<Box> findBoxByName(String box_name) {
	    ArrayList<Box> boxList = new ArrayList<>();
	    String sql = "select * from box where box_name like ?";
	    try {
	        PreparedStatement state = con.prepareStatement(sql);
	        state.setString(1, "%" + box_name + "%");
	        ResultSet rs = state.executeQuery();

	        while (rs.next()) {
	        	Box box = new Box();
				box.setBox_name(rs.getString("box_name"));
				box.setBox_size(rs.getString("box_size"));
				box.setBox_water(rs.getString("box_water"));
				box.setBox_mother(rs.getString("box_mother"));
				box.setBox_cpu(rs.getInt("box_cpu"));
				box.setBox_graphic(rs.getInt("box_graphic"));
				box.setBox_power(rs.getInt("box_power"));
				box.setBox_price(rs.getInt("box_price"));
				box.setBox_maker(rs.getString("box_maker"));
				box.setBox_img(rs.getString("box_img"));
				box.setBox_id(rs.getInt("box_id"));
				box.setBox_recid(rs.getInt("box_recid"));
				boxList.add(box);
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return boxList;
	}
	
	public ArrayList<Box> findPerBoxByName(String box_name) {
	    ArrayList<Box> boxList = new ArrayList<>();
	    String sql = "select * from box where box_name = ?";
	    try {
	        PreparedStatement state = con.prepareStatement(sql);
	        state.setString(1, box_name);
	        ResultSet rs = state.executeQuery();

	        while (rs.next()) {
	        	Box box = new Box();
				box.setBox_name(rs.getString("box_name"));
				box.setBox_size(rs.getString("box_size"));
				box.setBox_water(rs.getString("box_water"));
				box.setBox_mother(rs.getString("box_mother"));
				box.setBox_cpu(rs.getInt("box_cpu"));
				box.setBox_graphic(rs.getInt("box_graphic"));
				box.setBox_power(rs.getInt("box_power"));
				box.setBox_price(rs.getInt("box_price"));
				box.setBox_maker(rs.getString("box_maker"));
				box.setBox_img(rs.getString("box_img"));
				box.setBox_id(rs.getInt("box_id"));
				box.setBox_recid(rs.getInt("box_recid"));
				boxList.add(box);
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return boxList;
	}
	
	public ArrayList<Box> findAllSortedByPopularity() {
	    ArrayList<Box> ar = new ArrayList<>();
	    String sql = "SELECT * FROM box ORDER BY box_recid ASC";
	    try {
	        PreparedStatement state = con.prepareStatement(sql);
	        ResultSet rs = state.executeQuery();
	        while(rs.next()) {
	        	Box box = new Box();
				box.setBox_name(rs.getString("box_name"));
				box.setBox_size(rs.getString("box_size"));
				box.setBox_water(rs.getString("box_water"));
				box.setBox_mother(rs.getString("box_mother"));
				box.setBox_cpu(rs.getInt("box_cpu"));
				box.setBox_graphic(rs.getInt("box_graphic"));
				box.setBox_power(rs.getInt("box_power"));
				box.setBox_price(rs.getInt("box_price"));
				box.setBox_maker(rs.getString("box_maker"));
				box.setBox_img(rs.getString("box_img"));
				box.setBox_id(rs.getInt("box_id"));
				box.setBox_recid(rs.getInt("box_recid"));
				ar.add(box);
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return ar;
	}
	
	public ArrayList<Box> findAllSortedByHighPrice() {
	    ArrayList<Box> ar = new ArrayList<>();
	    String sql = "SELECT * FROM box ORDER BY box_price DESC";
	    try {
	        PreparedStatement state = con.prepareStatement(sql);
	        ResultSet rs = state.executeQuery();
	        while(rs.next()) {
	        	Box box = new Box();
				box.setBox_name(rs.getString("box_name"));
				box.setBox_size(rs.getString("box_size"));
				box.setBox_water(rs.getString("box_water"));
				box.setBox_mother(rs.getString("box_mother"));
				box.setBox_cpu(rs.getInt("box_cpu"));
				box.setBox_graphic(rs.getInt("box_graphic"));
				box.setBox_power(rs.getInt("box_power"));
				box.setBox_price(rs.getInt("box_price"));
				box.setBox_maker(rs.getString("box_maker"));
				box.setBox_img(rs.getString("box_img"));
				box.setBox_id(rs.getInt("box_id"));
				box.setBox_recid(rs.getInt("box_recid"));
				ar.add(box);
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return ar;
	}

	public ArrayList<Box> findAllSortedByLowPrice() {
	    ArrayList<Box> ar = new ArrayList<>();
	    String sql = "SELECT * FROM box ORDER BY box_price ASC";
	    try {
	        PreparedStatement state = con.prepareStatement(sql);
	        ResultSet rs = state.executeQuery();
	        while(rs.next()) {
	        	Box box = new Box();
				box.setBox_name(rs.getString("box_name"));
				box.setBox_size(rs.getString("box_size"));
				box.setBox_water(rs.getString("box_water"));
				box.setBox_mother(rs.getString("box_mother"));
				box.setBox_cpu(rs.getInt("box_cpu"));
				box.setBox_graphic(rs.getInt("box_graphic"));
				box.setBox_power(rs.getInt("box_power"));
				box.setBox_price(rs.getInt("box_price"));
				box.setBox_maker(rs.getString("box_maker"));
				box.setBox_img(rs.getString("box_img"));
				box.setBox_id(rs.getInt("box_id"));
				box.setBox_recid(rs.getInt("box_recid"));
				ar.add(box);
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return ar;
	}
}
