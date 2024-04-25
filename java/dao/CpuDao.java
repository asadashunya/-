package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Cpu;

public class CpuDao {
	private Connection con = null;
	public CpuDao() {
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
	
	public ArrayList<Cpu> findAll(){
		ArrayList<Cpu> ar = new ArrayList<>();
		String sql = "select * from cpu";
		try {
			PreparedStatement state = con.prepareStatement(sql);
			ResultSet rs = state.executeQuery();
			while(rs.next()) {
				Cpu cpu = new Cpu();
				cpu.setCpu_name(rs.getString("cpu_name"));
				cpu.setCpu_processor(rs.getString("cpu_processor"));
				cpu.setCpu_socket(rs.getString("cpu_socket"));
				cpu.setCpu_cores(rs.getInt("cpu_cores"));
				cpu.setCpu_thread(rs.getInt("cpu_thread"));
				cpu.setCpu_ghz(rs.getInt("cpu_ghz"));
				cpu.setCpu_price(rs.getInt("cpu_price"));
				cpu.setCpu_power(rs.getInt("cpu_power"));
				cpu.setCpu_img(rs.getString("cpu_img"));
				cpu.setCpu_id(rs.getInt("cpu_id"));
				cpu.setCpu_recid(rs.getInt("cpu_recid"));
				ar.add(cpu);
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
		return ar;
	}
	
	public ArrayList<Cpu> findCpuByName(String cpu_name) {
	    ArrayList<Cpu> cpuList = new ArrayList<>();
	    String sql = "select * from cpu where cpu_name like ?";
	    try {
	        PreparedStatement state = con.prepareStatement(sql);
	        state.setString(1, "%" + cpu_name + "%");
	        ResultSet rs = state.executeQuery();

	        while (rs.next()) {
	            Cpu cpu = new Cpu();
	            cpu.setCpu_name(rs.getString("cpu_name"));
	            cpu.setCpu_processor(rs.getString("cpu_processor"));
	            cpu.setCpu_socket(rs.getString("cpu_socket"));
	            cpu.setCpu_cores(rs.getInt("cpu_cores"));
	            cpu.setCpu_thread(rs.getInt("cpu_thread"));
	            cpu.setCpu_ghz(rs.getInt("cpu_ghz"));
	            cpu.setCpu_price(rs.getInt("cpu_price"));
	            cpu.setCpu_power(rs.getInt("cpu_power"));
	            cpu.setCpu_img(rs.getString("cpu_img"));
	            cpu.setCpu_id(rs.getInt("cpu_id"));
	            cpu.setCpu_recid(rs.getInt("cpu_recid"));
	            cpuList.add(cpu);
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return cpuList;
	}
	
	public ArrayList<Cpu> findPerCpuByName(String cpu_name) {
	    ArrayList<Cpu> cpuList = new ArrayList<>();
	    String sql = "select * from cpu where cpu_name = ?";
	    try {
	        PreparedStatement state = con.prepareStatement(sql);
	        state.setString(1, cpu_name);
	        ResultSet rs = state.executeQuery();

	        while (rs.next()) {
	            Cpu cpu = new Cpu();
	            cpu.setCpu_name(rs.getString("cpu_name"));
	            cpu.setCpu_processor(rs.getString("cpu_processor"));
	            cpu.setCpu_socket(rs.getString("cpu_socket"));
	            cpu.setCpu_cores(rs.getInt("cpu_cores"));
	            cpu.setCpu_thread(rs.getInt("cpu_thread"));
	            cpu.setCpu_ghz(rs.getInt("cpu_ghz"));
	            cpu.setCpu_price(rs.getInt("cpu_price"));
	            cpu.setCpu_power(rs.getInt("cpu_power"));
	            cpu.setCpu_img(rs.getString("cpu_img"));
	            cpu.setCpu_id(rs.getInt("cpu_id"));
	            cpu.setCpu_recid(rs.getInt("cpu_recid"));
	            cpuList.add(cpu);
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return cpuList;
	}
	
	public ArrayList<Cpu> findAllSortedByPopularity() {
	    ArrayList<Cpu> ar = new ArrayList<>();
	    String sql = "SELECT * FROM cpu ORDER BY cpu_recid ASC";
	    try {
	        PreparedStatement state = con.prepareStatement(sql);
	        ResultSet rs = state.executeQuery();
	        while(rs.next()) {
	            Cpu cpu = new Cpu();
	            cpu.setCpu_name(rs.getString("cpu_name"));
	            cpu.setCpu_processor(rs.getString("cpu_processor"));
	            cpu.setCpu_socket(rs.getString("cpu_socket"));
	            cpu.setCpu_cores(rs.getInt("cpu_cores"));
	            cpu.setCpu_thread(rs.getInt("cpu_thread"));
	            cpu.setCpu_ghz(rs.getInt("cpu_ghz"));
	            cpu.setCpu_price(rs.getInt("cpu_price"));
	            cpu.setCpu_power(rs.getInt("cpu_power"));
	            cpu.setCpu_img(rs.getString("cpu_img"));
	            cpu.setCpu_id(rs.getInt("cpu_id"));
	            cpu.setCpu_recid(rs.getInt("cpu_recid"));
	            ar.add(cpu);
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return ar;
	}
	
	public ArrayList<Cpu> findAllSortedByHighPrice() {
	    ArrayList<Cpu> ar = new ArrayList<>();
	    String sql = "SELECT * FROM cpu ORDER BY cpu_price DESC";
	    try {
	        PreparedStatement state = con.prepareStatement(sql);
	        ResultSet rs = state.executeQuery();
	        while(rs.next()) {
	        	Cpu cpu = new Cpu();
	            cpu.setCpu_name(rs.getString("cpu_name"));
	            cpu.setCpu_processor(rs.getString("cpu_processor"));
	            cpu.setCpu_socket(rs.getString("cpu_socket"));
	            cpu.setCpu_cores(rs.getInt("cpu_cores"));
	            cpu.setCpu_thread(rs.getInt("cpu_thread"));
	            cpu.setCpu_ghz(rs.getInt("cpu_ghz"));
	            cpu.setCpu_price(rs.getInt("cpu_price"));
	            cpu.setCpu_power(rs.getInt("cpu_power"));
	            cpu.setCpu_img(rs.getString("cpu_img"));
	            cpu.setCpu_id(rs.getInt("cpu_id"));
	            cpu.setCpu_recid(rs.getInt("cpu_recid"));
	            ar.add(cpu);
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return ar;
	}

	public ArrayList<Cpu> findAllSortedByLowPrice() {
	    ArrayList<Cpu> ar = new ArrayList<>();
	    String sql = "SELECT * FROM cpu ORDER BY cpu_price ASC";
	    try {
	        PreparedStatement state = con.prepareStatement(sql);
	        ResultSet rs = state.executeQuery();
	        while(rs.next()) {
	        	Cpu cpu = new Cpu();
	            cpu.setCpu_name(rs.getString("cpu_name"));
	            cpu.setCpu_processor(rs.getString("cpu_processor"));
	            cpu.setCpu_socket(rs.getString("cpu_socket"));
	            cpu.setCpu_cores(rs.getInt("cpu_cores"));
	            cpu.setCpu_thread(rs.getInt("cpu_thread"));
	            cpu.setCpu_ghz(rs.getInt("cpu_ghz"));
	            cpu.setCpu_price(rs.getInt("cpu_price"));
	            cpu.setCpu_power(rs.getInt("cpu_power"));
	            cpu.setCpu_img(rs.getString("cpu_img"));
	            cpu.setCpu_id(rs.getInt("cpu_id"));
	            cpu.setCpu_recid(rs.getInt("cpu_recid"));
	            ar.add(cpu);
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return ar;
	}
}
