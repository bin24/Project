package com.cg.banking.dao;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import com.cg.banking.bean.CustomerBean;
import com.cg.banking.bean.OnlineBean;
import com.cg.banking.bean.UserBean;
import com.cg.banking.exception.BankingApplicationException;

public interface IBankingAdminDao {

	int createNewAcc(CustomerBean ub) throws BankingApplicationException;

	ArrayList<OnlineBean> reteriveDaily() throws BankingApplicationException;

	ArrayList<OnlineBean> reteriveMonthly() throws BankingApplicationException;

	ArrayList<OnlineBean> reteriveYearly() throws BankingApplicationException;

	ArrayList<OnlineBean> reteriveQuaterly() throws BankingApplicationException;

	int updateAccBal(CustomerBean ub) throws BankingApplicationException;

	int updateName(CustomerBean ub) throws BankingApplicationException;

	int updateAddress(CustomerBean ub) throws BankingApplicationException;

	int updateEmail(CustomerBean ub) throws BankingApplicationException ;

	int updateMobileno(CustomerBean ub) throws BankingApplicationException;

	int updatePancard(CustomerBean ub) throws BankingApplicationException;

	int deleteAcc(CustomerBean ub) throws BankingApplicationException;

	boolean validateId(int accid) throws BankingApplicationException;


}
