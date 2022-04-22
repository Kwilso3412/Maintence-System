import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
public class MaintenenceManagement {
	
	//Created by Kahlyll & Isaiah
	
	public static void main(String[] args) throws IOException {
		Scanner userInput = new Scanner(System.in);
		char response;		//gathers the initial response
		char option;        //used for making the users response uppercase 
		String exitKey;     //exiting the program
		String answer;     	//the users answers to questions 
		int nextResponse; 	//goes to the users response 
		int finalResponse;	//the last response of the user
		String username;    //username of the employee
		String password;    //password of the emoloyee

		
		//creates the arrayList
		ArrayList<MaintenanceEmployee> employeeWorkingList = new ArrayList<MaintenanceEmployee>();
		ArrayList<Customer> customerWorkingList = new ArrayList<Customer>();	
		ArrayList<serviceRequest> requestWorkingList = new ArrayList<serviceRequest>();	
		
		//initializes objects being used 
		MaintenanceSystem database = new MaintenanceSystem();
		Customer newCustomer = new Customer();
		serviceRequest newRequest = new serviceRequest();
		MaintenanceEmployee workingEmployee;
		
		//initializes the arraylist that will we will be working with
		database.loadEmployee(employeeWorkingList); 
		database.loadCustomer(customerWorkingList);
		database.loadRequest(requestWorkingList);
		
		//Prompts the user until the correct response is given
		do {
			workingEmployee = new MaintenanceEmployee();
			//Prompts the user to sign in to the system
			System.out.println("Welcome please enter your username and password to begin using the program \n");		
			System.out.println("Username: ");
			username = userInput.next();
			workingEmployee.setUsername(username);

			System.out.println("password: ");
			password = userInput.next();
			workingEmployee.setPassword(password);
			
			//copies the object form findEmployee into the workingEmployee method
			workingEmployee = database.employeeLogin(employeeWorkingList, workingEmployee, workingEmployee.getUsername(), workingEmployee.getPassword());
			
			
			if (workingEmployee == null) {
				System.out.println("Incorrect username or Password \n");
				continue;
			}
			
			else {
				System.out.println("Welcome to the system " + workingEmployee.getName() + "\n");
				break;
			}
		}while(workingEmployee == null);

		//the main program 
			do { 
			userInput.nextLine();
			System.out.println("What would you like to do?");
			//The main menu of the program
			System.out.println("A. Create a new service request");
	        System.out.println("B. modify current service requests");
	        System.out.println("C. Veiw all service requests");
	        System.out.println("D. Exit \n");
	        response = userInput.next().charAt(0);
			exitKey = "Y";
	        option = Character.toUpperCase(response);
		      
	        switch (option) {
			//Allows the user to create a Service request 
			case 'A':
				//Creates the customer making the request
				System.out.println("Please enter the new customers first name : ");	
				answer = userInput.next();
				String firstName = answer;
				
				System.out.println("Please enter the new customers last name: ");	
				answer = userInput.next();
				String lastName = answer;
				
				String fullName = firstName +" " + lastName;
				newCustomer.setName(fullName);
				
				System.out.println("Please enter the customers email: ");
				answer = userInput.next();
				newCustomer.setEmail(answer);

				System.out.println("Please enter the customers phone number: ");
				answer = userInput.next();
				newCustomer.setPhoneNumber(answer);
				
				System.out.println("Please enter the the customers address: ");
				answer = userInput.nextLine();
				answer = userInput.nextLine();
				newCustomer.setAddress(answer);
				
				System.out.println("Please create a four number Customer ID starting with (C): ");
				answer = userInput.next();
				newCustomer.setId(answer);
				
				System.out.println("This is the new customer: \n" + newCustomer.toString() + "\n");

				newRequest.setCustomerName(newCustomer.getName());
				newRequest.setIssueAddress(newCustomer.getAddress());
				
				//Adds new customer to the customers arrayList 
				customerWorkingList.add(newCustomer);
				
				//begins to gather information about the service required
				System.out.println("What type of issue is the customer experiencing?(Plumbing, Electrical, HVAC, Structural, General Issue)");
				answer = userInput.next();
							
					do{
						if (answer.contains("Plumbing") || answer.contains("plumbing")){
							newRequest.setTypeOfIssue(answer);
						}
					else if (answer.contains("Electrical") || answer.contains("electrical")){
							newRequest.setTypeOfIssue(answer);
						}
						else if (answer.contains("HVAC") || answer.contains("hvac")){
							newRequest.setTypeOfIssue(answer);
					}
					else if (answer.contains("Structural") || answer.contains("structural")){
						newRequest.setTypeOfIssue(answer);
						}
						else if (answer.contains("General") || answer.contains("general")){
						newRequest.setTypeOfIssue(answer);
						}
					else {
						answer = "";
						System.out.println("Please enter a valid option");
							System.out.println("What type of issue are you experiencing?(Plumbing, Electrical, HVAC, Structural, General)");
							answer= userInput.next();
						}
					}while(answer == "");
					newRequest.setTypeOfIssue(answer);	//Verifies that an answer is given
					userInput.nextLine();	//DO NOT REMOVE - Necessary for nextLine to function properly
			
				System.out.println("Please give a brief description of what issues you are experiencing: ");
				answer = userInput.nextLine();
				newRequest.setDescOfIssue(answer);
		
				System.out.println("What is todays Date: ");
				answer = userInput.nextLine();
				newRequest.setDateOfIssue(answer);
	
				System.out.println("Create create 4 number ID starting with (S): ");
				answer = userInput.nextLine();
				newRequest.setCaseID(answer);
				
				
				System.out.println("Your response has been recorded.");
				newRequest.setEmployeeName(workingEmployee.getName()); //takes the employee that logged in and stores it as the responding employee
				newRequest.setStatus("open"); 
				requestWorkingList.add(newRequest);
				System.out.println("Here is the new service request \n" + newRequest.toString());
				System.out.println("Press enter to continue to the main menu...");
				break;
	        	
				//Allows user to change, view or delete a request 	
				case 'B':
					serviceRequest modifiedRequest = new serviceRequest();
					serviceRequest deleteRequest = new serviceRequest();
					
					//displays the list of service Request stored in the text file 
					for (serviceRequest id : requestWorkingList) {
						System.out.println("Name: " + id.getCustomerName());
						System.out.println("Problem: " + id.getDescOfIssue());
						System.out.println("Case Id: " + id.getCaseID() + "\n");
						}
					
					//Prompts the user for the id they want to modify
					System.out.println("Please type the case Id you want to modify.");
					answer = userInput.next();
					
					//checks if the answer is correct
					
					
					
					
					
					//finds the service request to modify
					modifiedRequest.setCaseID(answer);
					deleteRequest.setCaseID(answer);
					
					modifiedRequest = database.findCaseID(requestWorkingList, modifiedRequest, modifiedRequest.getCaseID());
					deleteRequest = database.findCaseID(requestWorkingList, deleteRequest, deleteRequest.getCaseID());
					
					if (modifiedRequest != null) {
						do {
							if (modifiedRequest.getCaseID() == answer) {	
									//makes the changes
									System.out.println("How would you like to modify this request?");
									System.out.println("1. Close Request");
									System.out.println("2. Re-open Request");
									System.out.println("3. Delete Request");
									finalResponse = userInput.nextInt();
									
									
										if (finalResponse == 1) {
											modifiedRequest.setStatus("Resolved");
											//adds the new modified request
											requestWorkingList.add(modifiedRequest);
											//deletes the old request
											requestWorkingList.remove(deleteRequest);
											System.out.println("The case is now closed \n");
											break;
										}
										
										else if(finalResponse == 2) {
											modifiedRequest.setStatus("Open");
											//adds the new modified request
											requestWorkingList.add(modifiedRequest);
											//deletes the old request
											requestWorkingList.remove(deleteRequest);
											System.out.println("The case is now open again \n");
											break;
										}
										
										else if(finalResponse == 3) {
											//deletes the request
											requestWorkingList.remove(deleteRequest);
											requestWorkingList.remove(deleteRequest);
											System.out.println("The request has been deleted \n");
											break;
										}
									
									else {
										System.out.println("Please enter the correct case id \n");
										continue;
									}
						}
							}while(modifiedRequest == null);
					}
					
					else {
						System.out.println("Please enter the correct case id \n");
					}
					
					break;
					
				//ALlows the user to view ALL REQUESTS or ALL OF ONE REQUEST
				case 'C': 				
					userInput.nextLine();
					
					serviceRequest searchingRequest = new serviceRequest();
					
					System.out.println("1. Veiw all of one request type");
			        System.out.println("2. Veiw all request types");
			        System.out.println("3. Main menu \n");
				    nextResponse = userInput.nextInt();
		 
						switch(nextResponse) {
							//allows the user to pick a specific type of request
							case 1:
							System.out.println("Which request type would you like to view?");
							System.out.println("1. Plumbing Requests");
							System.out.println("2. Electrical Requests");
							System.out.println("3. HVAC Requests");
							System.out.println("4. Structural Requests");
							System.out.println("5. General Requests");
							finalResponse = userInput.nextInt();
							//need to fix the bug where if the correct response is not entered it will reject
							if(finalResponse == 1) {
								//searches the large array list 
								searchingRequest = (database).findRequest(requestWorkingList, searchingRequest, "plumbing");
								
								//Prints out the items if they are found
								ArrayList<serviceRequest> newRequestList = new ArrayList<serviceRequest>();
								
								if (searchingRequest== null) {
									System.out.println("There are no plumbing request \n");
									break;
								}
								else {
									newRequestList.add(searchingRequest);
									
									for(serviceRequest request : newRequestList) {
										
										System.out.println("Customer's name: " + request.getCustomerName());
										System.out.println("Date of iss was created: " + request.getDateOfIssue());
										System.out.println("Status: " + request.getStatus());
										System.out.println("Problem: " + request.getDescOfIssue());
										System.out.println("Address: " + request.getIssueAddress());
										System.out.println("Responding Employee: " + request.getEmployeeName());
										System.out.println("Case Id: " + request.getCaseID() + "\n");

										}
								}
								
							}
							
							else if(finalResponse == 2) {
								//searches the large array list 
								searchingRequest = (database).findRequest(requestWorkingList, searchingRequest, "electrical");
								
								//Prints out the items if they are found
								ArrayList<serviceRequest> newRequestList = new ArrayList<serviceRequest>();
								if (searchingRequest== null) {
									System.out.println("There are no electrical request \n");
									break;
								}
								else {
									newRequestList.add(searchingRequest);
									
									for(serviceRequest request : newRequestList) {
										
										System.out.println("Customer's name: " + request.getCustomerName());
										System.out.println("Date of iss was created: " + request.getDateOfIssue());
										System.out.println("Status: " + request.getStatus());
										System.out.println("Problem: " + request.getDescOfIssue());
										System.out.println("Address: " + request.getIssueAddress());
										System.out.println("Responding Employee: " + request.getEmployeeName());
										System.out.println("Case Id: " + request.getCaseID() + "\n");

										}
								}
								
							}
							
							else if(finalResponse == 3) {
								//searches the large array list 
								searchingRequest = (database).findRequest(requestWorkingList, searchingRequest, "hvac");
								
								//Prints out the items if they are found
								ArrayList<serviceRequest> newRequestList = new ArrayList<serviceRequest>();
								if (searchingRequest== null) {
									System.out.println("There are no hvac request \n");
									break;
								}
								else {
									newRequestList.add(searchingRequest);
									
									for(serviceRequest request : newRequestList) {
										
										System.out.println("Customer's name: " + request.getCustomerName());
										System.out.println("Date of iss was created: " + request.getDateOfIssue());
										System.out.println("Status: " + request.getStatus());
										System.out.println("Problem: " + request.getDescOfIssue());
										System.out.println("Address: " + request.getIssueAddress());
										System.out.println("Responding Employee: " + request.getEmployeeName());
										System.out.println("Case Id: " + request.getCaseID() + "\n");
										}
								}
							}
							else if(finalResponse == 4) {
								//searches the large array list 
								searchingRequest = (database).findRequest(requestWorkingList, searchingRequest, "structural");
								
								//Prints out the items if they are found
								ArrayList<serviceRequest> newRequestList = new ArrayList<serviceRequest>();
								if (searchingRequest== null) {
									System.out.println("There are no structural request \n");
									break;
								}
								else {
									newRequestList.add(searchingRequest);
									
									for(serviceRequest request : newRequestList) {
										
										System.out.println("Customer's name: " + request.getCustomerName());
										System.out.println("Date of iss was created: " + request.getDateOfIssue());
										System.out.println("Status: " + request.getStatus());
										System.out.println("Problem: " + request.getDescOfIssue());
										System.out.println("Address: " + request.getIssueAddress());
										System.out.println("Responding Employee: " + request.getEmployeeName());
										System.out.println("Case Id: " + request.getCaseID() + "\n");
										}
								}
							
							}
							
							else if(finalResponse == 5) {
								//searches the large array list 
								searchingRequest = database.findRequest(requestWorkingList, searchingRequest, "general");
								
								//Prints out the items if they are found
								ArrayList<serviceRequest> newRequestList = new ArrayList<serviceRequest>();
								if (searchingRequest== null) {
									System.out.println("There are no structural request \n");
									break;
								}
								else {
									newRequestList.add(searchingRequest);
									
									for(serviceRequest request : newRequestList) {
										
										System.out.println("Customer's name: " + request.getCustomerName());
										System.out.println("Date of iss was created: " + request.getDateOfIssue());
										System.out.println("Status: " + request.getStatus());
										System.out.println("Problem: " + request.getDescOfIssue());
										System.out.println("Address: " + request.getIssueAddress());
										System.out.println("Responding Employee: " + request.getEmployeeName());
										System.out.println("Case Id: " + request.getCaseID() + "\n");

										}
								}
							}
							
							break;
		
							
							case 2:	//Displays ALL Requests
								
								for (serviceRequest allRequest : requestWorkingList) {
								System.out.println("Customer's name: " + allRequest.getCustomerName());
								System.out.println("Date of iss was created: " + allRequest.getDateOfIssue());
								System.out.println("Status: " + allRequest.getStatus());
								System.out.println("Problem: " + allRequest.getDescOfIssue());
								System.out.println("Address: " + allRequest.getIssueAddress());
								System.out.println("Responding Employee: " + allRequest.getEmployeeName());
								System.out.println("Case Id: " + allRequest.getCaseID() + "\n");

								}
								break;
								
							case 3:
								
								break;
								
							default:
								//If the user does not enter the correct input they will receive this error message
					        	System.out.println("============================");
					        	System.out.println("Please enter a valid response: 1, 2, 3");
					        	System.out.println("============================");
					        	//prompts them again for the correct response 
					        	System.out.println("1. Veiw all of one request type");
						        System.out.println("2. Veiw all request types");
						        System.out.println("3. Main menu \n");
						        nextResponse = userInput.nextInt();
							}
		    	break;
				
		    	//ends the program
				case 'D':
					
					exitKey = "D";
					break;
		
				default:
					//If the user does not enter the correct input they will receive this error message
		        	System.out.println("============================");
		        	System.out.println("Please enter a valid response: A, B, C, D");
		        	System.out.println("============================");
		        	
		        	//Prompts user for the correct response
		    		System.out.println("A. Create a new service request");
		            System.out.println("B. modify current service requests");
		            System.out.println("C. Veiw all service requests");
		            System.out.println("D. Exit \n");
		            response = userInput.next().charAt(0);
		            option = Character.toUpperCase(response);
				}
			}while((exitKey != "D") || (exitKey != "D"));
			
			System.out.println("You have been successfully logged out! \n");
			System.out.println("All your information has been updated in the text file.");
			
			//exports the modified lists
			database.exportEmployee(employeeWorkingList);
			database.exportCustomer(customerWorkingList);
			database.exportRequest(requestWorkingList);
	        
			userInput.close();
		}

}