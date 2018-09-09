package Dao;

public class customerDaoFactory {
	
	public static customerDbImpl getCustomerDbImpl() {
		return new customerDbImpl();
	}
	
	/*public static customerXmlImpl getCustomerXmlImpl() {
		return new customerDbImpl();
	}*/
	
	
}
