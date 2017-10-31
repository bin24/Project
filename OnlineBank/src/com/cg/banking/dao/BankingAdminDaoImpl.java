package com.cg.banking.dao;

import java.io.IOException;
import java.sql.Connection;
import java.util.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import com.cg.banking.bean.CustomerBean;
import com.cg.banking.bean.OnlineBean;
import com.cg.banking.bean.UserBean;
import com.cg.banking.dbUtil.dbUtil;
import com.cg.banking.exception.BankingApplicationException;





public class BankingAdminDaoImpl implements IBankingAdminDao {
	
	
	Logger logger=Logger.getRootLogger();
	public BankingAdminDaoImpl()
	{
		PropertyConfigurator.configure("log4j.properties");
	}

	
	@Override
	public int createNewAcc(CustomerBean ub) throws BankingApplicationException{
		
		int nr = 0;
		Connection con;
		try {
			con = dbUtil.getConnection();
		
		
		String str = "INSERT Into Customer values(acc_id.nextval,?,?,?,?,?,?,?,?)";
		PreparedStatement pst = con.prepareStatement(str);
		pst.setString(1,ub.getName());	
		pst.setString(2,ub.getEmail());
		pst.setString(3,ub.getAddress());
		pst.setString(4,ub.getPancard());
		pst.setString(5,ub.getMobile());
		pst.setInt(6,ub.getAcctype());
		pst.setInt(7,ub.getAccbal());
		pst.setString(8,ub.getDate());
		
		
		
		
		nr = pst.executeUpdate();
		int accid = 0;
		//System.out.println(nr);
		
		
			String sql = "select acc_id.currval from Customer";
			Statement st = con.createStatement();
			ResultSet r = st.executeQuery(sql);
			while(r.next())
			{
				accid = r.getInt(1);
				logger.info("Executed succesfully");
			}
			
		
		} catch (IOException e) {
			
			logger.error("Exception occured- "+e.getMessage());
			
			throw new BankingApplicationException("INVALID INPUT");
		}
		
		catch (SQLException e) {
			
			logger.error("Exception occured- "+e.getMessage());
			
			throw new BankingApplicationException("Value not inserted in customer");
		}
	
		return nr;
	}

	@Override
	public ArrayList<OnlineBean> reteriveDaily() throws BankingApplicationException{
		// TODO Auto-generated method stub
		ArrayList<OnlineBean> al = new ArrayList<OnlineBean>();
		try{
		Connection con = dbUtil.getConnection();
		String str = "Select * From Transaction  WHERE (trunc(sysdate)=trunc(dateoftransfer))";
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(str);
		OnlineBean ubean = null;
		//ArrayList<UserBean1> al = new ArrayList<UserBean1>();
		
		while(rs.next()){
			int accountNumber = rs.getInt(1);
			 int transactionId = rs.getInt(2);
	
			 String transactionDescription = rs.getString(3);
			
			 String dateOfTransaction = rs.getString(4);
			
			
			 int transactionamount = rs.getInt(5);
			
			 
			
			
			 al.add(new OnlineBean( accountNumber,transactionId,transactionDescription,dateOfTransaction, transactionamount));			
			 logger.info("Executed succesfully");
		}
		
	//	System.out.println(al);
		} catch (IOException e) {
			logger.error("Exception occured- "+e.getMessage());
			
			throw new BankingApplicationException("INVALID INPUT");
		}
		
		catch (SQLException e) {
			logger.error("Exception occured- "+e.getMessage());
			
			throw new BankingApplicationException("Could not get daily transactions details");
		}
	
		 return al;
	}

	@Override
	public ArrayList<OnlineBean> reteriveMonthly() throws BankingApplicationException{
		// TODO Auto-generated method stub
		ArrayList<OnlineBean> al = new ArrayList<OnlineBean>();
		try{
		Connection con = dbUtil.getConnection();
		String str = "SELECT * FROM Transaction WHERE (trunc(sysdate)-trunc(dateoftransfer)<=30)";
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(str);
		OnlineBean ubean = null;
		
		
		while(rs.next()){
			
			int accountNumber = rs.getInt(1);
			 int transactionId = rs.getInt(2);
	
			 String transactionDescription = rs.getString(3);
			
			 String dateOfTransaction = rs.getString(4);
			
			
			 int transactionamount = rs.getInt(5);
			
			 
			
			
			 al.add(new OnlineBean( accountNumber,transactionId,transactionDescription,dateOfTransaction, transactionamount));	
			 logger.info("Executed succesfully");
		}
		
	//	System.out.println(al);
		
		}
		catch (IOException e) {
			logger.error("Exception occured- "+e.getMessage());
			
			throw new BankingApplicationException("INVALID INPUT");
		}
		
		catch (SQLException e) {
			logger.error("Exception occured- "+e.getMessage());
			throw new BankingApplicationException("Could not get monthly transactions details");
		}
		return al;
	}

