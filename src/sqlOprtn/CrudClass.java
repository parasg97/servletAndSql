package sqlOprtn;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import dataModel.CustomerDM;

public class CrudClass {
	private static PreparedStatement stmt;//=con.prepareStatement("SELECT * FROM CUSTOMERTABLE");
	
	public static PreparedStatement add(Connection con,CustomerDM c) {
		try {
			stmt=con.prepareStatement("INSERT INTO CUSTOMERTABLE ([CustomerId],[Name],[Location],[Email]) VALUES (?, ?, ?, ?)");
			stmt.setInt(1,c.getCustomerId());
			stmt.setString(2, c.getCustomerName());
			stmt.setString(3, c.getCustomerLocation());
			stmt.setString(4, c.getCustomerEmail());
			
		} catch (SQLException e) {
		
			e.printStackTrace();
		}
		return stmt;
	}
	
	public static PreparedStatement update(Connection con,String name,String newLocation) {
		
		try {
			stmt=con.prepareStatement("update customertable set location='"+newLocation+"' where name='"+name+"'");
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return stmt;
	}
	
	public static PreparedStatement delete(Connection con,String name) {
		try {
			stmt=con.prepareStatement("delete from customertable where name='"+name+"'");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return stmt;
	}
	
	public static PreparedStatement viewAll(Connection con) {
		try {
			stmt=con.prepareStatement("SELECT * FROM CUSTOMERTABLE");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return stmt;
	}
	
	public static PreparedStatement getOne(Connection con,String name) {
		try {
			stmt=con.prepareStatement("SELECT CustomerId,NAME,Location,Email FROM CUSTOMERTABLE WHERE NAME like'"+name+"'");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return stmt;
	}
	
	
}
