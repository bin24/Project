package com.cg.banking.service;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.cg.banking.bean.CustomerBean;
import com.cg.banking.bean.OnlineBean;
import com.cg.banking.bean.UserBean;
import com.cg.banking.dao.BankingAdminDaoImpl;
import com.cg.banking.dao.BankingDaoImpl;
import com.cg.banking.dao.IBankingAdminDao;
import com.cg.banking.dao.IBankingDao;
import com.cg.banking.dbUtil.dbUtil;
import com.cg.banking.exception.BankingApplicationException;



public class BankingAdminServiceImpl implements IBankingAdminService {

	@Override
	public int createNewAcc(CustomerBean ub) throws BankingApplicationException{
		IBankingAdminDao ibd = new BankingAdminDaoImpl();
		return ibd.createNewAcc(ub);
	}

	@Override
	public ArrayList<OnlineBean> reteriveDaily() throws BankingApplicationException{
		// TODO Auto-generated method stub
		IBankingAdminDao ibd = new BankingAdminDaoImpl();
		return ibd.reteriveDaily();
	}

	@Override
	public ArrayList<OnlineBean> reteriveMonthly() throws BankingApplicationException{
		// TODO Auto-generated method stub
		IBankingAdminDao ibd = new BankingAdminDaoImpl();
		return ibd.reteriveMonthly();
		
	}

	@Override
	public ArrayList<OnlineBean> reteriveYearly() throws BankingApplicationException {
		// TODO Auto-generated method stub
		IBankingAdminDao ibd = new BankingAdminDaoImpl();
		return ibd.reteriveYearly();
		
	}

	@Override
	public ArrayList<OnlineBean> reteriveQuaterly() throws BankingApplicationException {
		// TODO Auto-generated method stub
		IBankingAdminDao ibd = new BankingAdminDaoImpl();
		return ibd.reteriveQuaterly();
	}

	@Override
	public boolean validateName(String name) {
		String ptn="^[a-zA-Z\\s]*$";
		
		if(Pattern.matches(ptn,name))
		{
			return true;
		}
		else
		{
		
			System.out.println("Please enter valid details");
			return false;
		}
		
	
	}

	@Override
	public boolean validateBal(int accbal) {
	if(accbal>0)
	{
		return true;
	}
	else 
	{
		System.out.println("Please enter valid details");
		return false;
	}
	
	
	}

	@Override
	public boolean validatemob(String mobileno) {
		
		String ptn="^[0-9]{10}\\s*$";
		
		if(Pattern.matches(ptn,mobileno))
		{
			return true;
		}
		else
		{
			System.out.println("Please enter valide mobileno");
			return false;
		}
	}

	@Override
	public boolean validateEmail(String email) {
		// TODO Auto-generated method stub
		 String emailPattern="^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$";
		if(Pattern.matches(emailPattern,email))
		{
			return true;
		}
		else
		{
			System.out.println("Please enter valide email");
			return false;
		}
	}

	@Override
	public boolean validateacctype(int acctype) {
		if(acctype ==1 || acctype==2)
		{
			return true;
		}
		else{
			
			System.out.println("Please enter valide choice");
			return false;
		}
	}

	@Override
	public boolean validateAdmin(String password){
		String pass = "[R]{1}[i]{1}[s]{1}[h]{1}[a]{1}[b]{1}[h]{1}";
		
		if(Pattern.matches(pass,password)) 
		            {  
		                return true;  
		            }  
		            else 
		            	{
		            	System.out.println("Enter valid password");
		            	return false;  
		        }  
		          
		          
	}
			

	@Override
	public int updateAccBal(CustomerBean ub) throws BankingApplicationException {
		// TODO Auto-generated method stub
		IBankingAdminDao ibd = new BankingAdminDaoImpl();
		return ibd.updateAccBal(ub);
	}

	@Override
	public int updateName(CustomerBean ub) throws BankingApplicationException {
		// TODO Auto-generated method stub
		IBankingAdminDao ibd = new BankingAdminDaoImpl();
		return ibd.updateName(ub);
	}

	@Override
	public int updateAddress(CustomerBean ub) throws BankingApplicationException {
		// TODO Auto-generated method stub
		IBankingAdminDao ibd = new BankingAdminDaoImpl();
		return ibd.updateAddress(ub);
	}

	@Override
	public int updateEmail(CustomerBean ub) throws BankingApplicationException {
		// TODO Auto-generated method stub
		IBankingAdminDao ibd = new BankingAdminDaoImpl();
		return ibd.updateEmail(ub);
	}

	@Override
	public int updateMobileno(CustomerBean ub) throws BankingApplicationException {
		// TODO Auto-generated method stub
		IBankingAdminDao ibd = new BankingAdminDaoImpl();
		return ibd.updateMobileno(ub);
	}

	@Override
	public int updatePancard(CustomerBean ub) throws BankingApplicationException {
		// TODO Auto-generated method stub
		IBankingAdminDao ibd = new BankingAdminDaoImpl();
		return ibd.updatePancard(ub);
	}

	@Override
	public int deleteAcc(CustomerBean ub) throws BankingApplicationException {
		// TODO Auto-generated method stub
		IBankingAdminDao ibd = new BankingAdminDaoImpl();
		return ibd.deleteAcc(ub);
	}

	@Override
	public boolean validateId(int accid) throws BankingApplicationException {
		IBankingAdminDao ibd = new BankingAdminDaoImpl();
		return ibd.validateId(accid);   
	}

	@Override
	public boolean validateAddress(String address) {
		String ptn="^[a-zA-Z0-9#\\s]*$";
		if(Pattern.matches(ptn,address))
		{
			return true;
		}
		else
		{
			
			System.out.println("Please enter valide details");
			return false;
		}
	}

	

	
	
}
