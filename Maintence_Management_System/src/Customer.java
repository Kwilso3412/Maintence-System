
public class Customer {
	//created by Kahlyll Wilson
	
	private String name;
	private String email;
	private String phonenumber;
	private String address;
	private String customerId;
	
	//Constant used for skipping to the next value
	final int next = 1;
	
	//Default constructor that takes no parameters
	public Customer()
	{

		name = "blank customer";
		email = "none";
		phonenumber = ("856-555-777");
		customerId ="00000";
		address = "555 no name street billytown Nj";
		
	}
	
	//parameterized constructor
	public Customer(String customerName, String customerEmail, String customerPassword, String customerID, String CustomerAddress)
	{
		name = customerName;
		email = customerEmail;
		phonenumber = customerPassword;
		customerId= customerID;
		address = CustomerAddress;
	}
	
	public String findName (String data) 
	{
		int colon1 = data.indexOf(':');
		int comma1 = data.indexOf(',');
		
		//stores the value in the name
		name = data.substring(colon1 + next, comma1);
		
		return name;
	}
	
	public String findEmail (String data)
	{
		int colon1 = data.indexOf(':');
		int colon2 = data.indexOf(':', colon1 + next);
		
		int comma1 = data.indexOf(',');
		int comma2 = data.indexOf(',', comma1 + next);
		
		email = data.substring(colon2 + next, comma2);
		return email;
	}
	
	public String findPhoneNumber(String data)
	{
		
		int colon1 = data.indexOf(':');
		int colon2 = data.indexOf(':', colon1 + next);
		int colon3 = data.indexOf(':', colon2 +next);
		
		int comma1 = data.indexOf(',');
		int comma2 = data.indexOf(',', comma1 + next);
		int comma3 = data.indexOf(',', comma2 + next);
		
		phonenumber = data.substring(colon3  + next, comma3);
		
		return phonenumber;
	}
	
	public String findAddress(String data)
	{
		
		int openBracket = data.indexOf('[');

		
		int closedBracket = data.indexOf(']');

		address = data.substring(openBracket   + next, closedBracket);
		
		return address;
	}
	
	public String findId (String data)
	{
		int lessThan = data.indexOf('<');

		
		int greaterThan = data.indexOf('>');

		
		customerId = data.substring(lessThan  + next, greaterThan );
		
		return customerId;
	}
	
	//Getters and setters for the customer information
	
	public String getName()
	{
		return name;
	}
	
	public void  setName(String name)
	{
		this.name =name;
	}
	
	public String getEmail()
	{
		return email;
	}
	
	public void setEmail(String email)
	{
		this.email = email;
	}
	
	public String getPhoneNumber()
	{
		return phonenumber;
	}
	
	public void setPhoneNumber(String phonenumber)
	{
		this.phonenumber = phonenumber;
	}
	
	public String getAddress()
	{
		return address;
	}
	
	public void  setAddress(String address)
	{
		this.address = address;
	}

	
	public String getId()
	{
		return customerId;
	}
	
	public void setId(String id)
	{
		this.customerId = id;
	}
	
	public String toString()
	{
		return "{Name:" + name +"," + "Email:" + email + "," + "Phone number:" + phonenumber 
				+ "," + "Address:[" + address + "]," + "Customer ID:<" + customerId + ">.}";
	}
	
}
