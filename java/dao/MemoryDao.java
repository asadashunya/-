package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Memory;

public class MemoryDao {
	private Connection con = null;
	public MemoryDao() {
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
	
	public ArrayList<Memory> findAll(){
		ArrayList<Memory> ar = new ArrayList<>();
		String sql = "select * from memory";
		try {
			PreparedStatement state = con.prepareStatement(sql);
			ResultSet rs = state.executeQuery();
			while(rs.next()) {
				Memory memo = new Memory();
				memo.setMemory_name(rs.getString("memory_name"));
				memo.setMemory_size(rs.getInt("memory_size"));
				memo.setMemory_standard(rs.getString("memory_standard"));
				memo.setMemory_volt(rs.getInt("memory_volt"));
				memo.setMemory_price(rs.getInt("memory_price"));
				memo.setMemory_maker(rs.getString("memory_maker"));
				memo.setMemory_num(rs.getInt("memory_num"));
				memo.setMemory_img(rs.getString("memory_img"));
				memo.setMemory_id(rs.getInt("memory_id"));
				memo.setMemory_recid(rs.getInt("memory_recid"));
				ar.add(memo);
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
		return ar;
	}
	public ArrayList<Memory> findMemoryByName(String memory_name) {
	    ArrayList<Memory> memoryList = new ArrayList<>();
	    String sql = "select * from memory where memory_name like ?";
	    try {
	        PreparedStatement state = con.prepareStatement(sql);
	        state.setString(1, "%" + memory_name + "%");
	        ResultSet rs = state.executeQuery();

	        while (rs.next()) {
	        	Memory memo = new Memory();
				memo.setMemory_name(rs.getString("memory_name"));
				memo.setMemory_size(rs.getInt("memory_size"));
				memo.setMemory_standard(rs.getString("memory_standard"));
				memo.setMemory_volt(rs.getInt("memory_volt"));
				memo.setMemory_price(rs.getInt("memory_price"));
				memo.setMemory_maker(rs.getString("memory_maker"));
				memo.setMemory_num(rs.getInt("memory_num"));
				memo.setMemory_img(rs.getString("memory_img"));
				memo.setMemory_id(rs.getInt("memory_id"));
				memo.setMemory_recid(rs.getInt("memory_recid"));
				memoryList.add(memo);
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return memoryList;
	}
	
	public ArrayList<Memory> findPerMemoryByName(String memory_name) {
	    ArrayList<Memory> memoryList = new ArrayList<>();
	    String sql = "select * from memory where memory_name = ?";
	    try {
	        PreparedStatement state = con.prepareStatement(sql);
	        state.setString(1, memory_name);
	        ResultSet rs = state.executeQuery();

	        while (rs.next()) {
	        	Memory memo = new Memory();
				memo.setMemory_name(rs.getString("memory_name"));
				memo.setMemory_size(rs.getInt("memory_size"));
				memo.setMemory_standard(rs.getString("memory_standard"));
				memo.setMemory_volt(rs.getInt("memory_volt"));
				memo.setMemory_price(rs.getInt("memory_price"));
				memo.setMemory_maker(rs.getString("memory_maker"));
				memo.setMemory_num(rs.getInt("memory_num"));
				memo.setMemory_img(rs.getString("memory_img"));
				memo.setMemory_id(rs.getInt("memory_id"));
				memo.setMemory_recid(rs.getInt("memory_recid"));
				memoryList.add(memo);
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return memoryList;
	}
	
	public ArrayList<Memory> findAllSortedByPopularity() {
	    ArrayList<Memory> ar = new ArrayList<>();
	    String sql = "SELECT * FROM memory ORDER BY memory_recid ASC";
	    try {
	        PreparedStatement state = con.prepareStatement(sql);
	        ResultSet rs = state.executeQuery();
	        while(rs.next()) {
	        	Memory memo = new Memory();
				memo.setMemory_name(rs.getString("memory_name"));
				memo.setMemory_size(rs.getInt("memory_size"));
				memo.setMemory_standard(rs.getString("memory_standard"));
				memo.setMemory_volt(rs.getInt("memory_volt"));
				memo.setMemory_price(rs.getInt("memory_price"));
				memo.setMemory_maker(rs.getString("memory_maker"));
				memo.setMemory_num(rs.getInt("memory_num"));
				memo.setMemory_img(rs.getString("memory_img"));
				memo.setMemory_id(rs.getInt("memory_id"));
				memo.setMemory_recid(rs.getInt("memory_recid"));
				ar.add(memo);
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return ar;
	}
	
	public ArrayList<Memory> findAllSortedByHighPrice() {
	    ArrayList<Memory> ar = new ArrayList<>();
	    String sql = "SELECT * FROM memory ORDER BY memory_price DESC";
	    try {
	        PreparedStatement state = con.prepareStatement(sql);
	        ResultSet rs = state.executeQuery();
	        while(rs.next()) {
	        	Memory memo = new Memory();
				memo.setMemory_name(rs.getString("memory_name"));
				memo.setMemory_size(rs.getInt("memory_size"));
				memo.setMemory_standard(rs.getString("memory_standard"));
				memo.setMemory_volt(rs.getInt("memory_volt"));
				memo.setMemory_price(rs.getInt("memory_price"));
				memo.setMemory_maker(rs.getString("memory_maker"));
				memo.setMemory_num(rs.getInt("memory_num"));
				memo.setMemory_img(rs.getString("memory_img"));
				memo.setMemory_id(rs.getInt("memory_id"));
				memo.setMemory_recid(rs.getInt("memory_recid"));
				ar.add(memo);
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return ar;
	}

	public ArrayList<Memory> findAllSortedByLowPrice() {
	    ArrayList<Memory> ar = new ArrayList<>();
	    String sql = "SELECT * FROM graphic_board ORDER BY graphic_price ASC";
	    try {
	        PreparedStatement state = con.prepareStatement(sql);
	        ResultSet rs = state.executeQuery();
	        while(rs.next()) {
	        	Memory memo = new Memory();
				memo.setMemory_name(rs.getString("memory_name"));
				memo.setMemory_size(rs.getInt("memory_size"));
				memo.setMemory_standard(rs.getString("memory_standard"));
				memo.setMemory_volt(rs.getInt("memory_volt"));
				memo.setMemory_price(rs.getInt("memory_price"));
				memo.setMemory_maker(rs.getString("memory_maker"));
				memo.setMemory_num(rs.getInt("memory_num"));
				memo.setMemory_img(rs.getString("memory_img"));
				memo.setMemory_id(rs.getInt("memory_id"));
				memo.setMemory_recid(rs.getInt("memory_recid"));
				ar.add(memo);
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return ar;
	}
}