package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Inquiry;

public class InquiryDao  {
	private Connection con = null;
	public InquiryDao() {
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
	
	public ArrayList<Inquiry> findAll(){
		ArrayList<Inquiry> ar = new ArrayList<>();
		String sql = "select * from inquiry";
		try {
			PreparedStatement state = con.prepareStatement(sql);
			ResultSet rs = state.executeQuery();
			while(rs.next()) {
				Inquiry inquiry = new Inquiry();
				inquiry.setInquiry_id(rs.getInt("inquiry_id"));
				inquiry.setInquiry_main(rs.getString("inquiry_main"));
				inquiry.setInquiry_name(rs.getString("inquiry_name"));
				inquiry.setInquiry_tel(rs.getInt("inquiry_tel"));
				inquiry.setInquiry_mail(rs.getString("inquiry_mail"));
				inquiry.setInquiry_title(rs.getString("inquiry_title"));
				ar.add(inquiry);
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
		return ar;
	}
	public Inquiry findInquiryById(int inquiry_id) {
		Inquiry inquiry = new Inquiry();
		String sql = "select * from inquiry where inquiry_id  = ?";
		try {
			PreparedStatement state = con.prepareStatement(sql);
			state.setInt(1, inquiry_id); //
			ResultSet rs = state.executeQuery();
			rs.next(); //
			inquiry.setInquiry_id(rs.getInt("inquiry_id"));
			inquiry.setInquiry_main(rs.getString("inquiry_main"));
			inquiry.setInquiry_name(rs.getString("inquiry_name"));
			inquiry.setInquiry_tel(rs.getInt("inquiry_tel"));
			inquiry.setInquiry_mail(rs.getString("inquiry_mail"));
			inquiry.setInquiry_title(rs.getString("inquiry_title"));
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return inquiry;
	}
	
}
