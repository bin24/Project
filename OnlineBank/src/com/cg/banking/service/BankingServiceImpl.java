package com.cg.banking.service;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.regex.Pattern;

import com.cg.banking.bean.CustomerBean;
import com.cg.banking.bean.OnlineBean;
import com.cg.banking.bean.PayeeDetailsBean;
import com.cg.banking.bean.ServiceTrackerBean;
import com.cg.banking.bean.UserBean;
import com.cg.banking.dao.BankingDaoImpl;
import com.cg.banking.dao.IBankingDao;
import com.cg.banking.exception.BankingApplicationException;





public class BankingServiceImpl implements IBankingService {
	
	IBankingDao dao=null;

	

	@Override
	public boolean checkLogin(UserBean bean) throws BankingApplicationException{
		dao=new BankingDaoImpl();
		
		return dao.checkLogin(bean);
	}



	@Override
	public ArrayList<UserBean> changePassword(UserBean bean) throws BankingApplicationException {
		dao=new BankingDaoImpl();
		
		return dao.changePassword(bean);
	}



	@Override
	public boolean checkSecurityAnswer(String securityQuestion,
			String securityAnswer, String sAnswer){
		
		if(securityAnswer.equals(sAnswer))
		{
			
			return true;
		}
		else
		{
			
			return false;
		}
		
	}



	@Override
	public int updatePassword(UserBean bean) throws BankingApplicationException {
		dao=new BankingDaoImpl();
		
		return dao.updatePassword(bean);
	}



	@Override
	public boolean checkPassword(String newPassword, String reEnterNewPassword){
		
		if(newPassword.equals(reEnterNewPassword))
		{
			return true;
		}
		else
		{
			return false;
		}
		
	}



	@Override
	public int updateLock(UserBean bean) throws BankingApplicationException {
		dao=new BankingDaoImpl();
		
		return dao.updateLock(bean);
	}



	@Override
	public ArrayList<UserBean> getAccountId(UserBean bean)  throws BankingApplicationException{
		
			dao=new BankingDaoImpl();
		
			return dao.getAccountId(bean);
		
	}



//bindu
	/*@Override
	public ArrayList<OnlineBean> retriveDetails(int id, Date startdate, Date enddate) throws SQLException, IOException {
		 ArrayList<OnlineBean> al=dao.retriveDetails(id,startdate,enddate);
		 return al;
	}*/

	@Override
	public ArrayList<OnlineBean> retriveDetails(int id, String startdate, String enddate)  throws BankingApplicationException{
		 ArrayList<OnlineBean> al=dao.retriveDetails(id,startdate,enddate);
		 return al;
	}

	@Override
	public ArrayList<OnlineBean> retriveLast(int id)  throws BankingApplicationException {
		ArrayList<OnlineBean> al=dao.retriveLast(id);
		 return al;
	}



//jyotsna
	
	
	@Override
	public ArrayList<CustomerBean> getAddr(long accountId)  throws BankingApplicationException {
		return dao.getAddr(accountId);
	}
	@Override
	public int changeAddr(CustomerBean bean)  throws BankingApplicationException {
		return dao.changeAddr(bean);

	}
	@Override
	public int changeMob(CustomerBean bean)  throws BankingApplicationException {
		return dao.changeMob(bean);

	}
	@Override
	public boolean validatePhoneNo(String mob){
		String phonepattern="[7-9]{1}[0-9]{9}";
		if(Pattern.matches(phonepattern, mob))
		{
			return true;
		}
		else
		{
			System.out.println("Please enter the valid Mobile number");
			return false;
		}
	}
	@Override
	public boolean validateAddress(String address){
		String ptn="^[a-zA-Z0-9#\\s]*$";
		if(Pattern.matches(ptn, address))
		{
			return true;
		}
		else
		{
			System.out.println("Please enter the valid Address");
			return false;
		}
	}
	@Override
	public boolean checkAccId(int accNo) throws BankingApplicationException
	{
			int res=dao.checkAccId(accNo);
			if(res==1)
			{
				return true;
			}
			else
			{
				return false;
			}
	}
	
	
	//rohit
	

	
	public int requestforcheckbook(ServiceTrackerBean u) throws SQLException, IOException {
		
		
		return dao.requestforcheckbook(u);
	}

	@Override
	public int addDetails(ServiceTrackerBean u)  throws BankingApplicationException {
		
		return dao.addDetails(u);
	}



//avinash
	
	
	
	@Override
	public ArrayList<ServiceTrackerBean> fetchServiceDetailsByID(int serviceID)  throws BankingApplicationException {
		dao = new BankingDaoImpl();
		return dao.fetchServiceDetailsByID(serviceID);
	}

	@Override
	public ArrayList<ServiceTrackerBean> fetchServiceDetailsByAccountID(int accountID)  throws BankingApplicationException {
		dao = new BankingDaoImpl();
		return dao.fetchServiceDetailsByAccountID(accountID);
	}

	@Override
	public ArrayList<ServiceTrackerBean> statusOfAllRequest(int accountID) throws BankingApplicationException{
		dao = new BankingDaoImpl();
		return dao.statusOfAllRequest(accountID);
	}

	@Override
	public ArrayList<ServiceTrackerBean> fetchServiceRequestID(int accountID) throws BankingApplicationException {
		dao = new BankingDaoImpl();
		return dao.fetchServiceRequestID(accountID);
	}

	@Override
	public ArrayList<ServiceTrackerBean> getRequestHistory(int accId)  throws BankingApplicationException {
		dao = new BankingDaoImpl();
		return dao.getRequestHistory(accId);
	}

	@Override
	public ArrayList<Integer> getAccountNumber(String pan)  throws BankingApplicationException {
		dao = new BankingDaoImpl();
		return dao.getAccountNumber(pan);
	}

	

	@Override
	public int registerPayee(int accountID, int payeeAccountID, String payeeAccountName)  throws BankingApplicationException {
		dao = new BankingDaoImpl();
		return dao.registerPayee(accountID,payeeAccountID,payeeAccountName);
	}

	@Override
	public int transferFund(int transferFromAccount, int transferToAccount, int transferAmount)  throws BankingApplicationException {
		dao = new BankingDaoImpl();
		return dao.transferFund(transferFromAccount,transferToAccount,transferAmount);
	
	}

	@Override
	public ArrayList<PayeeDetailsBean> getPayeeDetails(int accountID)  throws BankingApplicationException {
		dao = new BankingDaoImpl();
		return dao.getPayeeDetails(accountID);
	}


	@Override
	public int getAccountBalance(int accountID)  throws BankingApplicationException{
		dao = new BankingDaoImpl();
		return dao.getAccountBalance(accountID);
	}



	@Override
	public ArrayList<String> getPanDetails(int accountID)  throws BankingApplicationException {
		dao = new BankingDaoImpl();
		return dao.getPanDetails(accountID);
	}



	@Override
	public int validateBalance(int balance, int transferAmount) {
		int flagBalance = 0;
		
		if(balance-transferAmount>0){
			flagBalance = 1;
			
			
		}
		else{
			flagBalance = 0;
		}
		return flagBalance; 
	}



	@Override
	public ArrayList<Integer> getPayeeAccount(int accountID) throws BankingApplicationException{
		
		return dao.getPayeeAccount(accountID);
	}



	@Override
	public ArrayList<Integer> validateAccount() throws BankingApplicationException {
		
		return dao.validateAccount();
	}



	
	}



	



	


	

	


