package com.cg.banking.bean;

import java.util.Date;

public class OnlineBean {
	private int accountNumber;
	private int transactionId;
	private String transactionDescription;
	private String DateOfTransaction;
	private int transactionamount;
	
	
	
	
	




	public int getTransactionId() {
		return transactionId;
	}




	public void setTransactionId(int transactionId) {
		this.transactionId = transactionId;
	}




	public String getTransactionDescription() {
		return transactionDescription;
	}




	public void setTransactionDescription(String transactionDescription) {
		this.transactionDescription = transactionDescription;
	}




	public String getDateOfTransaction() {
		return DateOfTransaction;
	}




	public void setDateOfTransaction(String dateOfTransaction) {
		DateOfTransaction = dateOfTransaction;
	}




	public int getTransactionamount() {
		return transactionamount;
	}




	public void setTransactionamount(int transactionamount) {
		this.transactionamount = transactionamount;
	}




	public int getAccountNumber() {
		return accountNumber;
	}




	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}




	public OnlineBean(int transactionId, String transactionDescription,
			String dateOfTransaction, int transactionamount) {
		super();
		this.transactionId = transactionId;
		this.transactionDescription = transactionDescription;
		DateOfTransaction = dateOfTransaction;
		this.transactionamount = transactionamount;
	}




	@Override
	public String toString() {
		return "OnlineBean [transactionId=" + transactionId
				+ ", transactionDescription=" + transactionDescription
				+ ", DateOfTransaction=" + DateOfTransaction
				+ ", transactionamount=" + transactionamount
				+ ", accountNumber=" + accountNumber + "]";
	}




	




	public OnlineBean(int accountNumber, int transactionId,
			String transactionDescription, String dateOfTransaction,
			int transactionamount) {
		super();
		this.accountNumber = accountNumber;
		this.transactionId = transactionId;
		this.transactionDescription = transactionDescription;
		DateOfTransaction = dateOfTransaction;
		this.transactionamount = transactionamount;
	}




	public OnlineBean()
	{
		
	}

	/*public int getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(int transactionId) {
		this.transactionId = transactionId;
	}

	public String getTransactionDescription() {
		return transactionDescription;
	}

	public void setTransactionDescription(String transactionDescription) {
		this.transactionDescription = transactionDescription;
	}

	public Date getDateOfTransaction() {
		return DateOfTransaction;
	}

	public void setDateOfTransaction(Date dateOfTransaction) {
		DateOfTransaction = dateOfTransaction;
	}


	public int getTransactionamount() {
		return transactionamount;
	}

	public void setTransactionamount(int transactionamount) {
		this.transactionamount = transactionamount;
	}

	public int getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}

	public OnlineBean(int transactionId, String transactionDescription,
			Date dateOfTransaction,
			int transactionamount) {
		super();
		this.transactionId = transactionId;
		this.transactionDescription = transactionDescription;
		DateOfTransaction = dateOfTransaction;
		this.transactionamount = transactionamount;
		
	}

	@Override
	public String toString() {
		return "OnlineBean [transactionId=" + transactionId
				+ ", transactionDescription=" + transactionDescription
				+ ", DateOfTransaction=" + DateOfTransaction
				+ ", transactionamount=" + transactionamount
				+ ", accountNumber=" + accountNumber + "]";
	}*/
	
	
}
