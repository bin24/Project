package com.cg.banking.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;



import java.sql.Statement;
import java.time.Month;
import java.util.ArrayList;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import com.cg.banking.bean.CustomerBean;
import com.cg.banking.bean.OnlineBean;
import com.cg.banking.bean.UserBean;
import com.cg.banking.dbUtil.dbUtil;
import com.cg.banking.exception.BankingApplicationException;
import com.cg.banking.bean.CustomerBean;
import com.cg.banking.bean.PayeeDetailsBean;
import com.cg.banking.bean.ServiceTrackerBean;

/**
 * Author		:	@author sn825940
 * Class Name	:	DonorImplDAO
 * Package		:	com.igate.donorapplication.dao
 * Date			:	Sep 12, 2014
 */




public class BankingDaoImpl implements IBankingDao {
	
	Connection conn=null;
	
	
	Logger logger=Logger.getRootLogger();
	public BankingDaoImpl()
	{
		PropertyConfigurator.configure("log4j.properties");
	}
	//---------------- 1. Check Login details ---------------
		/**************************************************************
		 - Method Name		:	checkLogin()
		 - Input Parameters	:	UserBean
		 - Return Type		:	boolean
		 - Throws			:   BankingApplicationException
		 - Author			:	Emp-ID: 135699
		 - Creation Date	:	14/10/2017
		 - Description		:	Check Login details of the user 
		 *************************************************************/	
	


	@Override
	public boolean checkLogin(UserBean bean) throws BankingApplicationException 
	{
		
		
		try {
			
			conn=dbUtil.getConnection();

		String sql="Select * from user_details where user_id=? and login_password=?";
		
		PreparedStatement pst=conn.prepareStatement(sql);
		
		pst.setInt(1,bean.getUserId());
		pst.setString(2,bean.getLoginPassword());
		
		ResultSet rs=pst.executeQuery();
		
		if(rs.next()==false)
		{
			return false;
		}
		else
		{		
			if(rs.getString(7).equals("N"))
			{
				return false;
			}
			else
			{
				logger.info("Executed succesfully");
				return true;
			}
			
		}
		
		} 
		catch (IOException e) {
			
			logger.error("Exception occured- "+e.getMessage());
			
			throw new BankingApplicationException("INVALID INPUT");
		}
		
		catch (SQLException e) {
			
			logger.error("Exception occured"+e.getMessage());
			throw new BankingApplicationException("Could not retrieve login details");
		}
		
		
		
	}





	@Override
	public ArrayList<UserBean> changePassword(UserBean bean) throws BankingApplicationException
	{
		ArrayList<UserBean> list=new ArrayList<UserBean>();
		try {
			conn=dbUtil.getConnection();
		String secretQuestionAnswer="null";
		String secretQuestion="null";

		String sql="Select * from user_details where user_id=?";
		
		PreparedStatement pst=conn.prepareStatement(sql);
		
		pst.setInt(1,bean.getUserId());
		
		
		ResultSet rs=pst.executeQuery();
		
		while(rs.next())
		{
			
			 
			secretQuestion =rs.getString(4);
			secretQuestionAnswer=rs.getString(5);
			
		}
		
		list.add(new UserBean(secretQuestion,secretQuestionAnswer));	
			
		logger.info("Executed succesfully");
		
		}
		
		catch (IOException e) {
			
			logger.error("Exception occured"+e.getMessage());
			
			throw new BankingApplicationException("INVALID INPUT");
		}
		
		catch (SQLException e) {
			logger.error("Exception occured"+e.getMessage());
			
			throw new BankingApplicationException("Could not change the password");
		}
		return list;
		
			
	
	}





	@Override
	public int updatePassword(UserBean bean) throws BankingApplicationException
	{
		try {
			conn=dbUtil.getConnection();
		
		String updateQuery="update user_details set login_password=? where user_id=?";
		
		
		
		PreparedStatement ps=conn.prepareStatement(updateQuery);
		
		if(bean.getLoginPassword()==null)
		{
			ps.setString(1,"sbq500#");
			
			ps.setInt(2,bean.getUserId());
		}
		else
		{
			ps.setString(1,bean.getLoginPassword());
			
			ps.setInt(2,bean.getUserId());
		}
		
		
		//int result=ps.executeUpdate();
		logger.info("Executed succesfully");
		return ps.executeUpdate();
		
		
		}
		
		catch (IOException e) {
			logger.error("Exception occured"+e.getMessage());
			
			throw new BankingApplicationException("INVALID INPUT");
		}
		
		catch (SQLException e) {
			logger.error("Exception occured"+e.getMessage());
			
			throw new BankingApplicationException("Could not update the password");
		}
		//return result;
	}





