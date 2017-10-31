package com.cg.banking.service;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import com.cg.banking.bean.CustomerBean;
import com.cg.banking.bean.UserBean;
import com.cg.banking.bean.OnlineBean;
import com.cg.banking.bean.PayeeDetailsBean;
import com.cg.banking.bean.ServiceTrackerBean;
import com.cg.banking.exception.BankingApplicationException;

public interface IBankingService {

	
	public boolean checkLogin(UserBean bean) throws BankingApplicationException;

	public ArrayList<UserBean> changePassword(UserBean bean) throws BankingApplicationException;

	

	

	public boolean checkSecurityAnswer(String securityQuestion,String securityAnswer, String sAnswer) throws BankingApplicationException;
	
	
	public int updatePassword(UserBean bean) throws BankingApplicationException;

	public boolean checkPassword(String newPassword, String reEnterNewPassword) throws BankingApplicationException;
	
	
	
	public int updateLock(UserBean bean) throws BankingApplicationException;

	public ArrayList<UserBean> getAccountId(UserBean bean) throws BankingApplicationException;
	
	
	
	//home
	
	ArrayList<OnlineBean> retriveDetails(int id, String startdate, String startdate2) throws BankingApplicationException;

	ArrayList<OnlineBean> retriveLast(int id) throws BankingApplicationException;
	
	//jyotsna
	
	ArrayList<CustomerBean> getAddr(long accountId) throws BankingApplicationException;

	int changeAddr(CustomerBean bean) throws BankingApplicationException;;

	int changeMob(CustomerBean bean) throws BankingApplicationException;;

	boolean validatePhoneNo(String mob);

	boolean validateAddress(String address);

	boolean checkAccId(int accNo) throws BankingApplicationException;
	
	
	//rohit
	
	int requestforcheckbook(ServiceTrackerBean u) throws SQLException, IOException;

	int addDetails(ServiceTrackerBean u) throws BankingApplicationException;
	
	//avinash
	
	ArrayList<ServiceTrackerBean> fetchServiceDetailsByID(int serviceID) throws BankingApplicationException;
	ArrayList<ServiceTrackerBean> fetchServiceDetailsByAccountID(int accountID) throws BankingApplicationException;
	ArrayList<ServiceTrackerBean> statusOfAllRequest(int accountID) throws BankingApplicationException;
	ArrayList<ServiceTrackerBean> fetchServiceRequestID(int accountID) throws BankingApplicationException;
	ArrayList<ServiceTrackerBean> getRequestHistory(int accId) throws BankingApplicationException;
	
	ArrayList<Integer> getAccountNumber(String pan) throws BankingApplicationException;
	
	
	int registerPayee(int accountID, int payeeAccountID, String payeeAccountName) throws BankingApplicationException;
	int transferFund(int transferFromAccount, int transferToAccount, int transferAmount) throws BankingApplicationException;
	
	
	ArrayList<PayeeDetailsBean> getPayeeDetails(int accountID) throws BankingApplicationException;

	

	public int getAccountBalance(int accountID) throws BankingApplicationException;

	public ArrayList<String> getPanDetails(int accountID) throws BankingApplicationException;

	public int validateBalance(int balance, int transferAmount) throws BankingApplicationException;

	ArrayList<Integer> getPayeeAccount(int accountID)
			throws BankingApplicationException;

	public ArrayList<Integer> validateAccount() throws BankingApplicationException;

	
	
}