	@Override
	public ArrayList<OnlineBean> reteriveYearly() throws BankingApplicationException {
		// TODO Auto-generated method stub
		ArrayList<OnlineBean> al = new ArrayList<OnlineBean>();
		try{
		Connection con = dbUtil.getConnection();
		String str = "SELECT * FROM Transaction WHERE (trunc(sysdate)-trunc(dateoftransfer)<=365)";
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(str);
		OnlineBean ubean = null;
		
		
		while(rs.next()){
			
			int accountNumber = rs.getInt(1);
			 int transactionId = rs.getInt(2);
	
			 String transactionDescription = rs.getString(3);
			
			 String dateOfTransaction = rs.getString(4);
			
			
			 int transactionamount = rs.getInt(5);
			
			 
			
			
			 al.add(new OnlineBean( accountNumber,transactionId,transactionDescription,dateOfTransaction, transactionamount));	
			 logger.info("Executed succesfully");
		}
		
	//	System.out.println(al);
		} catch (IOException e) {
			logger.error("Exception occured- "+e.getMessage());
			throw new BankingApplicationException("INVALID INPUT");
		}
		
		catch (SQLException e) {
			logger.error("Exception occured- "+e.getMessage());
			throw new BankingApplicationException("Could not get yearly transactions details");
		}
		return al;	}

	@Override
	public ArrayList<OnlineBean> reteriveQuaterly() throws BankingApplicationException{
		// TODO Auto-generated method stub
		ArrayList<OnlineBean> al = new ArrayList<OnlineBean>();
		try{
		Connection con = dbUtil.getConnection();
		String str = "SELECT * FROM Transaction WHERE (trunc(sysdate)-trunc(dateoftransfer)<=92)";
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(str);
	//UserBean1 ubean = null;
		
		
		while(rs.next()){
			
			int accountNumber = rs.getInt(1);
			 int transactionId = rs.getInt(2);
	
			 String transactionDescription = rs.getString(3);
			
			 String dateOfTransaction = rs.getString(4);
			
			
			 int transactionamount = rs.getInt(5);
			
			 
			
			
			 al.add(new OnlineBean( accountNumber,transactionId,transactionDescription,dateOfTransaction, transactionamount));	
			 logger.info("Executed succesfully");	
		}
		
	//	System.out.println(al);
		} catch (IOException e) {
			logger.error("Exception occured- "+e.getMessage());
			throw new BankingApplicationException("INVALID INPUT");
		}
		
		catch (SQLException e) {
			logger.error("Exception occured- "+e.getMessage());
			throw new BankingApplicationException("Could not get quaterly transactions details");
		}
		return al;	
	}

	@Override
	public int updateAccBal(CustomerBean ub) throws BankingApplicationException {
		// TODO Auto-generated method stub
		int nr1 = 0;
		try{
		
		Connection con = dbUtil.getConnection();
		
		String str = "UPDATE customer SET account_bal=? WHERE account_id=?";
		PreparedStatement pst = con.prepareStatement(str);
	
		
		pst.setInt(1,ub.getAccbal());
		pst.setLong(2,ub.getAccNo());
		
		nr1 = pst.executeUpdate();
		logger.info("Executed succesfully");
		
		} catch (IOException e) {
			logger.error("Exception occured- "+e.getMessage());
			throw new BankingApplicationException("INVALID INPUT");
		}
		
		catch (SQLException e) {
			logger.error("Exception occured- "+e.getMessage());
			throw new BankingApplicationException("Could not update customer balance");
		}
		
		return nr1;
	}

	@Override
	public int updateName(CustomerBean ub) throws BankingApplicationException{
		// TODO Auto-generated method stub
		int nr1 = 0;
		try{
		Connection con = dbUtil.getConnection();
		
		String str = "UPDATE customer SET customer_name=? WHERE account_id=?";
		PreparedStatement pst = con.prepareStatement(str);
	
		
		pst.setString(1,ub.getName());
		pst.setLong(2,ub.getAccNo());
		
		nr1 = pst.executeUpdate();
		logger.info("Executed succesfully");
		
		}catch (IOException e) {
			logger.error("Exception occured- "+e.getMessage());
			throw new BankingApplicationException("INVALID INPUT");
		}
		
		catch (SQLException e) {
			logger.error("Exception occured- "+e.getMessage());
			throw new BankingApplicationException("Could not update customer name");
		}
		return nr1;
	}