	@Override
	public int updateLock(UserBean bean) throws BankingApplicationException{
		
			int lockResult=0;
		try {
			conn=dbUtil.getConnection();
		
		String updateQuery="update user_details set lock_status=? where user_id=?";
		
		
		
		PreparedStatement ps=conn.prepareStatement(updateQuery);
		
		
	
			ps.setString(1,"N");
			
			ps.setInt(2,bean.getUserId());
		
		
		
		 lockResult=ps.executeUpdate();
		 logger.info("Executed succesfully");
		
		
		}
		
		catch (IOException e) {
			logger.error("Exception occured"+e.getMessage());
			throw new BankingApplicationException("INVALID INPUT");
		}
		
		catch (SQLException e) {
			logger.error("Exception occured"+e.getMessage());
			throw new BankingApplicationException("Could not update the Lock");
		}
		return lockResult;
		
	}





	@Override
	public ArrayList<UserBean> getAccountId(UserBean bean) throws BankingApplicationException{
		
		long accountId=0;
		
		ArrayList<UserBean> list=new ArrayList<UserBean>();
		try {
			conn=dbUtil.getConnection();
		
		String sql="Select * from user_details where user_id=?";
		
		PreparedStatement pst=conn.prepareStatement(sql);
		
		pst.setInt(1,bean.getUserId());
		
		
		ResultSet rs=pst.executeQuery();
		
		while(rs.next())
		{
			
			 
			 accountId=rs.getLong(1);
			
		}
		
		list.add(new UserBean(accountId));	
		logger.info("Executed succesfully");
			
		
		}
		catch (IOException e) {
			logger.error("Exception occured"+e.getMessage());
			
			throw new BankingApplicationException("INVALID INPUT");
		}
		
		catch (SQLException e) {
			logger.error("Exception occured"+e.getMessage());
			
			throw new BankingApplicationException("Could not retrieve Account Id");
		}
		return list;
		
	}
	
	//bindu
	@Override
	public ArrayList<OnlineBean> retriveDetails(int id, String startdate,String enddate) throws BankingApplicationException {
		
		/*	System.out.println("Your id is "+id);
			int day = startdate.getDayOfMonth();
			Month month = startdate.getMonth();
			int year = startdate.getYear();
			String sDateToPass = day +"-"+month+"-"+ year;
			day = enddate.getDayOfMonth();
			month = enddate.getMonth();
			year = enddate.getYear();
			String eDateToPass = day +"-"+month+"-"+ year;
			System.out.println(eDateToPass);*/
			
			Connection conn;
			ArrayList<OnlineBean> list=new ArrayList<OnlineBean>();
			try {
				conn = dbUtil.getConnection();
			
			String sql="Select * from Transaction where ACCOUNTID=? and DATEOFTRANSFER >=? and DATEOFTRANSFER <=?";
			
			
			PreparedStatement stmt=conn.prepareStatement(sql);
			
			stmt.setInt(1, id);
			stmt.setString(2, startdate);
			stmt.setString(3, enddate);
			
			ResultSet rs=stmt.executeQuery();
			
			while(rs.next())
			{
				int tid=rs.getInt(2);
				String desc=rs.getString(3);
				String dat=rs.getString(4);
				int transAmount=rs.getInt(5);
				list.add(new OnlineBean(tid,desc,dat,transAmount));
				logger.info("Executed succesfully");
			}
			
			}
			catch (IOException e) {
				logger.error("Exception occured"+e.getMessage());
				
				throw new BankingApplicationException("INVALID INPUT");
			}
			
			catch (SQLException e) {
				logger.error("Exception occured"+e.getMessage());
				
				throw new BankingApplicationException("Could not retrieve transaction details");
			}
			return list;
	}

