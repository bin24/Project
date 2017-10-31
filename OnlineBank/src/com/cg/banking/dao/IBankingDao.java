package com.cg.banking.dao;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import com.cg.banking.bean.CustomerBean;
import com.cg.banking.bean.UserBean;
import com.cg.banking.bean.OnlineBean;
import com.cg.banking.bean.CustomerBean;
import com.cg.banking.bean.PayeeDetailsBean;
import com.cg.banking.bean.ServiceTrackerBean;
import com.cg.banking.exception.BankingApplicationException;


public interface IBankingDao {
	
	
	public boolean checkLogin(UserBean bean) throws BankingApplicationException;

	public ArrayList<UserBean> changePassword(UserBean bean) throws BankingApplicationException;
	
	public int updatePassword(UserBean bean) throws BankingApplicationException;
	
	public int updateLock(UserBean bean) throws BankingApplicationException;

	public ArrayList<UserBean> getAccountId(UserBean bean) throws BankingApplicationException;

//home
	
	
	public ArrayList<OnlineBean> retriveDetails(int id, String startdate,String enddate) throws BankingApplicationException;
	ArrayList<OnlineBean> retriveLast(int id) throws BankingApplicationException;
//jyotsna
	
	ArrayList<CustomerBean> getAddr(long accountId) throws BankingApplicationException;

	int changeAddr(CustomerBean bean) throws BankingApplicationException;

	int changeMob(CustomerBean bean) throws BankingApplicationException;

	int checkAccId(int accNo) throws BankingApplicationException;
	
	
	//rohit
	
	int requestforcheckbook(ServiceTrackerBean u) throws SQLException, IOException;

	int addDetails(ServiceTrackerBean u) throws BankingApplicationException;
	
	
	//avinash
	

	public ArrayList<ServiceTrackerBean> fetchServiceDetailsByID(int serviceID) throws BankingApplicationException;
	public ArrayList<ServiceTrackerBean> fetchServiceDetailsByAccountID(int accountID) throws BankingApplicationException;
	public ArrayList<ServiceTrackerBean> statusOfAllRequest(int accountID) throws BankingApplicationException;
	public ArrayList<ServiceTrackerBean> fetchServiceRequestID(int accountID) throws BankingApplicationException;
	public ArrayList<ServiceTrackerBean> getRequestHistory(int accId) throws BankingApplicationException;
	public ArrayList<Integer> getAccountNumber(String pan) throws BankingApplicationException;
	

	public int registerPayee(int accountID, int payeeAccountID, String payeeAccountName) throws BankingApplicationException;
	public int transferFund(int transferFromAccount, int transferToAccount, int transferAmount) throws BankingApplicationException;
	
	public ArrayList<PayeeDetailsBean> getPayeeDetails(int accountID) throws BankingApplicationException;

	public int getAccountBalance(int accountID) throws BankingApplicationException;

	public ArrayList<String> getPanDetails(int accountID) throws BankingApplicationException;

	public ArrayList<Integer> getPayeeAccount(int accountID) throws BankingApplicationException;

	public ArrayList<Integer> validateAccount() throws BankingApplicationException;

	

	
	

}
