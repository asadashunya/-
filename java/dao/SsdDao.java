package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Ssd;

public class SsdDao {
	private Connection con = null;
	public SsdDao() {
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
	
	public ArrayList<Ssd> findAll(){
		ArrayList<Ssd> ar = new ArrayList<>();
		String sql = "select * from ssd";
		try {
			PreparedStatement state = con.prepareStatement(sql);
			ResultSet rs = state.executeQuery();
			while(rs.next()) {
				Ssd ssd = new Ssd();
				ssd.setSsd_name(rs.getString("ssd_name"));
				ssd.setSsd_capacity(rs.getInt("ssd_capacity"));
				ssd.setSsd_standard(rs.getString("ssd_standard"));
				ssd.setSsd_interface(rs.getString("ssd_interface"));
				ssd.setSsd_price(rs.getInt("ssd_price"));
				ssd.setSsd_power(rs.getInt("ssd_power"));
				ssd.setSsd_maker(rs.getString("ssd_maker"));
				ssd.setSsd_load(rs.getInt("ssd_load"));
				ssd.setSsd_write(rs.getInt("ssd_write"));
				ssd.setSsd_img(rs.getString("ssd_img"));
				ssd.setSsd_id(rs.getInt("ssd_id"));
				ssd.setSsd_recid(rs.getInt("ssd_recid"));
				ar.add(ssd);
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
		return ar;
	}
	
	public ArrayList<Ssd> findSsdByName(String ssd_name) {
	    ArrayList<Ssd> ssdList = new ArrayList<>();
	    String sql = "select * from ssd where ssd_name like ?";
	    try {
	        PreparedStatement state = con.prepareStatement(sql);
	        state.setString(1, "%" + ssd_name + "%");
	        ResultSet rs = state.executeQuery();

	        while (rs.next()) {
	        	Ssd ssd = new Ssd();
				ssd.setSsd_name(rs.getString("ssd_name"));
				ssd.setSsd_capacity(rs.getInt("ssd_capacity"));
				ssd.setSsd_standard(rs.getString("ssd_standard"));
				ssd.setSsd_interface(rs.getString("ssd_interface"));
				ssd.setSsd_price(rs.getInt("ssd_price"));
				ssd.setSsd_power(rs.getInt("ssd_power"));
				ssd.setSsd_maker(rs.getString("ssd_maker"));
				ssd.setSsd_load(rs.getInt("ssd_load"));
				ssd.setSsd_write(rs.getInt("ssd_write"));
				ssd.setSsd_img(rs.getString("ssd_img"));
				ssd.setSsd_id(rs.getInt("ssd_id"));
				ssd.setSsd_recid(rs.getInt("ssd_recid"));
				ssdList.add(ssd);
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return ssdList;
	}
	
	public ArrayList<Ssd> findPerSsdByName(String ssd_name) {
	    ArrayList<Ssd> ssdList = new ArrayList<>();
	    String sql = "select * from ssd where ssd_name = ?";
	    try {
	        PreparedStatement state = con.prepareStatement(sql);
	        state.setString(1, ssd_name);
	        ResultSet rs = state.executeQuery();

	        while (rs.next()) {
	        	Ssd ssd = new Ssd();
				ssd.setSsd_name(rs.getString("ssd_name"));
				ssd.setSsd_capacity(rs.getInt("ssd_capacity"));
				ssd.setSsd_standard(rs.getString("ssd_standard"));
				ssd.setSsd_interface(rs.getString("ssd_interface"));
				ssd.setSsd_price(rs.getInt("ssd_price"));
				ssd.setSsd_power(rs.getInt("ssd_power"));
				ssd.setSsd_maker(rs.getString("ssd_maker"));
				ssd.setSsd_load(rs.getInt("ssd_load"));
				ssd.setSsd_write(rs.getInt("ssd_write"));
				ssd.setSsd_img(rs.getString("ssd_img"));
				ssd.setSsd_id(rs.getInt("ssd_id"));
				ssd.setSsd_recid(rs.getInt("ssd_recid"));
				ssdList.add(ssd);
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return ssdList;
	}
	
	public ArrayList<Ssd> findAllSortedByPopularity() {
	    ArrayList<Ssd> ar = new ArrayList<>();
	    String sql = "SELECT * FROM ssd ORDER BY ssd_recid ASC";
	    try {
	        PreparedStatement state = con.prepareStatement(sql);
	        ResultSet rs = state.executeQuery();
	        while(rs.next()) {
	        	Ssd ssd = new Ssd();
				ssd.setSsd_name(rs.getString("ssd_name"));
				ssd.setSsd_capacity(rs.getInt("ssd_capacity"));
				ssd.setSsd_standard(rs.getString("ssd_standard"));
				ssd.setSsd_interface(rs.getString("ssd_interface"));
				ssd.setSsd_price(rs.getInt("ssd_price"));
				ssd.setSsd_power(rs.getInt("ssd_power"));
				ssd.setSsd_maker(rs.getString("ssd_maker"));
				ssd.setSsd_load(rs.getInt("ssd_load"));
				ssd.setSsd_write(rs.getInt("ssd_write"));
				ssd.setSsd_img(rs.getString("ssd_img"));
				ssd.setSsd_id(rs.getInt("ssd_id"));
				ssd.setSsd_recid(rs.getInt("ssd_recid"));
				ar.add(ssd);
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return ar;
	}
	
	public ArrayList<Ssd> findAllSortedByHighPrice() {
	    ArrayList<Ssd> ar = new ArrayList<>();
	    String sql = "SELECT * FROM ssd ORDER BY ssd_price DESC";
	    try {
	        PreparedStatement state = con.prepareStatement(sql);
	        ResultSet rs = state.executeQuery();
	        while(rs.next()) {
	        	Ssd ssd = new Ssd();
				ssd.setSsd_name(rs.getString("ssd_name"));
				ssd.setSsd_capacity(rs.getInt("ssd_capacity"));
				ssd.setSsd_standard(rs.getString("ssd_standard"));
				ssd.setSsd_interface(rs.getString("ssd_interface"));
				ssd.setSsd_price(rs.getInt("ssd_price"));
				ssd.setSsd_power(rs.getInt("ssd_power"));
				ssd.setSsd_maker(rs.getString("ssd_maker"));
				ssd.setSsd_load(rs.getInt("ssd_load"));
				ssd.setSsd_write(rs.getInt("ssd_write"));
				ssd.setSsd_img(rs.getString("ssd_img"));
				ssd.setSsd_id(rs.getInt("ssd_id"));
				ssd.setSsd_recid(rs.getInt("ssd_recid"));
				ar.add(ssd);
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return ar;
	}

	public ArrayList<Ssd> findAllSortedByLowPrice() {
	    ArrayList<Ssd> ar = new ArrayList<>();
	    String sql = "SELECT * FROM ssd ORDER BY ssd_price ASC";
	    try {
	        PreparedStatement state = con.prepareStatement(sql);
	        ResultSet rs = state.executeQuery();
	        while(rs.next()) {
	        	Ssd ssd = new Ssd();
				ssd.setSsd_name(rs.getString("ssd_name"));
				ssd.setSsd_capacity(rs.getInt("ssd_capacity"));
				ssd.setSsd_standard(rs.getString("ssd_standard"));
				ssd.setSsd_interface(rs.getString("ssd_interface"));
				ssd.setSsd_price(rs.getInt("ssd_price"));
				ssd.setSsd_power(rs.getInt("ssd_power"));
				ssd.setSsd_maker(rs.getString("ssd_maker"));
				ssd.setSsd_load(rs.getInt("ssd_load"));
				ssd.setSsd_write(rs.getInt("ssd_write"));
				ssd.setSsd_img(rs.getString("ssd_img"));
				ssd.setSsd_id(rs.getInt("ssd_id"));
				ssd.setSsd_recid(rs.getInt("ssd_recid"));
				ar.add(ssd);
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return ar;
	}
}
