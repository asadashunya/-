package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Customer;


public class CustomerDao  {
	private Connection con = null;
	public CustomerDao() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
			System.exit(1);
		}
		try {
			con = DriverManager.getConnection(
					"jdbc:mysql://10.64.144.5:3306/22jygr2-4?characterEncoding=UTF-8"
					,"22jy0221","22jy0221");
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
	
	public ArrayList<Customer> findAll(){
		ArrayList<Customer> ar = new ArrayList<>();
		String sql = "select * from customer";
		try {
			PreparedStatement state = con.prepareStatement(sql);
			ResultSet rs = state.executeQuery();
			while(rs.next()) {
				Customer customer = new Customer();
				customer.setCust_num(rs.getInt("cust_num"));
				customer.setCust_fname(rs.getString("cust_fname"));
				customer.setCust_lname(rs.getString("cust_lname"));
				customer.setCust_fkana(rs.getString("cust_fkana"));
				customer.setCust_lkana(rs.getString("cust_lkana"));
				customer.setCust_tel(rs.getString("cust_tel"));
				customer.setCust_address(rs.getString("cust_address"));
				customer.setCust_mail(rs.getString("cust_mail"));
				customer.setCust_username(rs.getString("cust_username"));
				customer.setCust_postnum(rs.getInt("cust_postnum"));
				ar.add(customer);
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
		return ar;
	}
	public Customer findCustomerByNum(Integer cust_num) {
		Customer customer = new Customer();
		String sql = "select * from customer where cust_num = ?";
		try {
			PreparedStatement state = con.prepareStatement(sql);
			state.setInt(1, cust_num); //
			ResultSet rs = state.executeQuery();
			rs.next(); //
			customer.setCust_num(rs.getInt("cust_num"));
			customer.setCust_fname(rs.getString("cust_fname"));
			customer.setCust_lname(rs.getString("cust_lname"));
			customer.setCust_fkana(rs.getString("cust_fkana"));
			customer.setCust_lkana(rs.getString("cust_lkana"));
			customer.setCust_tel(rs.getString("cust_tel"));
			customer.setCust_address(rs.getString("cust_address"));
			customer.setCust_mail(rs.getString("cust_mail"));
			customer.setCust_username(rs.getString("cust_username"));
			customer.setCust_postnum(rs.getInt("cust_postnum"));
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return customer;
	}
}
