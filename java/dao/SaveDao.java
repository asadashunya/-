package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Save;

public class SaveDao {
       
	private Connection con = null;
	public SaveDao() {
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
	
	public ArrayList<Save> findCustByName(String cust_username) {
	    //cust_numを取得
	    int cust_num = 0;
	    String getNumQuery = "select cust_num from customer where cust_username = ?";
	    try (PreparedStatement getIdStmt2 = con.prepareStatement(getNumQuery)) {
            getIdStmt2.setString(1, cust_username); // userId をクエリにセット
            ResultSet rs = getIdStmt2.executeQuery();
            if (rs.next()) {
                cust_num = rs.getInt("cust_num");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
	    
	    //
	    ArrayList<Save> sabeId = new ArrayList<>();
	    String sql = "select mitusave_id from mitumori_save where mitusave_customer = ?";
	    try {
	        PreparedStatement state = con.prepareStatement(sql);
	        state.setInt(1, cust_num);
	        ResultSet rs = state.executeQuery();

	        while (rs.next()) {
	        	Save save = new Save();
	        	save.setMitusave_id(rs.getString("mitusave_id"));
	        	sabeId.add(save);
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return sabeId;
	}

}
