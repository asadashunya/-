package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.MotherBoard;

public class MotherBoardDao {
	private Connection con = null;
	public MotherBoardDao() {
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
	
	public ArrayList<MotherBoard> findAll(){
		ArrayList<MotherBoard> ar = new ArrayList<>();
		String sql = "select * from motherboard";
		try {
			PreparedStatement state = con.prepareStatement(sql);
			ResultSet rs = state.executeQuery();
			while(rs.next()) {
				MotherBoard mb = new MotherBoard();
				mb.setMotherboard_factor(rs.getString("motherboard_factor"));
				mb.setMotherboard_chipset(rs.getString("motherboard_chipset"));
				mb.setMotherboard_name(rs.getString("motherboard_name"));
				mb.setMotherboard_socket(rs.getString("motherboard_socket"));
				mb.setMotherboard_memory_slot(rs.getInt("motherboard_memory_slot"));
				mb.setMotherboard_memory_size(rs.getInt("motherboard_memory_size"));
				mb.setMotherboard_socket_size(rs.getInt("motherboard_socket_size"));
				mb.setMotherboard_ssd_standard(rs.getString("motherboard_ssd_standard"));
				mb.setMotherboard_price(rs.getInt("motherboard_price"));
				mb.setMotherboard_width(rs.getInt("motherboard_width"));
				mb.setMotherboard_depth(rs.getInt("motherboard_depth"));
				mb.setMotherboard_img(rs.getString("motherboard_img"));
				mb.setMotherboard_maker(rs.getString("motherboard_maker"));
				ar.add(mb);
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
		return ar;
	}
	
	public ArrayList<MotherBoard> findMotherBoardByName(String motherboard_name) {
	    ArrayList<MotherBoard> motherboardList = new ArrayList<>();
	    String sql = "select * from motherboard where motherboard_name like ?";
	    try {
	        PreparedStatement state = con.prepareStatement(sql);
	        state.setString(1, "%" + motherboard_name + "%");
	        ResultSet rs = state.executeQuery();

	        while (rs.next()) {
	        	MotherBoard mb = new MotherBoard();
				mb.setMotherboard_factor(rs.getString("motherboard_factor"));
				mb.setMotherboard_chipset(rs.getString("motherboard_chipset"));
				mb.setMotherboard_name(rs.getString("motherboard_name"));
				mb.setMotherboard_socket(rs.getString("motherboard_socket"));
				mb.setMotherboard_memory_slot(rs.getInt("motherboard_memory_slot"));
				mb.setMotherboard_memory_size(rs.getInt("motherboard_memory_size"));
				mb.setMotherboard_socket_size(rs.getInt("motherboard_socket_size"));
				mb.setMotherboard_ssd_standard(rs.getString("motherboard_ssd_standard"));
				mb.setMotherboard_price(rs.getInt("motherboard_price"));
				mb.setMotherboard_width(rs.getInt("motherboard_width"));
				mb.setMotherboard_depth(rs.getInt("motherboard_depth"));
				mb.setMotherboard_img(rs.getString("motherboard_img"));
				mb.setMotherboard_maker(rs.getString("motherboard_maker"));
				motherboardList.add(mb);
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return motherboardList;
	}
	
	public ArrayList<MotherBoard> findPerMotherBoardByName(String motherboard_name) {
	    ArrayList<MotherBoard> motherboardList = new ArrayList<>();
	    String sql = "select * from motherboard where motherboard_name = ?";
	    try {
	        PreparedStatement state = con.prepareStatement(sql);
	        state.setString(1, motherboard_name);
	        ResultSet rs = state.executeQuery();

	        while (rs.next()) {
	        	MotherBoard mb = new MotherBoard();
				mb.setMotherboard_factor(rs.getString("motherboard_factor"));
				mb.setMotherboard_chipset(rs.getString("motherboard_chipset"));
				mb.setMotherboard_name(rs.getString("motherboard_name"));
				mb.setMotherboard_socket(rs.getString("motherboard_socket"));
				mb.setMotherboard_memory_slot(rs.getInt("motherboard_memory_slot"));
				mb.setMotherboard_memory_size(rs.getInt("motherboard_memory_size"));
				mb.setMotherboard_socket_size(rs.getInt("motherboard_socket_size"));
				mb.setMotherboard_ssd_standard(rs.getString("motherboard_ssd_standard"));
				mb.setMotherboard_price(rs.getInt("motherboard_price"));
				mb.setMotherboard_width(rs.getInt("motherboard_width"));
				mb.setMotherboard_depth(rs.getInt("motherboard_depth"));
				mb.setMotherboard_img(rs.getString("motherboard_img"));
				mb.setMotherboard_maker(rs.getString("motherboard_maker"));
				motherboardList.add(mb);
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return motherboardList;
	}
	
	public ArrayList<MotherBoard> findAllSortedByPopularity() {
	    ArrayList<MotherBoard> ar = new ArrayList<>();
	    String sql = "SELECT * FROM motherboard ORDER BY motherboard_recid ASC";
	    try {
	        PreparedStatement state = con.prepareStatement(sql);
	        ResultSet rs = state.executeQuery();
	        while(rs.next()) {
	        	MotherBoard mb = new MotherBoard();
				mb.setMotherboard_factor(rs.getString("motherboard_factor"));
				mb.setMotherboard_chipset(rs.getString("motherboard_chipset"));
				mb.setMotherboard_name(rs.getString("motherboard_name"));
				mb.setMotherboard_socket(rs.getString("motherboard_socket"));
				mb.setMotherboard_memory_slot(rs.getInt("motherboard_memory_slot"));
				mb.setMotherboard_memory_size(rs.getInt("motherboard_memory_size"));
				mb.setMotherboard_socket_size(rs.getInt("motherboard_socket_size"));
				mb.setMotherboard_ssd_standard(rs.getString("motherboard_ssd_standard"));
				mb.setMotherboard_price(rs.getInt("motherboard_price"));
				mb.setMotherboard_width(rs.getInt("motherboard_width"));
				mb.setMotherboard_depth(rs.getInt("motherboard_depth"));
				mb.setMotherboard_img(rs.getString("motherboard_img"));
				mb.setMotherboard_maker(rs.getString("motherboard_maker"));
				ar.add(mb);
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return ar;
	}
	
	public ArrayList<MotherBoard> findAllSortedByHighPrice() {
	    ArrayList<MotherBoard> ar = new ArrayList<>();
	    String sql = "SELECT * FROM motherboard ORDER BY motherboard_price DESC";
	    try {
	        PreparedStatement state = con.prepareStatement(sql);
	        ResultSet rs = state.executeQuery();
	        while(rs.next()) {
	        	MotherBoard mb = new MotherBoard();
				mb.setMotherboard_factor(rs.getString("motherboard_factor"));
				mb.setMotherboard_chipset(rs.getString("motherboard_chipset"));
				mb.setMotherboard_name(rs.getString("motherboard_name"));
				mb.setMotherboard_socket(rs.getString("motherboard_socket"));
				mb.setMotherboard_memory_slot(rs.getInt("motherboard_memory_slot"));
				mb.setMotherboard_memory_size(rs.getInt("motherboard_memory_size"));
				mb.setMotherboard_socket_size(rs.getInt("motherboard_socket_size"));
				mb.setMotherboard_ssd_standard(rs.getString("motherboard_ssd_standard"));
				mb.setMotherboard_price(rs.getInt("motherboard_price"));
				mb.setMotherboard_width(rs.getInt("motherboard_width"));
				mb.setMotherboard_depth(rs.getInt("motherboard_depth"));
				mb.setMotherboard_img(rs.getString("motherboard_img"));
				mb.setMotherboard_maker(rs.getString("motherboard_maker"));
				ar.add(mb);
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return ar;
	}

	public ArrayList<MotherBoard> findAllSortedByLowPrice() {
	    ArrayList<MotherBoard> ar = new ArrayList<>();
	    String sql = "SELECT * FROM motherboard ORDER BY motherboard_price ASC";
	    try {
	        PreparedStatement state = con.prepareStatement(sql);
	        ResultSet rs = state.executeQuery();
	        while(rs.next()) {
	        	MotherBoard mb = new MotherBoard();
				mb.setMotherboard_factor(rs.getString("motherboard_factor"));
				mb.setMotherboard_chipset(rs.getString("motherboard_chipset"));
				mb.setMotherboard_name(rs.getString("motherboard_name"));
				mb.setMotherboard_socket(rs.getString("motherboard_socket"));
				mb.setMotherboard_memory_slot(rs.getInt("motherboard_memory_slot"));
				mb.setMotherboard_memory_size(rs.getInt("motherboard_memory_size"));
				mb.setMotherboard_socket_size(rs.getInt("motherboard_socket_size"));
				mb.setMotherboard_ssd_standard(rs.getString("motherboard_ssd_standard"));
				mb.setMotherboard_price(rs.getInt("motherboard_price"));
				mb.setMotherboard_width(rs.getInt("motherboard_width"));
				mb.setMotherboard_depth(rs.getInt("motherboard_depth"));
				mb.setMotherboard_img(rs.getString("motherboard_img"));
				mb.setMotherboard_maker(rs.getString("motherboard_maker"));
				ar.add(mb);
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return ar;
	}
}
