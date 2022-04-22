
//Created by Issaiah Graves

public class serviceRequest {
	
	String customerName;
	String respondingEmployee;
	String issueAddress;
	String dateOfIssue;
	String descOfIssue;
	String typeOfIssue;
	String statusOfIssue;
	String caseID;
	
	//Constant used for skipping to the next value
	final int next = 1;
	
	public serviceRequest() {
		
		customerName = "N/A";
		respondingEmployee = "N/A";
		issueAddress = "N/A";
		dateOfIssue = "000";
		typeOfIssue = "N/A";
		statusOfIssue = "N/A";
	}
	
	public serviceRequest(String customerName, String responder, String type){
		
		this.customerName = customerName;
		respondingEmployee = responder;
		typeOfIssue = type;
		
	}
public void resetFactory(){
		
		customerName = "Empty Case";
		respondingEmployee = "N/A";
		issueAddress = "N/A";
		dateOfIssue = "000";
		typeOfIssue = "N/A";
		statusOfIssue = "N/A";
	}
	

	//Finds the information in the ServiceRequest.txt file 
	public String findCustomer (String data) 
	{
		int colon1 = data.indexOf(':');
		int comma1 = data.indexOf(',');
		
		//stores the value in the name
		customerName = data.substring(colon1 + next, comma1);
		
		return customerName;
	}
	
	public String findEmployee (String data)
	{
		int colon1 = data.indexOf(':');
		int colon2 = data.indexOf(':', colon1 + next);
		
		int comma1 = data.indexOf(',');
		int comma2 = data.indexOf(',', comma1 + next);
		
		respondingEmployee = data.substring(colon2 + next, comma2);
		return respondingEmployee;
	}
	
	public String findAddress(String data)
	{
		
		int colon1 = data.indexOf(':');
		int colon2 = data.indexOf(':', colon1 + next);
		int colon3 = data.indexOf(':', colon2 +next);
		
		int comma1 = data.indexOf(',');
		int comma2 = data.indexOf(',', comma1 + next);
		int comma3 = data.indexOf(',', comma2 + next);
		
		issueAddress= data.substring(colon3  + next, comma3);
		
		return issueAddress;
	}
	
	public String findDate(String data)
	{
		
		int colon1 = data.indexOf(':');
		int colon2 = data.indexOf(':', colon1 + next);
		int colon3 = data.indexOf(':', colon2 +next);
		int colon4 = data.indexOf(':', colon3 +next);
		
		int comma1 = data.indexOf(',');
		int comma2 = data.indexOf(',', comma1 + next);
		int comma3 = data.indexOf(',', comma2 + next);
		int comma4 = data.indexOf(',', comma3 + next);
		
		dateOfIssue= data.substring(colon4  + next, comma4);
		
		return dateOfIssue;
	}
	
	public String findType (String data)
	{
		int parenthesis = data.indexOf('(');

		
		int parenthesistwo = data.indexOf(')', parenthesis + next);

		
		typeOfIssue= data.substring(parenthesis  + next, parenthesistwo );
		
		return typeOfIssue;
	}
	
	public String findDesc(String data)
	{
		int lineOne = data.indexOf('|');
		
		int lineTwo = data.indexOf('|', lineOne + 1);

		
		descOfIssue = data.substring(lineOne + next, lineTwo);
		
		return descOfIssue;
	}
	
	public String findStatus (String data)
	{
		int openBracket = data.indexOf('[');

		int closedBracket = data.indexOf(']');

		
		statusOfIssue = data.substring(openBracket + next, closedBracket);
		
		return statusOfIssue;
	}
	
	
	public String findCaseID(String data)
	{
		int lessThan =data.indexOf('<');
		int greaterThan = data.indexOf('>');
		
		caseID = data.substring(lessThan+ next, greaterThan);
		
		return caseID;
	}
	
	
	public void setCustomerName(String Name){
		
		this.customerName = Name;
	}
	
	public String getCustomerName(){
		
		return customerName;
		
	}
	
	public void setEmployeeName(String Name){
		
		this.respondingEmployee = Name;
		
	}
	
	public String getEmployeeName(){
		
		return respondingEmployee;
	}
	
	public void setIssueAddress(String address){
		
		this.issueAddress = address;
	}
	
	public String getIssueAddress(){
		
		return issueAddress;
	}
	
	public void setDateOfIssue (String dateOfIssue){
		
		this.dateOfIssue = dateOfIssue;
		
	}
	
	public String getDateOfIssue(){
		
		return dateOfIssue;
	}
	
	public void setDescOfIssue(String DESC){
		
		this.descOfIssue = DESC;
	}
	
	public String getDescOfIssue(){
		
		return descOfIssue;
	}
	
	public void setTypeOfIssue(String type){
		
		this.typeOfIssue = type;
	}
	
	public String getTypeOfIssue(){
		
		return typeOfIssue;
	}
	
	public void setStatus(String status){
		
		this.statusOfIssue = status;
	}
	
	public String getStatus(){
		
		return statusOfIssue;
	}
	
	public String getCaseID(){
		
		return caseID;
	}
	
	public void setCaseID(String caseID){
		this.caseID = caseID;
		
	}
	
	public String toString()
	{
		return "{customerName:" + customerName + ", "
				+ "Responding Employee:" + respondingEmployee + "," 
				+ "Issue Addres:" + issueAddress + ","
				+ "Date of Issue:" + dateOfIssue + ","
				+ "Type Of Issue:("  + typeOfIssue + "), " 
				+ "Problem:|" + descOfIssue + "|,"
				+ "Status of Issue:[" + statusOfIssue + "] , "+"Case ID:<" + caseID +">.}";
	}

	
}