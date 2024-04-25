package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Mitumori;

public class MitumoriDao {
	private Connection con = null;
	public MitumoriDao() {
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
	
	public ArrayList<Mitumori> findAll(){
		ArrayList<Mitumori> ar = new ArrayList<>();
		String sql = "select * from mitumori";
		try {
			PreparedStatement state = con.prepareStatement(sql);
			ResultSet rs = state.executeQuery();
			while(rs.next()) {
				Mitumori mitumori = new Mitumori();
				mitumori.setMitumori_id(rs.getInt("mitumori_id"));
				mitumori.setMitumori_memory(rs.getString("mitumori_memory"));
				mitumori.setMitumori_power(rs.getString("mitumori_power"));
				mitumori.setMitumori_graphic(rs.getString("mitumori_graphic"));
				mitumori.setMitumori_cooler(rs.getString("mitumori_cooler"));
				mitumori.setMitumori_box(rs.getString("mitumori_box"));
				mitumori.setMitumori_motherboard(rs.getString("mitumori_motherboard"));
				mitumori.setMitumori_cpu(rs.getString("mitumori_cpu"));
				mitumori.setMitumori_ssd(rs.getString("mitumori_ssd"));
				mitumori.setMitumori_keyboard(rs.getString("mitumori_keyboard"));
				mitumori.setMitumori_mouse(rs.getString("mitumori_mouse"));
				ar.add(mitumori);
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
		return ar;
	}
	
	public ArrayList<Mitumori> findMitumoriByMitusave_id(int mitusave_id){
	    ArrayList<Mitumori> ar = new ArrayList<>();
	    String sql = "select * from mitumori where mitumori_id = ?";
	    try {
	        PreparedStatement state = con.prepareStatement(sql);
	        state.setInt(1, mitusave_id); // パラメータを設定する
	        ResultSet rs = state.executeQuery();
	        while(rs.next()) {
	            Mitumori mitumori = new Mitumori();
				mitumori.setMitumori_id(rs.getInt("mitumori_id"));
				mitumori.setMitumori_memory(rs.getString("mitumori_memory"));
				mitumori.setMitumori_power(rs.getString("mitumori_power"));
				mitumori.setMitumori_graphic(rs.getString("mitumori_graphic"));
				mitumori.setMitumori_cooler(rs.getString("mitumori_cooler"));
				mitumori.setMitumori_box(rs.getString("mitumori_box"));
				mitumori.setMitumori_motherboard(rs.getString("mitumori_motherboard"));
				mitumori.setMitumori_cpu(rs.getString("mitumori_cpu"));
				mitumori.setMitumori_ssd(rs.getString("mitumori_ssd"));
				mitumori.setMitumori_keyboard(rs.getString("mitumori_keyboard"));
				mitumori.setMitumori_mouse(rs.getString("mitumori_mouse"));
				ar.add(mitumori);
	        }
	    }catch(SQLException e){
	        e.printStackTrace();
	    }
	    return ar;
	}

	public ArrayList<Mitumori> findAllSortedByHigh() {
	    ArrayList<Mitumori> ar = new ArrayList<>();
	    String sql = "SELECT * FROM mitumori ORDER BY mitumori_id DESC";
	    try {
	        PreparedStatement state = con.prepareStatement(sql);
	        ResultSet rs = state.executeQuery();
	        while(rs.next()) {
	            Mitumori mitumori = new Mitumori();
				mitumori.setMitumori_id(rs.getInt("mitumori_id"));
				mitumori.setMitumori_memory(rs.getString("mitumori_memory"));
				mitumori.setMitumori_power(rs.getString("mitumori_power"));
				mitumori.setMitumori_graphic(rs.getString("mitumori_graphic"));
				mitumori.setMitumori_cooler(rs.getString("mitumori_cooler"));
				mitumori.setMitumori_box(rs.getString("mitumori_box"));
				mitumori.setMitumori_motherboard(rs.getString("mitumori_motherboard"));
				mitumori.setMitumori_cpu(rs.getString("mitumori_cpu"));
				mitumori.setMitumori_ssd(rs.getString("mitumori_ssd"));
				mitumori.setMitumori_keyboard(rs.getString("mitumori_keyboard"));
				mitumori.setMitumori_mouse(rs.getString("mitumori_mouse"));
				mitumori.setMitumori_mouse(rs.getString("mitumori_memorychip"));
				  ar.add(mitumori);
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return ar;
	}
}