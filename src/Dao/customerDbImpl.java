package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import dataModel.CustomerDM;
import sqlOprtn.CrudClass;

public class customerDbImpl implements customerDao {

	@Override
	public void addCustomer(Connection con,CustomerDM customer) {
		PreparedStatement addSmt=CrudClass.add(con,customer);
		try {
			addSmt.setInt(1, customer.getCustomerId());
			addSmt.setString(2,customer.getCustomerName() );
			addSmt.setString(3,customer.getCustomerLocation() );
			addSmt.setString(4,customer.getCustomerEmail() );
			int rowsEffected = addSmt.executeUpdate();
			if (rowsEffected > 0) {
			    System.out.println("A new user was inserted successfully!");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void updateCustomerByName(Connection con, String name,String location) {
		PreparedStatement updateSmt=CrudClass.update(con,name,location);
		try {
			int rowsEffected = updateSmt.executeUpdate();
			if (rowsEffected > 0) {
			    System.out.println("update is successfull");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public CustomerDM getCustomerByName(Connection con,String name) {
		PreparedStatement getSmt=CrudClass.getOne(con, name);
		CustomerDM c=null;
		try {
			ResultSet rs=getSmt.executeQuery();
			rs.next();
			if(rs!=null)
				c=new CustomerDM(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return c;
	}

	@Override
	public ArrayList<CustomerDM> getAllCustomers(Connection con) {
		ArrayList<CustomerDM> al=new ArrayList<>();
		PreparedStatement getAllSmt=CrudClass.viewAll(con);
		try {
			ResultSet rs=getAllSmt.executeQuery();
			while(rs.next()){
				CustomerDM c=new CustomerDM(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4));
				al.add(c);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return al;
	}

	@Override
	public void deleteCustomerByName(Connection con,String name) {
		PreparedStatement delSmt=CrudClass.delete(con,name);
		try {
			int rowsEffected=delSmt.executeUpdate();
			if (rowsEffected > 0) {
			    System.out.println("deletion is successfull");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
}
