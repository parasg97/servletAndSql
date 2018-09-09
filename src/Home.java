import java.sql.Connection;
import java.util.ArrayList;

import Dao.customerDao;
import Dao.customerDaoFactory;
import dataBaseConectivity.ConnectionSetup;
import dataModel.CustomerDM;

public class Home {
	public static void main(String args[]){
		Connection con=ConnectionSetup.establishConnection();
		customerDao cd=customerDaoFactory.getCustomerDbImpl();
		ArrayList<CustomerDM> al=cd.getAllCustomers(con);
		for (int i = 0; i < al.size(); i++) {
			System.out.println(al.get(i).toString());
		}
		CustomerDM c=cd.getCustomerByName(con, "Keith");
		System.out.println(c.toString());
		cd.addCustomer(con, new CustomerDM(5,"Paras","India","parasg1997@gmail.com"));
		cd.deleteCustomerByName(con, "Keith");
		cd=customerDaoFactory.getCustomerDbImpl();
		al=cd.getAllCustomers(con);
		for (int i = 0; i < al.size(); i++) {
			System.out.println(al.get(i).toString());
		}
		cd.updateCustomerByName(con, "Paras", "Germany");
		cd=customerDaoFactory.getCustomerDbImpl();
		al=cd.getAllCustomers(con);
		for (int i = 0; i < al.size(); i++) {
			System.out.println(al.get(i).toString());
		}
		
		ConnectionSetup.closeConnection(con);
		
	}
}
