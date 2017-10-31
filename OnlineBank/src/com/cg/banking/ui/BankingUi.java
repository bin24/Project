package com.cg.banking.ui;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.InputMismatchException;
import java.util.Scanner;

import com.cg.banking.bean.CustomerBean;
import com.cg.banking.bean.ServiceTrackerBean;
import com.cg.banking.bean.UserBean;
import com.cg.banking.service.BankingAdminServiceImpl;
import com.cg.banking.service.BankingServiceImpl;
import com.cg.banking.service.IBankingAdminService;
import com.cg.banking.service.IBankingService;
import com.cg.banking.bean.OnlineBean;
import com.cg.banking.bean.CustomerBean;
import com.cg.banking.bean.PayeeDetailsBean;
import com.cg.banking.bean.ServiceTrackerBean;
import com.cg.banking.exception.BankingApplicationException;





public class BankingUi {
	static Scanner sc=new Scanner(System.in);
	static UserBean details=null;
	static UserBean details1=null;
	static IBankingService service= new BankingServiceImpl();
	static int totalAttemptlogin=0;
	static int idCheck=0;
	
	
	
	
	static int res;
	
	static int rs;

	static  ServiceTrackerBean u = new ServiceTrackerBean();
	
	
	
  public static void main(String[] args){
	  
	  //login home page
	  while(true)
		{
			System.out.println("1.User Login");
			System.out.println("2.Admin Login");
			System.out.println("3.Forgot Password");
			System.out.println("4.Exit");
			System.out.println("Enter your choice");
			int choice=sc.nextInt();
			try {
			switch(choice)
			{
			case 1: 
				
				
					login();
			break;
			case 2:adminLogin();
			break;
			case 3:forgotPassword();
			break;
			case 4: System.exit(0);
			break;
				}
			}catch (BankingApplicationException | SQLException | IOException e) {
					System.out.println("Exception occured - "+e.getMessage());
				}
			
			}
	
	  
	  
}
	  



//rishab
private static void adminLogin() throws BankingApplicationException {
	IBankingAdminService service=new BankingAdminServiceImpl();
	BankingUi operation = new BankingUi();
	while(true){
	System.out.println(" -----------");
	System.out.println("|ADMIN LOGIN|");
	System.out.println(" -----------");
	System.out.println("Admin:Rishabh");
	System.out.println("Enter password");
	String password=sc.next();
	
	if(service.validateAdmin(password))
	{
	
	
		while(true){
		System.out.println("***************");
		System.out.println(" --------------");
		System.out.println("|ADMIN FUNCTIONS|");
		System.out.println(" --------------");
		System.out.println("***************");
		System.out.println("Enter Your Choice");
		
		System.out.println("\n1.Create New Account\n2.Retrive Transcations\n3.Update Account\n4.Delete Account\n5.Exit");
		int ch = sc.nextInt();
		switch(ch){
		case 1:
			operation.createNewAcc();
			break;
		case 2:
			operation.reteriveTrans();
			break;
		case 3:
			operation.updateAcc();
			break;
		case 4:
			operation.deleteAcc();
		case 5:
			System.exit(0);
		}}
	}}
	
	 
}



private void deleteAcc() throws BankingApplicationException {
	
	

	Scanner sc = new Scanner(System.in);
	
	
	{
		IBankingAdminService service=new BankingAdminServiceImpl();
	BankingUi operation = new BankingUi();
	System.out.println("enter the account no you want to delete");
	int accNo=sc.nextInt();
	if(service.validateId(accNo))
	{
		CustomerBean ub = new CustomerBean();
		ub.setAccNo(accNo);
		int res=service.deleteAcc(ub);
	
		System.out.println("account is deleted");

	
			
	
	}
	
	}
	
}

private void updateAcc() throws BankingApplicationException{
	
	Scanner sc = new Scanner(System.in);
	BankingUi operation = new BankingUi();
	

	System.out.println("**********************");
	System.out.println(" ----------------");
	System.out.println("|UPDATION DETAILS|");
	System.out.println(" ----------------");
	System.out.println("**********************");
	System.out.println("\n1.Update Account Balance\n2.Update Name\n3.Update Email\n4.Update Address\n5.Update Pancard\n6.Update MobileNo\n7.Exit");
	int ch1= sc.nextInt();
	switch(ch1){
	case 1:
		updateAccBal();
		break;
	case 2:
		updateName();
		break;
	case 3:
		updateEmail();
		break;
	case 4:
		updateAddress();
		break;
	case 5:
		updatePancard();
		break;
	case 6:
		updateMobileno();
		break;
	case 7:
		System.exit(0);
	}
	}
	
	


private void updateMobileno() throws BankingApplicationException{
	
	Scanner sc = new Scanner(System.in);
	
	IBankingAdminService service=new BankingAdminServiceImpl();
	System.out.println("Enter the Acc id u want to update");
	int accNo=sc.nextInt();
	if(service.validateId(accNo))
	{
	
	System.out.println("Enter MobileNo");
	String mobile =sc.next();
	CustomerBean ub = new CustomerBean();
	ub.setAccNo(accNo);
	ub.setMobile(mobile);
	int res=service.updateMobileno(ub);
	System.out.println("Mobile No is updated");


	}
	
}
private void updatePancard() throws BankingApplicationException{

	Scanner sc = new Scanner(System.in);
	
	IBankingAdminService service=new BankingAdminServiceImpl();
	System.out.println("Enter the Acc id u want to update");
	int accNo=sc.nextInt();
	if(service.validateId(accNo))
	{
	
	System.out.println("Enter Pancard no");
	String pancard=sc.next();
	CustomerBean ub = new CustomerBean();
	ub.setAccNo(accNo);
	ub.setPancard(pancard);
	int res=service.updatePancard(ub);
	System.out.println("Pancard is updated");	
	}
	


	
	}
private void updateAddress() throws BankingApplicationException{
	
	Scanner sc = new Scanner(System.in);
	
	IBankingAdminService service=new BankingAdminServiceImpl();
	System.out.println("Enter the Acc id u want to update");
	int accNo=sc.nextInt();
	if(service.validateId(accNo))
	{
	
	System.out.println("Enter Address");
	String address=sc.next();
	CustomerBean ub = new CustomerBean();
	ub.setAccNo(accNo);
	ub.setAddress(address);
	int res=service.updateAddress(ub);
	System.out.println("Address is updated");
	}
	
	
}
private void updateEmail() throws BankingApplicationException{

	Scanner sc = new Scanner(System.in);
	IBankingAdminService service=new BankingAdminServiceImpl();
	System.out.println("Enter the Acc id u want to update");
	int accNo=sc.nextInt();
	if(service.validateId(accNo))
	{
	
	System.out.println("Enter Email");
	String email=sc.next();
	CustomerBean ub = new CustomerBean();
	ub.setAccNo(accNo);
	ub.setEmail(email);
	int res=service.updateEmail(ub);
	System.out.println("Email is updated");
}
}
private void updateName() throws BankingApplicationException{
	
	Scanner sc = new Scanner(System.in);
	IBankingAdminService service=new BankingAdminServiceImpl();
	System.out.println("Enter the Acc id u want to update");
	int accNo=sc.nextInt();
	if(service.validateId(accNo))
	{
	
	System.out.println("Enter name");
	String name=sc.next();
	CustomerBean ub = new CustomerBean();
	ub.setAccNo(accNo);
	ub.setName(name);
	int res=service.updateName(ub);
	System.out.println("Name is updated");
	
}
}
private void updateAccBal() throws BankingApplicationException{
	
	Scanner sc = new Scanner(System.in);
	IBankingAdminService service=new BankingAdminServiceImpl();
	System.out.println("Enter the Acc id u want to update");
	int accNo=sc.nextInt();
	if(service.validateId(accNo))
	{
	
	System.out.println("Enter account balance");
	int accbal=sc.nextInt();
	CustomerBean ub = new CustomerBean();
	ub.setAccNo(accNo);
	ub.setAccbal(accbal);
	int res=service.updateAccBal(ub);
	System.out.println("Account balance is updated");
	}}


private void reteriveTrans() throws BankingApplicationException{
	
	Scanner sc = new Scanner(System.in);
	BankingUi operation = new BankingUi();

	System.out.println("**********************");
	System.out.println(" -------------------");
	System.out.println("|TRANSACTION DETAILS|");
	System.out.println(" -------------------");
	System.out.println("**********************");
	System.out.println("\n1.Daily Trans\n2.Monthly Trans\n3.Quaterly Trans\n4.Yearly Trans\n5.Exit");
	int ch1= sc.nextInt();
	switch(ch1){
	case 1:
		reteriveDaily();
		break;
	case 2:
		reteriveMonthly();
		break;
	case 3:
		reteriveQuaterly();
		break;
	case 4:
		reteriveYearly();
		break;
	case 5:
		System.exit(0);
	}

}
private void reteriveQuaterly() throws BankingApplicationException {
	
	IBankingAdminService service=new BankingAdminServiceImpl();
	System.out.println("These are the quaterly details");
	System.out.println("\nTransaction_ID\tTran_description\tDateofTransaction\tTranAmount\tAccount_No");
	ArrayList<OnlineBean> al=service.reteriveQuaterly();
	for(OnlineBean ub1:al){
		System.out.print(ub1.getTransactionId()+"\t\t\t");	
		System.out.print(ub1.getTransactionDescription()+"\t\t");
		System.out.print(ub1.getDateOfTransaction()+"\t\t");
		System.out.print(ub1.getTransactionamount()+"\t\t");
		System.out.println(ub1.getAccountNumber());
		
	}
	
}
private void reteriveYearly() throws BankingApplicationException
{
	
	IBankingAdminService service=new BankingAdminServiceImpl();
	System.out.println("These are the yearly details");
	System.out.println("\nTransaction_ID\tTran_description\tTransactionType\tTranAmount\tAccount_No");

	ArrayList<OnlineBean> al=service.reteriveYearly();
	for(OnlineBean ub1:al){
		System.out.print(ub1.getTransactionId()+"\t\t\t");	
		System.out.print(ub1.getTransactionDescription()+"\t\t");
		System.out.print(ub1.getDateOfTransaction()+"\t\t");
		System.out.print(ub1.getTransactionamount()+"\t\t");
		System.out.println(ub1.getAccountNumber());
		
			
	}
	
}
private void reteriveMonthly() throws BankingApplicationException{
	
	IBankingAdminService service=new BankingAdminServiceImpl();
	System.out.println("These are the monthly details");
	System.out.println("\nTransaction_ID\tTran_description\tDateofTransaction\tTranAmount\tAccount_No");
	ArrayList<OnlineBean> al=service.reteriveMonthly();
	for(OnlineBean ub1:al){
		System.out.print(ub1.getTransactionId()+"\t\t\t");	
		System.out.print(ub1.getTransactionDescription()+"\t\t");
		System.out.print(ub1.getDateOfTransaction()+"\t\t");
		System.out.print(ub1.getTransactionamount()+"\t\t");
		System.out.println(ub1.getAccountNumber());
	}
	
	
}
private void reteriveDaily() throws BankingApplicationException{
	IBankingAdminService service=new BankingAdminServiceImpl();
	System.out.println("These are the daily details");
	System.out.println("\nTransaction_ID\tTran_description\tDateofTransaction\tTranAmount\tAccount_No");
	ArrayList<OnlineBean> al=service.reteriveDaily();
	for(OnlineBean ub1:al){
		System.out.print(ub1.getTransactionId()+"\t\t\t");	
		System.out.print(ub1.getTransactionDescription()+"\t\t");
		System.out.print(ub1.getDateOfTransaction()+"\t\t");
		System.out.print(ub1.getTransactionamount()+"\t\t");
		System.out.println(ub1.getAccountNumber());	
	}
	
}
private void createNewAcc() throws BankingApplicationException{
	// TODO Auto-generated method stub
	
		IBankingAdminService service=new BankingAdminServiceImpl();
	Scanner sc = new Scanner(System.in);
	System.out.println("Enter name:");
	String name=sc.next();
	name+=sc.nextLine();
	if(service.validateName(name))
	{
	System.out.println("Enter Email :");
	String email=sc.next();
	if(service.validateEmail(email))
	{
	System.out.println("Enter Address:");
	String address=sc.next();
	address+=sc.nextLine();
	if(service.validateAddress(address))
	{
	System.out.println("Enter pancard number");
	String pancard=sc.next();
	System.out.println("Enter Mobile Number :");
	String mobile=sc.next();
	if(service.validatemob(mobile))
	{
	System.out.println("Enter Account Type:1.Savings 2.Current");
	int acctype=sc.nextInt();
	if(service.validateacctype(acctype))
	{
	System.out.println("Enter Account Balance:");
	int accbal=sc.nextInt();
	if(service.validateBal(accbal))
	{
	System.out.println(" Open Date is :");
	String date = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(Calendar.getInstance().getTime());
    System.out.println( new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(Calendar.getInstance().getTime()) );
	
	
	CustomerBean ub = new CustomerBean(name, email, address, pancard, mobile, acctype, accbal,date);
	int res=service.createNewAcc(ub);
	System.out.println("Account is inserted");
	
	}
			}
		}
			}
		}
	}
	
	
	
	
	
	
	
}




private static void changePassword(int userId) throws BankingApplicationException
{
	//accept to change password
	
	System.out.println("Enter new password:- ");
	String newPassword=sc.next();
	System.out.println("Re-Enter new password:- ");
	String reEnterNewPassword=sc.next();
	
	//matching password from service
	
	if(service.checkPassword(newPassword, reEnterNewPassword))
	{
		details=new UserBean(userId,newPassword);
		int res=service.updatePassword(details);
		
		//if res=0 then password not updated
		if(res==0)
		{
			System.out.println(" updated");
		}
		else
		{
			System.out.println("OK Password updated");
			
		}
	}
	else
	{
		System.out.println("Password doesnot matched");
	}
	
}




private static void login() throws BankingApplicationException, SQLException, IOException
	{
		//function to login
		
		System.out.println("Enter User Id:- ");
		String userIdString=sc.next();		
		int userId=Integer.parseInt(userIdString);
		
		System.out.println("Enter password:- ");
		String loginPassword=sc.next();
		
		//pass detail to bean
		details=new UserBean(userId,loginPassword);
		
		//check login detail in dao and get status
		
		boolean password=service.checkLogin(details);
		
		if(password==false)
		{
			
			System.out.println("Invalid Password!");
			
			
			//locking process for max attempt
			if(totalAttemptlogin>0)
			{
				//if other id then set attempt to 0
				if(idCheck!=userId)
				{
					totalAttemptlogin=0;
				}
			}
			// if same user id then increase value of attempt for particular id
			idCheck=userId;
			totalAttemptlogin++;
		}
		else
		{	
			totalAttemptlogin=0;
			
			// if login after reset through forgot password
			
			if(loginPassword.equals("sbq500#"))
			{
				//ask user to update
				
				System.out.println("Enter new password:- ");
				String newPassword=sc.next();
				System.out.println("Re-Enter new password:- ");
				String reEnterNewPassword=sc.next();
				
				
				if(service.checkPassword(newPassword, reEnterNewPassword))
				{
					details=new UserBean(userId,newPassword);
					int res=service.updatePassword(details);
					if(res==0)
					{
						System.out.println("Not updated");
					}
					else
					{
						System.out.println("OK Password updated");
						
					}
				}
				else
				{
					System.out.println("Password doesnot matched");
				}
				
				
				
			}
			else
			{
				//get all of account Id for other function to use
				long accountId=0;
				ArrayList<UserBean> listAccountId=null;
				details=new UserBean(userId);
				listAccountId =service.getAccountId(details);
				
				for(UserBean m:listAccountId)
				{
					accountId=m.getAccountId();
					
					System.out.println("Account ids are:-"+accountId);
					
					
				}
				
				//normal login
				//System.out.println("OK user");
				
					//display main login screen
				
				home(accountId,userId);
				
					
					
					
					}
				
		
			
			
		}
		//locking user for max attempt
		if(totalAttemptlogin==3)
		{
			details=new UserBean(userId);
			int res=service.updateLock(details);
			if(res>0)
			{
				System.out.println("Hi user-"+userId+". You have reached maximum attempt ");
			}
			
			
			
			
		}
		
		
	
	}






















private static void home(long accountId, int userId) throws SQLException, IOException 
{
	
	System.out.println("**************************************");
	System.out.println("1.View Statement");
	System.out.println("2.Change Address/Mobile No");
	System.out.println("3.Request for ChequeBook");
	System.out.println("4.Track Service Request");
	System.out.println("5.Fund transfer");
	System.out.println("6.Change Password");
	System.out.println("7.Exit");
	System.out.println("***************************************");

	System.out.println("Enter your choice");
	
	int choiceHome=sc.nextInt();
	try {
			switch(choiceHome)
				{
					case 1:viewStatement(accountId);
					break;
					
					case 2:
					changeAddressMobile(accountId);
				
					break;
				
					case 3:requestChequeBook(accountId);
					break;
					
					
					case 4:trackServiceRequest(accountId);
					break;
					
					case 5:fundTransferSystem();
					break;
				
					case 6:changePassword(userId);
					break;
				
					case 7: System.exit(0);
					break;
					
					

				}
	} catch (BankingApplicationException e) {
		// TODO Auto-generated catch block
		System.out.println("exception occured - "+e.getMessage());
	}
	
}














private static void forgotPassword() throws BankingApplicationException
	{
	String securityAnswer=null;
	String securityQuestion=null;
	String sAnswer=null;
	
	ArrayList<UserBean> list=null;
	System.out.println("Enter User Id:- ");
	String userIdString=sc.next();
	int userId=Integer.parseInt(userIdString);
	
	details=new UserBean(userId);
	
	list=service.changePassword(details);
	
	
	
	
	
	for(UserBean m:list)
	{
		securityQuestion=m.getSecretQuestion();
		System.out.println("Security Question - "+securityQuestion);
		securityAnswer=m.getSecretQuestionAnswer();
		
		System.out.println("Enter Security Answer:- ");
		sAnswer=sc.next();
		
	}
	
	if(service.checkSecurityAnswer(securityQuestion,securityAnswer,sAnswer))
	{
		details=new UserBean(userId);
		int res=service.updatePassword(details);
		
		System.out.println("Your new password is- sbq500# ");
	}
	else
	{
		System.out.println("Security answer not matched");
	}
	
	
	
	}



//home

//view by bindu
private static void viewStatement(long accountId) throws BankingApplicationException {
	
	System.out.println("View Mini/Detailed statement");
	System.out.println("-------------------");
	while(true)
	{
			System.out.println("************************");
			System.out.println("1.Detailed Statement:");
			System.out.println("2.Mini Statement:");
			System.out.println("3.Exit");
			System.out.println("*************************");
		
		System.out.println("Enter your choice");
		int choice=sc.nextInt();
		switch(choice)
		{
		case 1:viewMiniStatement(accountId);
			break;
		case 2:viewByLast(accountId);
			break;
		case 3:
			System.exit(0);
			break;
		
		}
	}
	
	
}




private static void viewByLast(long accountId) throws BankingApplicationException 
{	OnlineBean bean=new OnlineBean();
	System.out.println("Enter the account id");
	int id=sc.nextInt();
	
	if(id!=accountId)
	{
		System.out.println("Account id is not correct");
	}
	else
	{
	bean.setAccountNumber(id);
	ArrayList<OnlineBean> list=service.retriveLast(id);
	for(OnlineBean m:list)
	{
		System.out.println("Transaction Id: "+m.getTransactionId());
		System.out.println("Transaction Description: "+m.getTransactionDescription());
		System.out.println("Date of Transaction: "+m.getDateOfTransaction());
		System.out.println("Transaction Amount: "+m.getTransactionamount());
		
	}
	}
	
}
private static void viewMiniStatement(long accountId) throws BankingApplicationException
{
	OnlineBean bean=new OnlineBean();
	System.out.println("Enter the account id");
	int id=sc.nextInt();
	if(id!=accountId)
	{
		System.out.println("Account id is not correct");
	}
	else
	{
	
	bean.setAccountNumber(id);
	System.out.println("Enter the starting date(dd-MMM-yyyy)");
	String sd=sc.next();
	/*DateTimeFormatter formatter =  DateTimeFormatter.ofPattern("dd-MMM-yyyy");
	LocalDate sdate=LocalDate.parse(sd,formatter);*/
	System.out.println("Enter the end date(dd-MMM-yyyy)");
	String ed=sc.next();
	/*LocalDate edate=LocalDate.parse(ed,formatter);	 
	Date enddate=Date.valueOf(edate);*/
	
	ArrayList<OnlineBean> list=service.retriveDetails(id,sd,ed);
	for(OnlineBean m:list)
	{
		System.out.println("Transaction Id: "+m.getTransactionId());
		System.out.println("Transaction Description: "+m.getTransactionDescription());
		System.out.println("Date of Transaction: "+m.getDateOfTransaction());
		
		System.out.println("Transaction Amount: "+m.getTransactionamount());
		
	}
	
	}
	
}
// update mobile address by jyotsna
private static void changeAddressMobile(long accountId) throws BankingApplicationException 

{
	
	CustomerBean bean=new CustomerBean();
	bean.setAccNo(accountId);
	ArrayList<CustomerBean>list=service.getAddr(accountId);
	for(CustomerBean o:list)
	{
		System.out.println("\nYour Current Address is: "+o.getAddress());
		System.out.println("Your Current Mobile No. is: "+o.getMobile());
	}
	
	while(true)
	{
	System.out.println("\n1. Change address");
	System.out.println("2. Change mobile no.");
	System.out.println("3. Exit\n");
	System.out.println("Enter your choice");
	int choice=sc.nextInt();
	switch(choice)
	{
	case 1:
			System.out.println("Enter Account Id");
			long accNo=sc.nextInt();
		
		
			if(accNo!=accountId)
			{
			System.out.println("Account id is not correct");
			break;
			}
			else
			{
			System.out.println("\nEnter New Address:");
			String address=sc.next();
			address+=sc.nextLine();
			if(service.validateAddress(address))
			{
			bean.setAddress(address);
			int res=service.changeAddr(bean);
			if(res==1)
			{
				System.out.println("\nYour Updated Address is: "+bean.getAddress());
				ArrayList<CustomerBean>list1=service.getAddr(accNo);
				for(CustomerBean o:list1)
				{
					System.out.println("Your Current Mobile No. is: "+o.getMobile());
				}
			}
			}
			}
	break;
	case 2:
		
		System.out.println("Enter Account Id");
		int accNo1=sc.nextInt();
	
	
		if(accNo1!=accountId)
		{
		System.out.println("Account id is not correct");
		break;
		}
		else
		{
			System.out.println("\nEnter new Mobile No:");
			String mob=sc.next();
			mob+=sc.nextLine();			
			if(service.validatePhoneNo(mob))
			{
			bean.setMobile(mob);
			int result=service.changeMob(bean);
			if(result==1)
			{
				ArrayList<CustomerBean>list2=service.getAddr(accNo1);
				for(CustomerBean o:list2)
				{
					System.out.println("\nYour Current Address is: "+o.getAddress());
				}
				System.out.println("Your Updated Mobile No. is: "+bean.getMobile());

			}
			}
		}
	break;
	case 3:
			System.exit(0);
	break;
		}
	
	}
		
	}

	
	



//cheque book request by rohit

private static void requestChequeBook(long accountId) throws BankingApplicationException, SQLException, IOException
{
	
	while(true)
	{
		  System.out.println("1.Request chequebook");
		  System.out.println("2.Exit");
		  System.out.println("Enter your choice");
		  int choice = sc.nextInt();
		   switch (choice)
		   {
		   
		   case 1:
			   System.out.println("Enter your account id");
				int accountNo =sc.nextInt();

				/*if(accountId!=accountNo)
				{
					System.out.println("Account id is incorrect");
					break;
				}
				else
				{*/
					u.setAccountID(accountNo);
					u.setServiceDesc("Chequebook");
					
					
				res=service.requestforcheckbook(u);
				
				if(res==1)
				{
					
					rs = service.addDetails(u);
					
					System.out.println("Request for Cheque book has been Approved. Service id for chequebook request is :<"+rs+">");
				}
				else
				{
					System.out.println("sorry! account id does not exist");
				}
			   
			   break;
				
				
			  case 2:System.exit(0); 
			   break;
		   }
		  
		  
		  
		  
	  }

	
		 
}

//by avinash
private static void trackServiceRequest(long accountId) throws BankingApplicationException
{
	System.out.println("Service Tracking System");
	System.out.println("***********************************");
	while(true)
	{
		System.out.println("1.To select Account Number and to know Request.");
		System.out.println("2.Enter the service request number");
		System.out.println("3.To check the stauts of all service Request");
		System.out.println("4.To Enter A/C Number");
		System.out.println("5.20 Service Request raised in last 180 days");
		System.out.println("6.Exit");
		
		
		int choice = sc.nextInt();
		
		switch(choice)
		{
		case 1:
			fetchServiceRequestID(accountId);
			break;
		case 2:
			fetchServiceDetailsByID(accountId);
			break;
		case 3:
			statusOfAllRequest(accountId);
			break;
		case 4:
			fetchServiceDetailsByAccountID(accountId);
			break;
		case 5:
			getRequestHistory(accountId);
			break;
		case 6:
			System.exit(0);
			break;
		default:
			System.exit(0);
			break;
			
		}
		
	}
	
}

private static void fundTransferSystem() throws BankingApplicationException {
	System.out.println("Fund Transfer System");
	System.out.println("***********************************");
	System.out.println("Confirm you are Account Number");
	int accountID = sc.nextInt();		
	
	while(true)
	{
		
		System.out.println("1.Your own  bank account across India.");
		System.out.println("2.Fund Transfer Across Other account of same bank across india");
		System.out.println("3.Exit");

		
		int choice = sc.nextInt();
		
		switch(choice)
		{
		case 1:
			fundTransferOwnAcoount(accountID);
			break;
		case 2:
			fundTransferAcrossOtherAccount(accountID);
			break;
		case 3:
			System.exit(0);
			break;
		default:
			System.exit(0);
			break;
	
		}
		
	}
	
}



private static void fundTransferAcrossOtherAccount(int accountID) throws BankingApplicationException {
	
	
	
	
	
	while(true)
	{
		
		System.out.println("1.Add/Register Payee Details.");
		System.out.println("2.Fund Transfer for Registerd Payee.");
		System.out.println("3.Exit");

		
		int choice = sc.nextInt();
		
		switch(choice)
		{
		case 1:
			addPayeeDetails(accountID);
			break;
		case 2:
			
			fundTransferAcrossOtherbranch(accountID);
			
			
			break;
		default:
			System.exit(0);
			break;
	
		}
		
	}
	
	
}


private static void fundTransferAcrossOtherbranch(int accountID) throws BankingApplicationException {
	
	System.out.println("Registered Payee Details for the Account ID "+accountID);
	ArrayList<PayeeDetailsBean> list = null;
	list = service.getPayeeDetails(accountID);
	
	ArrayList<Integer> PayeeList = new ArrayList<Integer>();
	
	for(PayeeDetailsBean payeeBean:list){
		
		System.out.println("Account Holder Name is :" + payeeBean.getPayeeAccountName() );
		System.out.println("Payee Account ID :" + payeeBean.getPayeeAccountID());
		
	}
	
	System.out.println("Enter The Account number you want to transfer the money to:");
	int transferToAccount  = sc.nextInt();
	
	PayeeList = service.getPayeeAccount(accountID);
	
	if(PayeeList.contains(transferToAccount)){
		
	}else{
		System.out.println("Invalid Account ID...");
		fundTransferAcrossOtherAccount(accountID);
	}
		
	
	System.out.println("Enter the Amount to be transferd to the account " +transferToAccount);
	int transferAmount = sc.nextInt();
	
	if(transferAmount>100000){
		System.out.println("Fund Transfer Limit Reached");
		fundTransferAcrossOtherbranch(accountID);
		
	}
	
	
	
	int balance = service.getAccountBalance(accountID);
	int flagBalance = service.validateBalance(balance, transferAmount);
	
	if(flagBalance==1){
		
	}else{
		System.out.println("Balance not valid");
		fundTransferAcrossOtherAccount(accountID);
	}
	
	
	
	
	int fundStatus = service.transferFund(accountID,transferToAccount, transferAmount);
	System.out.println("Fund Transfer Successfull");
	
	fundTransferAcrossOtherAccount(accountID);
	
}




private static void addPayeeDetails(int accountID) throws BankingApplicationException {
	
	System.out.println("Enter the Payee Account ID");
	int payeeAccountID =sc.nextInt();
	System.out.println("Enter the Payee Account Name");
	String payeeAccountName = sc.next();
	
	ArrayList<Integer> AccountList = new ArrayList<Integer>();
	AccountList = service.validateAccount();
	
	if(AccountList.contains(payeeAccountID)){
		
	}else{
		System.out.println("Invalid Account Number:");
		addPayeeDetails(accountID);
	}
		
	
	int payeeStatus = service.registerPayee(accountID, payeeAccountID, payeeAccountName);
	System.out.println(payeeStatus+" Payee has been added.");
	
	System.out.println(payeeAccountID +" "+payeeAccountName+" "+accountID);
	
}


private static void fundTransferOwnAcoount(int accountID) throws BankingApplicationException {
	
	System.out.println("Enter the PAN Number:");
	String pan = sc.next();
	ArrayList<String> Panlist =new ArrayList<String>();
	Panlist = service.getPanDetails(accountID);
	if(Panlist.contains(pan)){
		
	}else{
		System.out.println(" Pancard Details is not Mapping...");
		fundTransferOwnAcoount(accountID);
	}
	
	
	
	

	ArrayList<Integer> listA = null;
	listA = service.getAccountNumber(pan);
	
	System.out.println("Account ID is :"+listA);
	
	System.out.println("Enter The Account number you want to transfer the money from:");
	int transferFromAccount  = sc.nextInt();
	
	if(listA.contains(transferFromAccount)){
		
	}
	else{
		System.out.println("Invalid Account Number...");
		fundTransferOwnAcoount(accountID);
	}
	

	
	System.out.println("Enter The Account number you want to transfer the money to:");
	int transferToAccount  = sc.nextInt();
	
	if(listA.contains(transferToAccount)){
		
	}
	else{
		System.out.println("Invalid Account Number...");
		fundTransferOwnAcoount(accountID);
	}
	
	
	
	System.out.println("Enter the Amount to be transferd to the account "+transferToAccount);
	int transferAmount = sc.nextInt();
	

	
	/*System.out.println("Enter the password: ");
	String transPass = sc.next();*/
	
	
	
	int balance = service.getAccountBalance(accountID);
	System.out.println("Your balance is "+balance);
	
	int flagBalance = service.validateBalance(balance,transferAmount);
	if(flagBalance==1){
		
	}else{
		System.out.println("Insufficent Balance..");
		fundTransferOwnAcoount(accountID);
	}
	

	int fundStatus = service.transferFund(transferFromAccount,transferToAccount, transferAmount);
	System.out.println("FundTransfer Successfull");
}


private static void getRequestHistory(long accountId) throws BankingApplicationException {
	System.out.println("Confirm Account id:- ");
	int accId=sc.nextInt();
	if(accId!=accountId)
	{
		System.out.println("Invalid account id");
	}
	else
	{
	
	ArrayList<ServiceTrackerBean> list = null;
	list = service.getRequestHistory(accId);
	
	for(ServiceTrackerBean bean:list){
		System.out.println("Account ID is: " +bean.getAccountID());
		System.out.println("Service ID " +bean.getServiceID());
		System.out.println("Service Request: "+bean.getServiceDesc());
		System.out.println("Service Requested on: "+bean.getServiceRaisedDate());
		System.out.println("Service status: "+bean.getServiceStatus());
		System.out.println("");
		System.out.println("--------------------------------");
		System.out.println("");
	}
	}
}


private static void fetchServiceRequestID(long accountId) throws BankingApplicationException {
	
	System.out.println("Enter the Account ID");
	int accountIdUser = sc.nextInt();
	
	if(accountIdUser!=accountId)
	{
		System.out.println("Invalid accound id");
	}
	else
	{
	
	ArrayList<ServiceTrackerBean> list = null;
	list = service.fetchServiceRequestID(accountIdUser);
	
	for(ServiceTrackerBean bean:list){
		System.out.println("Service ID " +bean.getServiceID());
	}
	}
	
}

	


private static void statusOfAllRequest(long accountId) throws BankingApplicationException {
	
	System.out.println("confirm your account id:-");
	int accId=sc.nextInt();
	if(accId!=accountId)
	{
		System.out.println("Invalid account id");
	}
	
	else
	{
	
	ArrayList<ServiceTrackerBean> list = null;
	list = service.statusOfAllRequest(accId);
	
	for(ServiceTrackerBean bean:list){
		System.out.println("Account ID is: " +bean.getAccountID());
		System.out.println("Service ID " +bean.getServiceID());
		System.out.println("Service Request: "+bean.getServiceDesc());
		System.out.println("Service Requested on: "+bean.getServiceRaisedDate());
		System.out.println("Service status: "+bean.getServiceStatus());
		System.out.println("");
		System.out.println("--------------------------------");
		System.out.println("");
	}
	}
	
}


private static void fetchServiceDetailsByAccountID(long accountId) throws BankingApplicationException {
	
	
	System.out.println("Enter the Account ID");
	int accId = sc.nextInt();
	
	if(accountId!=accId)
	{
		System.out.println("Invalid account id");
	}
	else
	{
	
	ArrayList<ServiceTrackerBean> list = null;
	list = service.fetchServiceDetailsByAccountID(accId);
	
	for(ServiceTrackerBean bean:list){
		System.out.println("Account ID is: " +bean.getAccountID());
		System.out.println("Service ID " +bean.getServiceID());
		System.out.println("Service Request: "+bean.getServiceDesc());
		System.out.println("Service Requested on: "+bean.getServiceRaisedDate());
		System.out.println("Service status: "+bean.getServiceStatus());
		System.out.println("");
		System.out.println("--------------------------------");
		System.out.println("");
	}
	}
	
}


private static void fetchServiceDetailsByID(long accountId) throws BankingApplicationException {
	
	System.out.println("Confirm you Account Id:- ");
	long accId=sc.nextLong();
	
	if(accId!=accountId)
	{
		System.out.println("invalid account id");
	}
	
	else
	{
	
	System.out.println("Enter the Service ID You want to track");
	int serviceID = sc.nextInt();
	
	ArrayList<ServiceTrackerBean> list = null;
	list = service.fetchServiceDetailsByID(serviceID);
	
	for(ServiceTrackerBean bean:list){
		
		System.out.println("Account ID is: " +bean.getAccountID());
		System.out.println("Service ID " +bean.getServiceID());
		System.out.println("Service Request: "+bean.getServiceDesc());
		System.out.println("Service Requested on: "+bean.getServiceRaisedDate());
		System.out.println("Service status: "+bean.getServiceStatus());
		System.out.println("");
		System.out.println("-----------------------------------------");
		System.out.println("");
	}
	
	}
	}


  
}


	

	












