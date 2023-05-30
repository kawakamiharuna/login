package jp.co.aforce.data;

import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import jp.co.aforce.admin.Admin;

public class Sarch {
	
	public Admin check(String id, String password) throws FileNotFoundException{
		
		
		LoginData ds = new LoginData();
		String name = ds.getDbInfo().get("name");
		String ids = ds.getDbInfo().get("id");
		String pass = ds.getDbInfo().get("password");
		
		String loginSql = "select * from Login"+"WHERE id = ? and password= ?;";
		Admin admin = new Admin();
		
		try(Connection conn = DriverManager.getConnection(name,ids, pass)){
			PreparedStatement stmt = conn.prepareStatement(loginSql);
			
			stmt.setString(1, id);
			stmt.setString(2,password);
			
			ResultSet rs = stmt.executeQuery();
			
			if(rs.next()) {
				admin.setId(rs.getInt("id"));
				admin.setName(rs.getString("name"));
				admin.setPassword(rs.getString("password"));
				admin.setLoginOk(true);
			}else {
				admin.setLoginOk(false);
			}
		}catch (SQLException e) {
			System.out.println("接続できません。");
			e.printStackTrace();
		}
		
		return admin;
		
		
	} 
	

}