	@Override
	public ArrayList<OnlineBean> retriveLast(int id) throws BankingApplicationException {
		Connection conn;
		ArrayList<OnlineBean> list=new ArrayList<OnlineBean>();
		try {
			conn = dbUtil.getConnection();
		
		String sql="SELECT *  FROM (SELECT * FROM Transaction ORDER  BY transactionid DESC) WHERE ROWNUM <=10 and ACCOUNTID=?";
		
		PreparedStatement stmt=conn.prepareStatement(sql);
		stmt.setInt(1, id);
		ResultSet rs=stmt.executeQuery();
		while(rs.next())
		{
			int tid=rs.getInt(2);
			String desc=rs.getString(3);
			String dat=rs.getString(4);
			int transAmount=rs.getInt(5);
			list.add(new OnlineBean(tid,desc,dat,transAmount));
			logger.info("Executed succesfully");
		}
		
		}
		catch (IOException e) {
			logger.error("Exception occured"+e.getMessage());
			throw new BankingApplicationException("INVALID INPUT");
		}
		
		catch (SQLException e) {
			logger.error("Exception occured"+e.getMessage());
			
			throw new BankingApplicationException("Could not retrieve transaction details");
		}
		return list;
	}	
	
	
	//jyotsna

	public ArrayList<CustomerBean> getAddr(long accountId) throws BankingApplicationException {
		
		ArrayList<CustomerBean> addr=new ArrayList<CustomerBean>();
		try
		{
			Connection conn = dbUtil.getConnection();
			String str="select address,mobile_no from customer where account_id=?";
			PreparedStatement ps=conn.prepareStatement(str);
			ps.setLong(1, accountId);
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				String address=rs.getString(1);
				String mob=rs.getString(2);
				addr.add(new CustomerBean(address,mob));	
				logger.info("Executed succesfully");
			}
			
		
		}
		catch (IOException e) {
			logger.error("Exception occured"+e.getMessage());
			
			throw new BankingApplicationException("INVALID INPUT");
		}
		
		catch (SQLException e) {
			logger.error("Exception occured"+e.getMessage());
			
			throw new BankingApplicationException("Could not retrieve address and mobile details");
		}
		return addr;
		
	}

	public int changeAddr(CustomerBean bean)  throws BankingApplicationException {
		int result=0;
	
			Connection conn;
			try {
				conn = dbUtil.getConnection();
			
			String str="update customer set address=? where account_id=?";
			PreparedStatement ps=conn.prepareStatement(str);
			ps.setString(1, bean.getAddress());
			ps.setLong(2, bean.getAccNo());

			result=ps.executeUpdate();
			logger.info("Executed succesfully");
			
			}
			catch (IOException e) {
				logger.error("Exception occured"+e.getMessage());
				throw new BankingApplicationException("INVALID INPUT");
			}
			
			catch (SQLException e) {
				logger.error("Exception occured"+e.getMessage());
				
				throw new BankingApplicationException("Could not update address");
			}
			return result;
			
	}
		

		
	

	@Override
	public int changeMob(CustomerBean bean)  throws BankingApplicationException {
		int result=0;
		
			Connection conn;
			try {
				conn = dbUtil.getConnection();
			
			String str="update customer set mobile_no=? where account_id=?";
			PreparedStatement ps=conn.prepareStatement(str);
			ps.setString(1, bean.getMobile());
			ps.setLong(2, bean.getAccNo());

			result=ps.executeUpdate();
			logger.info("Executed succesfully");
			}
			catch (IOException e) {
				logger.error("Exception occured"+e.getMessage());
				
				throw new BankingApplicationException("INVALID INPUT");
			}
			
			catch (SQLException e) {
				logger.error("Exception occured"+e.getMessage());
				
				throw new BankingApplicationException("Could not update mobile number");
			}
	
		return result;
	}

	@Override
	public int checkAccId(int accNo) throws BankingApplicationException {

		int count=0;
		
			Connection conn;
			try {
				conn = dbUtil.getConnection();
			
			
			String str="select account_id from customer";
			PreparedStatement ps=conn.prepareStatement(str);
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				int acc_id=rs.getInt(1);
				if(acc_id==accNo)
				{
					count=1;
					logger.info("Executed succesfully");
				}
				
			}
		}
			catch (IOException e) {
				logger.error("Exception occured"+e.getMessage());
				
				throw new BankingApplicationException("INVALID INPUT");
			}
			
			catch (SQLException e) {
				logger.error("Exception occured"+e.getMessage());
				
				throw new BankingApplicationException("Could not check account id");
			}
		return count;
	}
	
	//rohit
	
	
    int rows=0;
	private int result;
	private int flag = 0;
	

	@Override
	public int requestforcheckbook(ServiceTrackerBean u) throws SQLException, IOException {
		    
		conn=dbUtil.getConnection();
		 String result = null;
	    // int acc_id;
		 String sql1 = "select account_id from user_details";
		 PreparedStatement ps2 = conn.prepareStatement(sql1);
		 ResultSet rs = ps2.executeQuery();
		 
		 while(rs.next())
  	 {
			 
			 int acc_id = rs.getInt(1);
			 
				

			 if(acc_id != (u.getAccountID()))
			 {
				 flag  = 1;
				
				
			 }
			 else
			 {
				 flag = 1;
			 }
			 
		
  		
  	 }
		
		 return  flag;
	
	}


	@Override
	public int addDetails(ServiceTrackerBean u) throws BankingApplicationException {
		
		try {
			conn=dbUtil.getConnection();
		
			int rows=0;
		   String insertquery= "Insert into Service_Tracker values(chk_book.nextval,?,?,sysdate,'Open')";
		
			PreparedStatement ps= conn.prepareStatement(insertquery);
			ps.setString(1,u.getServiceDesc());
			ps.setInt(2,u.getAccountID());
		    
			rows = ps.executeUpdate();
			
			
			
			if(rows==1)
			{
			String sql = "Select chk_book.currval from service_tracker ";
			 PreparedStatement ps1 = conn.prepareStatement(sql);
			 ResultSet rs = ps1.executeQuery();
			 while(rs.next())
	    	 {
				 result = rs.getInt(1);
	    		
	    		 logger.info("Executed succesfully");
	    		
	    	 }
			
			
			}
		
			}
			
			catch (IOException e) {
				logger.error("Exception occured"+e.getMessage());
				throw new BankingApplicationException("INVALID INPUT");
			}
			
			catch (SQLException e) {
				logger.error("Exception occured"+e.getMessage());
				throw new BankingApplicationException("Could not insert into service detail");
			}
			
		return result;
	

	}