	@Override
	public int updateAddress(CustomerBean ub) throws BankingApplicationException{
		// TODO Auto-generated method stub
		int nr1 = 0;
		try{
		Connection con = dbUtil.getConnection();
		
		String str = "UPDATE customer SET address=? WHERE account_id=?";
		PreparedStatement pst = con.prepareStatement(str);
	
		
		pst.setString(1,ub.getAddress());
		pst.setLong(2,ub.getAccNo());
		
		nr1 = pst.executeUpdate();
		logger.info("Executed succesfully");
		
		} catch (IOException e) {
			logger.error("Exception occured- "+e.getMessage());
			throw new BankingApplicationException("INVALID INPUT");
		}
		
		catch (SQLException e) {
			logger.error("Exception occured- "+e.getMessage());
			throw new BankingApplicationException("Could not update customer address");
		}
		
		return nr1;
	}

	@Override
	public int updateEmail(CustomerBean ub) throws BankingApplicationException{
		// TODO Auto-generated method stub
		int nr1 = 0;
		try{
		Connection con = dbUtil.getConnection();
		
		String str = "UPDATE customer SET email=? WHERE account_id=?";
		PreparedStatement pst = con.prepareStatement(str);
	
		
		pst.setString(1,ub.getEmail());
		pst.setLong(2,ub.getAccNo());
		
		nr1 = pst.executeUpdate();
		logger.info("Executed succesfully");
		
		}catch (IOException e) {
			logger.error("Exception occured- "+e.getMessage());
			throw new BankingApplicationException("INVALID INPUT");
		}
		
		catch (SQLException e) {
			logger.error("Exception occured- "+e.getMessage());
			throw new BankingApplicationException("Could not update customer Email");
		}
		return nr1;
	}

	@Override
	public int updateMobileno(CustomerBean ub) throws BankingApplicationException{
		// TODO Auto-generated method stub
		int nr1 = 0;
		try{
		Connection con = dbUtil.getConnection();
		
		String str = "UPDATE customer SET mobile_no=? WHERE account_id=?";
		PreparedStatement pst = con.prepareStatement(str);
	
		
		pst.setString(1,ub.getMobile());
		pst.setLong(2,ub.getAccNo());
		
		nr1 = pst.executeUpdate();
		logger.info("Executed succesfully");
		
		} catch (IOException e) {
			logger.error("Exception occured- "+e.getMessage());
			throw new BankingApplicationException("INVALID INPUT");
		}
		
		catch (SQLException e) {
			logger.error("Exception occured- "+e.getMessage());
			throw new BankingApplicationException("Could not update mobile number");
		}
		
		return nr1;
	}

	@Override
	public int updatePancard(CustomerBean ub) throws BankingApplicationException{
		// TODO Auto-generated method stub
		int nr1 = 0;
		try{
		Connection con = dbUtil.getConnection();
		
		String str = "UPDATE customer SET pancard=? WHERE account_id=?";
		PreparedStatement pst = con.prepareStatement(str);
	
		
		pst.setString(1,ub.getPancard());
		pst.setLong(2,ub.getAccNo());
		
		nr1 = pst.executeUpdate();
		logger.info("Executed succesfully");
		
		} catch (IOException e) {
			logger.error("Exception occured- "+e.getMessage());
			throw new BankingApplicationException("INVALID INPUT");
		}
		
		catch (SQLException e) {
			logger.error("Exception occured- "+e.getMessage());
			throw new BankingApplicationException("Could not update pancard");
		}
		return nr1;
	}

	@Override
	public int deleteAcc(CustomerBean ub) throws BankingApplicationException{
		// TODO Auto-generated method stub
		int nr1 = 0;
		try{
		Connection con = dbUtil.getConnection();
		
		String str = "Delete from Customer where account_id=?";
		PreparedStatement pst = con.prepareStatement(str);
		pst.setLong(1,ub.getAccNo());
		nr1 = pst.executeUpdate();
		logger.info("Executed succesfully");
		
		}catch (IOException e) {
			logger.error("Exception occured- "+e.getMessage());
			throw new BankingApplicationException("INVALID INPUT");
		}
		
		catch (SQLException e) {
			logger.error("Exception occured- "+e.getMessage());
			throw new BankingApplicationException("Could not delete account");
		}
		
		return nr1;
	}


	@Override
	public boolean validateId(int accid) throws BankingApplicationException {
		Connection conn=null;  
	    PreparedStatement p= null;  
	    ResultSet r=null;  
	       try {
			conn=dbUtil.getConnection();
		  
	       p=conn.prepareStatement("SELECT * from customer where account_id=?");  
	        p.setInt(1,accid);  
	         
	        
	        r= p.executeQuery();  
	        if(r.next())  
	            {  
	                return true;  
	            }  
	            else 
	            	{
	            	System.out.println("Enter valid Account ID");
	            	return false;  
	        }  
	       } catch (IOException e) {
				logger.error("Exception occured- "+e.getMessage());
				throw new BankingApplicationException("INVALID INPUT");
			}
			
			catch (SQLException e) {
				logger.error("Exception occured- "+e.getMessage());
				throw new BankingApplicationException("No Account Id");
			}
	}

	

}
