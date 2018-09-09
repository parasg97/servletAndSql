package Dao;

import java.sql.Connection;
import java.util.ArrayList;

import dataModel.CustomerDM;

public interface customerDao {
	
	public void addCustomer(Connection con,CustomerDM customer);
	
	public void updateCustomerByName(Connection con, String name,String location);
	
	public CustomerDM getCustomerByName(Connection con,String name);
	
	public ArrayList<CustomerDM> getAllCustomers(Connection con);
	
	public void deleteCustomerByName(Connection con,String name);
	
}