//avinash
	
int result1 = 0;
	
	@Override
	public ArrayList<ServiceTrackerBean> fetchServiceDetailsByID(int serviceID) throws BankingApplicationException {
		ArrayList <ServiceTrackerBean> list = new ArrayList<ServiceTrackerBean>();
		
			int Id = serviceID;
			Connection conn;
			try {
				conn = dbUtil.getConnection();
			
			String sql = "Select * from SERVICE_TRACKER where Service_ID="+Id;		
		
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery(sql);
			
			while(rs.next()){
				
				int ServiceId = rs.getInt(1);
				String ServiceDesc = rs.getString(2);
				int AccountID = rs.getInt(3);	
		  	    String ServiceDate = rs.getString(4);
		  	    String Status = rs.getString(5);
				
				list.add(new ServiceTrackerBean(AccountID,ServiceId,ServiceDesc,ServiceDate,Status));
				logger.info("Executed succesfully");
			}
			}
			catch (IOException e) {
				logger.error("Exception occured"+e.getMessage());
				throw new BankingApplicationException("INVALID INPUT");
			}
			
			catch (SQLException e) {
				logger.error("Exception occured"+e.getMessage());
				throw new BankingApplicationException("Could not get service detail from id");
			}
		
		
	
		return list;
	}

	public ArrayList<ServiceTrackerBean> fetchServiceDetailsByAccountID(int accountID) throws BankingApplicationException {
		ArrayList <ServiceTrackerBean> list = new ArrayList<ServiceTrackerBean>();
		try{
			int Id = accountID;
			Connection conn = dbUtil.getConnection();
			String sql = "Select * from SERVICE_TRACKER where ACCOUNT_ID="+Id;		
		
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery(sql);
			
			while(rs.next()){
				
				int ServiceId = rs.getInt(1);
				String ServiceDesc = rs.getString(2);
				int AccountID = rs.getInt(3);	
		  	    String ServiceDate = rs.getString(4);
		  	    String Status = rs.getString(5);
				
				list.add(new ServiceTrackerBean(AccountID,ServiceId,ServiceDesc,ServiceDate,Status));
				logger.info("Executed succesfully");
			}
		
		}
		catch (IOException e) {
			logger.error("Exception occured"+e.getMessage());
			throw new BankingApplicationException("INVALID INPUT");
		}
		
		catch (SQLException e) {
			logger.error("Exception occured"+e.getMessage());
			throw new BankingApplicationException("Could not get service detail from account id");
		}
	
		return list;
	}

	public ArrayList<ServiceTrackerBean> statusOfAllRequest(int accountID) throws BankingApplicationException {
		ArrayList <ServiceTrackerBean> list = new ArrayList<ServiceTrackerBean>();
		try{
			
			Connection conn = dbUtil.getConnection();
			String sql = "Select * from SERVICE_TRACKER where ACCOUNT_ID="+accountID;	
		
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery(sql);
			
			while(rs.next()){
				
				int ServiceId = rs.getInt(1);
				String ServiceDesc = rs.getString(2);
				int AccountID = rs.getInt(3);	
		  	    String ServiceDate = rs.getString(4);
		  	    String Status = rs.getString(5);
				
				list.add(new ServiceTrackerBean(AccountID,ServiceId,ServiceDesc,ServiceDate,Status));
				logger.info("Executed succesfully");
			}
		
		}
		catch (IOException e) {
			logger.error("Exception occured"+e.getMessage());
			throw new BankingApplicationException("INVALID INPUT");
		}
		
		catch (SQLException e) {
			logger.error("Exception occured"+e.getMessage());
			throw new BankingApplicationException("Could not get all service request");
		}
	
		return list;
	}

	public ArrayList<ServiceTrackerBean> fetchServiceRequestID(int accountID) throws BankingApplicationException{
		ArrayList <ServiceTrackerBean> list = new ArrayList<ServiceTrackerBean>();
		try{
			int Id = accountID;
			Connection conn = dbUtil.getConnection();
			String sql = "Select SERVICE_ID from SERVICE_TRACKER where ACCOUNT_ID="+Id;		
		
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery(sql);
			
			while(rs.next()){
				
				int ServiceId = rs.getInt(1);
				
				
				list.add(new ServiceTrackerBean(ServiceId));
				logger.info("Executed succesfully");
			}
		
		}
		catch (IOException e) {
			logger.error("Exception occured"+e.getMessage());
			throw new BankingApplicationException("INVALID INPUT");
		}
		
		catch (SQLException e) {
			logger.error("Exception occured"+e.getMessage());
			throw new BankingApplicationException("Could not fetch service request");
		}
	
		return list;
	}

	public ArrayList<ServiceTrackerBean> getRequestHistory(int accId) throws BankingApplicationException {
		ArrayList <ServiceTrackerBean> list = new ArrayList<ServiceTrackerBean>();
		try{
			
			Connection conn = dbUtil.getConnection();
			String sql = "select * from Service_Tracker  where (sysdate-SERVICE_RAISED_DATE)>180 AND ACCOUNT_ID="+accId;
		
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery(sql);
			
			while(rs.next()){
				
				int ServiceId = rs.getInt(1);
				String ServiceDesc = rs.getString(2);
				int AccountID = rs.getInt(3);	
		  	    String ServiceDate = rs.getString(4);
		  	    String Status = rs.getString(5);
				
				list.add(new ServiceTrackerBean(AccountID,ServiceId,ServiceDesc,ServiceDate,Status));
				logger.info("Executed succesfully");
			}
		
		}
		catch (IOException e) {
			logger.error("Exception occured"+e.getMessage());
			throw new BankingApplicationException("INVALID INPUT");
		}
		
		catch (SQLException e) {
			logger.error("Exception occured"+e.getMessage());
			throw new BankingApplicationException("Could not get service history");
		}
	
		return list;
	}

	public ArrayList<Integer> getAccountNumber(String pan) throws BankingApplicationException {
		//ArrayList <CustomerBean> list = new ArrayList<CustomerBean>();
		ArrayList <Integer> listA = new ArrayList<Integer>();
		
		try{
			String pancard = pan;
			Connection conn = dbUtil.getConnection();
			String sql = "select ACCOUNT_ID from CUSTOMER  where PANCARD=?" ;	
		
			 
			PreparedStatement st=conn.prepareStatement(sql);
			st.setString(1,pan);
			ResultSet rs = st.executeQuery();
			

			
			
			while(rs.next()){
				
				int accountID = rs.getInt(1);	
		  	   // String accountType = rs.getString(2);
		  	    
				
				listA.add(accountID);
				logger.info("Executed succesfully");
			}
		
		}
		catch (IOException e) {
			logger.error("Exception occured"+e.getMessage());
			throw new BankingApplicationException("INVALID INPUT");
		}
		
		catch (SQLException e) {
			logger.error("Exception occured"+e.getMessage());
			throw new BankingApplicationException("Could not get Account number");
		}
	
		return listA;
	}

	

	@Override
	public int registerPayee(int accountID, int payeeAccountID, String payeeAccountName) throws BankingApplicationException {
		int rowsAffected=0;
		try{
			
			Connection conn = dbUtil.getConnection();
			PreparedStatement st=conn.prepareStatement("insert into payeeDetails values(?,?,?)");
			st.setInt(1,accountID);
			st.setInt(2, payeeAccountID);
			st.setString(3, payeeAccountName);
			
			rowsAffected = st.executeUpdate();
			logger.info("Executed succesfully");

		}
		catch (IOException e) {
			logger.error("Exception occured"+e.getMessage());
			throw new BankingApplicationException("INVALID INPUT");
		}
		
		catch (SQLException e) {
			logger.error("Exception occured"+e.getMessage());
			throw new BankingApplicationException("Could not insert into payee detail");
		}
		return rowsAffected;
		
		
	}

	@Override
	public int transferFund(int transferFromAccount, int transferToAccount, int transferAmount) throws BankingApplicationException {
		int rowsAffected=0;
		
		try{
			
			Connection conn = dbUtil.getConnection();
			PreparedStatement stmt1=conn.prepareStatement("insert into FUNDTRANSFER values(?,?,?,?,?)");
			stmt1.setInt(1,transferFromAccount);
			stmt1.setInt(2,9990);
			stmt1.setInt(3,transferToAccount);
			java.sql.Timestamp date = new java.sql.Timestamp(new java.util.Date().getTime());
			stmt1.setTimestamp(4, date);
			
			stmt1.setInt(5,transferAmount);
			
						
			rowsAffected = stmt1.executeUpdate();
			
			PreparedStatement stmt2=conn.prepareStatement("insert into TRANSACTION values(?,transactionSeq.nextval,?,?,?)");
			stmt2.setInt(1,transferFromAccount);
			stmt2.setString(2,"FundTransferd");
			java.sql.Timestamp date1 = new java.sql.Timestamp(new java.util.Date().getTime());
			stmt2.setTimestamp(3, date1);
			stmt2.setInt(4,transferAmount);
			stmt2.executeUpdate();
			
			PreparedStatement stmt3=conn.prepareStatement("insert into TRANSACTION values(?,transactionSeq.nextval,?,?,?)");
			stmt3.setInt(1,transferToAccount);
			stmt3.setString(2,"FundReceived");
			java.sql.Timestamp date2 = new java.sql.Timestamp(new java.util.Date().getTime());
			stmt3.setTimestamp(3, date2);
			stmt3.setInt(4,transferAmount);
			stmt3.executeUpdate();
			
			PreparedStatement stmt4=conn.prepareStatement("Update ACCOUNTDETAILS SET LEDGERBALANCE = LEDGERBALANCE+? WHERE ACCOUNTNUMBER=?");
			stmt4.setInt(1,transferAmount);
			stmt4.setInt(2,transferToAccount);
			stmt4.executeUpdate();
			
			PreparedStatement stmt5=conn.prepareStatement("Update ACCOUNTDETAILS SET LEDGERBALANCE = LEDGERBALANCE-? WHERE ACCOUNTNUMBER=?");
			stmt5.setInt(1,transferAmount);
			stmt5.setInt(2,transferFromAccount);
			stmt5.executeUpdate();
			
			logger.info("Executed succesfully");

		}
		catch (IOException e) {
			logger.error("Exception occured"+e.getMessage());
			throw new BankingApplicationException("INVALID INPUT");
		}
		
		catch (SQLException e) {
			 
			logger.error("Exception occured"+e.getMessage());
			throw new BankingApplicationException("Fund transfer not successfull");
		}
		
		return rowsAffected;
	}

	@Override
	public ArrayList<PayeeDetailsBean> getPayeeDetails(int accountID) throws BankingApplicationException{
		ArrayList <PayeeDetailsBean> list = new ArrayList<PayeeDetailsBean>();
		try{
			
			Connection conn = dbUtil.getConnection();
			String sql = "select * from payeeDetails where AccountID=?" ;	
		
			
			PreparedStatement st=conn.prepareStatement(sql);
			st.setInt(1,accountID);
			ResultSet rs = st.executeQuery();
			

			
			
			while(rs.next()){
				
				int accountId = rs.getInt(1);	
		  	    int PayeeDetailId = rs.getInt(2);
		  	    String PayeeName = rs.getString(3);
		  	    
		  	    list.add(new PayeeDetailsBean(accountId,PayeeDetailId,PayeeName));
		  	  logger.info("Executed succesfully");
				
			}
		
		}
		catch (IOException e) {
			logger.error("Exception occured"+e.getMessage());
			throw new BankingApplicationException("INVALID INPUT");
		}
		
		catch (SQLException e) {
			logger.error("Exception occured"+e.getMessage());
			throw new BankingApplicationException("Could not get payee detail");
		}
	
		return list;
		
	}





	@Override
	public int getAccountBalance(int accountID) throws BankingApplicationException{
		int balance=0;
		try{
			
			Connection conn = dbUtil.getConnection();
			String sql = "select * from ACCOUNTDETAILS where ACCOUNTNUMBER=?" ;	
		
			
			PreparedStatement st=conn.prepareStatement(sql);
			st.setInt(1,accountID);
			ResultSet rs = st.executeQuery();
			while(rs.next()){
			balance = rs.getInt(4);
			logger.info("Executed succesfully");
			}
		
		}
		catch (IOException e) {
			logger.error("Exception occured"+e.getMessage());
			throw new BankingApplicationException("INVALID INPUT");
		}
		
		catch (SQLException e) {
			logger.error("Exception occured"+e.getMessage());
			throw new BankingApplicationException("Could not get account balance");
		}
	
		return balance;
	}





	@Override
	public ArrayList<String> getPanDetails(int accountID) throws BankingApplicationException {
		ArrayList<String> list = new ArrayList<String>();
		try{
			
			Connection conn = dbUtil.getConnection();
			String sql = "select * from CUSTOMER where ACCOUNT_ID=?" ;	
		
			
			PreparedStatement st=conn.prepareStatement(sql);
			st.setInt(1,accountID);
			ResultSet rs = st.executeQuery();
			

			
			
			while(rs.next()){
				
		  	    String pan = rs.getString(5);
		  	    
		  	    list.add(pan);
		  	    
		  	  logger.info("Executed succesfully");
				
			}
		
		}
		catch (IOException e) {
			logger.error("Exception occured"+e.getMessage());
			throw new BankingApplicationException("INVALID INPUT");
		}
		
		catch (SQLException e) {
			logger.error("Exception occured"+e.getMessage());
			throw new BankingApplicationException("Could not get PAN detail");
		}
	
		return list;
	}





	@Override
	public ArrayList<Integer> getPayeeAccount(int accountID) throws BankingApplicationException{
		ArrayList<Integer> listPayAcc = new ArrayList<Integer> ();
		try{
			
			Connection conn = dbUtil.getConnection();
			String sql = "select PAYEE_ACCOUNT_ID from  PAYEEDETAILS where ACCOUNTID=?" ;	
		
			
			PreparedStatement st=conn.prepareStatement(sql);
			st.setInt(1,accountID);
			ResultSet rs = st.executeQuery();
			

			
			
			while(rs.next()){
				
		  	    Integer pan = rs.getInt(1);
		  	    
		  	    listPayAcc.add(pan);
		  	  logger.info("Executed succesfully");
				
			}
		
		}
		catch (IOException e) {
			logger.error("Exception occured"+e.getMessage());
			throw new BankingApplicationException("INVALID INPUT");
		}
		
		catch (SQLException e) {
			logger.error("Exception occured"+e.getMessage());
			throw new BankingApplicationException("Could not get payee account id detail");
		}
	
		return listPayAcc;
	}



	@Override
	public ArrayList<Integer> validateAccount() throws BankingApplicationException {
		ArrayList<Integer> list = new ArrayList<Integer>();
		try{
			
			Connection conn = dbUtil.getConnection();
			String sql = "select * from CUSTOMER " ;	
		
			
			PreparedStatement st=conn.prepareStatement(sql);
			//st.setInt(1,accountID);
			ResultSet rs = st.executeQuery();
			

			
			
			while(rs.next()){
				
		  	    Integer pan = rs.getInt(1);
		  	    
		  	    list.add(pan);
		  	    
		  	  logger.info("Executed succesfully");
				
			}
		
		}
		catch (IOException e) {
			logger.error("Exception occured"+e.getMessage());
			throw new BankingApplicationException("INVALID INPUT");
		}
		
		catch (SQLException e) {
			logger.error("Exception occured"+e.getMessage());
			throw new BankingApplicationException("Could not get Account details");
		}
	
		return list;

	}

	

	
		
}
	
	


