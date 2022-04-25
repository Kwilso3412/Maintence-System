
public class MaintenanceEmployee {
	//Instance fields
	private String name;
	private String username;
	private String password;
	private String phonenumber;
	private String address;
	private String email;
	private String employeeId;
	
	//Constant used for skipping to the next value
	final int next = 1;
	public Object getId;
		

	//Default constructor that takes no parameters
	public MaintenanceEmployee()
	{
		//constant for the default IDß
		name = "blank customer";
		username = "none";
		password = "none";
		email ="none";
		phonenumber = "856-555-7777";
		address = "777 no name street Billytown nj";
		employeeId = "000";

	}

	//parameterized constructor
	public MaintenanceEmployee(String employeeName, String employeeUsername, String employeePassword, String employeeEmail, 
			String employeePhoneNumber, String employeeAddress, String employeeID)
	{
		name = employeeName;
		username =  employeeUsername;
		password = employeePassword;
		email = employeeEmail;
		phonenumber = employeePhoneNumber;
		address = employeeAddress;
		employeeId= employeeID;

	}
		
		
	//Finds the information in the employe.txt file 
	public String findName (String data) 
	{
		int colon1 = data.indexOf(':');
		int comma1 = data.indexOf(',');

		//stores the value in the name
		name = data.substring(colon1 + next, comma1);

		return name;
	}

	public String findUsername (String data)
	{
		int colon1 = data.indexOf(':');
		int colon2 = data.indexOf(':', colon1 + next);

		int comma1 = data.indexOf(',');
		int comma2 = data.indexOf(',', comma1 + next);

		username = data.substring(colon2 + next, comma2);
		return username;
	}

	public String findPassword (String data)
	{

		int colon1 = data.indexOf(':');
		int colon2 = data.indexOf(':', colon1 + next);
		int colon3 = data.indexOf(':', colon2 +next);

		int comma1 = data.indexOf(',');
		int comma2 = data.indexOf(',', comma1 + next);
		int comma3 = data.indexOf(',', comma2 + next);

		password = data.substring(colon3  + next, comma3);

		return password;
	}


	public String findEmail (String data)
	{
		int colon1 = data.indexOf(':');
		int colon2 = data.indexOf(':', colon1 + next);
		int colon3 = data.indexOf(':', colon2 +next);
		int colon4 = data.indexOf(':', colon3 +next);

		int comma1 = data.indexOf(',');
		int comma2 = data.indexOf(',', comma1 + next);
		int comma3 = data.indexOf(',', comma2 + next);
		int comma4 = data.indexOf(',', comma3 + next);

		email = data.substring(colon4  + next, comma4);

		return email;
	}


	public String findPhonenumber (String data)
	{
		int colon1 = data.indexOf(':');
		int colon2 = data.indexOf(':', colon1 + next);
		int colon3 = data.indexOf(':', colon2 +next);
		int colon4 = data.indexOf(':', colon3 +next);
		int colon5 = data.indexOf(':', colon4 +next);

		int comma1 = data.indexOf(',');
		int comma2 = data.indexOf(',', comma1 + next);
		int comma3 = data.indexOf(',', comma2 + next);
		int comma4 = data.indexOf(',', comma3 + next);
		int comma5 = data.indexOf(',', comma4 + next);

		phonenumber = data.substring(colon5 + next, comma5);

		return phonenumber;
	}

	public String findAddress (String data)
	{
		int colon1 = data.indexOf(':');
		int colon2 = data.indexOf(':', colon1 + next);
		int colon3 = data.indexOf(':', colon2 +next);
		int colon4 = data.indexOf(':', colon3 +next);
		int colon5 = data.indexOf(':', colon4 +next);
		int colon6 = data.indexOf(':', colon5 +next);

		int comma1 = data.indexOf(',');
		int comma2 = data.indexOf(',', comma1 + next);
		int comma3 = data.indexOf(',', comma2 + next);
		int comma4 = data.indexOf(',', comma3 + next);
		int comma5 = data.indexOf(',', comma4 + next);
		int comma6 = data.indexOf(',', comma5 + next);

		address = data.substring(colon6 + next, comma6);

		return address;
	}

	public String findEmployeeId (String data)
	{
		int lessThan =data.indexOf('<');
		int greaterThan = data.indexOf('>');

		employeeId = data.substring(lessThan+ next, greaterThan);

		return employeeId;
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

	public String getUsername()
	{
		return username;
	}

	public void setUsername(String username)
	{
		this.username = username;
	}

	public String getPassword()
	{
		return password;
	}

	public void setPassword(String password)
	{
		this.password = password;
	}

	public String getPhonenumber()
	{
		return phonenumber;
	}

	public void  setPhonenumber(String phonenumber)
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

	public String getEmail()
	{
		return email;
	}

	public void  setEmail(String email)
	{
		this.email = email;
	}

	public String getId()
	{
		return employeeId;
	}

	public void setId(String id)
	{
		this.employeeId = id;
	}

	public String toString()
	{
		return "{Name:" + name +"," + "Username:" + username + "," + "Password:" + password +
				"," + " Email:" + email + "," + " Phone number:" + phonenumber+ "," + 
				"Address:" + address + "," + "Employee ID:<" + employeeId + ">.}";
	}

	


		
		
		
}
