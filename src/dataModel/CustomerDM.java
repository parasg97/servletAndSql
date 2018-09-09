package dataModel;

import java.io.Serializable;

public class CustomerDM implements Serializable
{
	private static final long serialVersionUID = 1L;
	
	int customerId;
	String customerLocation;
	String customerName;
	String customerEmail;
	
	public CustomerDM(int customerId,String customerName,String customerLocation, String customerEmail) {
		super();
		this.customerId = customerId;
		this.customerLocation = customerLocation;
		this.customerName = customerName;
		this.customerEmail = customerEmail;
	}
	
	public int getCustomerId() {
		return customerId;
	}
	public String getCustomerLocation() {
		return customerLocation;
	}
	public String getCustomerName() {
		return customerName;
	}
	public String getCustomerEmail() {
		return customerEmail;
	}

	@Override
	public String toString() {
		
		return "id: "+getCustomerId()+
				" name: "+getCustomerName()+
				" locaion: "+getCustomerLocation()+
				" email: "+getCustomerEmail();
	}
	
	
	
}


