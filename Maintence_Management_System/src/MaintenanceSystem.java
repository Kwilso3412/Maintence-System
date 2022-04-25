import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
public class MaintenanceSystem {
	//initializes the PrintWriters and scanner 
	PrintWriter outputFile = null;
	File clearFile = null;
	Scanner inputFile = null;

	//finds the employee using the username and password
	public MaintenanceEmployee employeeLogin (ArrayList<MaintenanceEmployee> searchEmployee, MaintenanceEmployee newEmployee, String userName, String password)
	{
		
		for (MaintenanceEmployee employee : searchEmployee) {
			
			if(employee.getUsername().contains(userName) && employee.getPassword().contains(password)) {
				
				newEmployee = employee;
				
				return newEmployee;
			}
		}
		return null;
	}
	
	//finds request based on if they are open or closed
	public serviceRequest  findRequest (ArrayList<serviceRequest> searchRequest,serviceRequest foundRequest,  String Type)
	{
		for (serviceRequest requestType : searchRequest) {
			
			if(requestType.getTypeOfIssue().contains(Type)) {
				
				 foundRequest = requestType;
				
				return foundRequest;
			}
		}
		return null;
		
	}
	
	//finds the case id of the request you are looking for
	public serviceRequest  findCaseID (ArrayList<serviceRequest> searchRequest,serviceRequest modifyRequest,  String caseID)
	{
		for (serviceRequest findCaseId : searchRequest) {
			
			if(findCaseId.getCaseID().contains(caseID)){
				 modifyRequest = findCaseId;
				
				return modifyRequest;
			}
		}
		return null;
		
	}

	//Searches the text file and stores it in the arrayList 
	public void loadEmployee (ArrayList<MaintenanceEmployee> loadEmployee) throws FileNotFoundException 
	{
		inputFile = new Scanner(new File("Employee.txt"));
		while(inputFile.hasNextLine()){
			//Brings in the text file
			String data = inputFile.nextLine();
			//Reads through the file and and finds the information
			MaintenanceEmployee newEmployee = new MaintenanceEmployee();
			String name = newEmployee.findName(data);
			String username = newEmployee.findUsername(data);
			String password = newEmployee.findPassword(data);
			String email = newEmployee.findEmail(data);
			String phonenumber = newEmployee.findPhonenumber(data);
			String address = newEmployee.findAddress(data);
			String id = newEmployee.findEmployeeId(data);
			
			//Gathers the data and stores it
			newEmployee.setName(name);
			newEmployee.setUsername(username);
			newEmployee.setPassword(password);
			newEmployee.setPhonenumber(phonenumber);
			newEmployee.setAddress(address);
			newEmployee.setEmail(email);
			newEmployee.setId(id);		
			
			loadEmployee.add(newEmployee);
		}
		inputFile.close();
	}

	public void  loadCustomer (ArrayList<Customer> loadCustomer)throws FileNotFoundException
	{
		inputFile = new Scanner(new File("Customer.txt"));
		while(inputFile.hasNextLine()){
			//Brings in the text file
			String data = inputFile.nextLine();
			//Reads through the file and and finds the information
			Customer newCustomer = new Customer();
			String name = newCustomer.findName(data);
			String email= newCustomer.findEmail(data);
			String phonenumber = newCustomer.findPhoneNumber(data);
			String address = newCustomer.findAddress(data);
			String customerId = newCustomer.findId(data);
			
			//Gathers data for the to string
			newCustomer.setName(name);
			newCustomer.setEmail(email);
			newCustomer.setPhoneNumber(phonenumber);;
			newCustomer.setAddress(address);;
			newCustomer.setId(customerId);;
			
			loadCustomer.add(newCustomer);
		}
	}
		
	public void  loadRequest (ArrayList<serviceRequest> loadRequest) throws FileNotFoundException
{
		inputFile = new Scanner(new File("ServiceRequest.txt"));
		while(inputFile.hasNextLine()){
			//Brings in the text file
			String data = inputFile.nextLine();
			//Reads through the file and and finds the information
			serviceRequest newRequest = new  serviceRequest();
			String customerName = newRequest.findCustomer(data);
			String respondingEmployee = newRequest.findEmployee(data);
			String issueAddress = newRequest.findAddress(data);
			String dateOfIssue = newRequest.findDate(data);
			String descOfIssue = newRequest.findDesc(data);
			String typeOfIssue = newRequest.findType(data);
			String statusOfIssue = newRequest.findStatus(data);
			String caseID = newRequest.findCaseID(data);

			//Gathers data for the to string
			newRequest.setCustomerName(customerName);
			newRequest.setEmployeeName(respondingEmployee);
			newRequest.setIssueAddress(issueAddress);;
			newRequest.setDateOfIssue(dateOfIssue);;
			newRequest.setDescOfIssue(descOfIssue);;
			newRequest.setTypeOfIssue(typeOfIssue);;
			newRequest.setStatus(statusOfIssue);;
			newRequest.setCaseID(caseID);
			
			 loadRequest.add(newRequest);
		}
		inputFile.close();
	}
	
	
	//Searches the text file and stores it in the arrayList 
	public void exportEmployee (ArrayList<MaintenanceEmployee> newEmployee) throws IOException 
	{
		//deletes old file and then creates a new one giving it the appearance that it was overwritten
		clearFile = new File ("Employee.txt");
		clearFile.delete();
		
		//exports the new files 
		try {
			outputFile = new PrintWriter (new FileWriter("Employee.txt", true));
			for (MaintenanceEmployee newLine : newEmployee)
			{
				outputFile.println(newLine);
			}
			outputFile.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		outputFile.close();
	}
	
	public void  exportCustomer (ArrayList<Customer> newCustomers) throws IOException {
		//deletes old file and then creates a new one giving it the appearance that it was overwritten
		clearFile = new File ("Customer.txt");
		clearFile.delete();

		//Prints result to the user in a text file
		outputFile = new PrintWriter (new FileWriter("Customer.txt", true));
		for (Customer newLine : newCustomers)
		{
			outputFile.println(newLine);
		}
		outputFile.close();
	}
		
	public void  exportRequest (ArrayList<serviceRequest> newRequest) throws IOException 
	{
		//re-writes the file to make it blank
		clearFile = new File ("ServiceRequest.txt");
		clearFile.delete();
		
		try {
			outputFile = new PrintWriter (new FileWriter("ServiceRequest.txt", true));
			for (serviceRequest newLine : newRequest)
			{
				outputFile.println(newLine);
			}
			outputFile.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		outputFile.close();

	}


}
