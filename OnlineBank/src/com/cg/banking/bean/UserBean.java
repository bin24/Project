package com.cg.banking.bean;

public class UserBean {
	
	private long accountId;
	private int userId;
	private String loginPassword;
	private String secretQuestion;
	private String secretQuestionAnswer;
	private String transactionPassword;
	private String lockStatus;
	
	public long getAccountId() {
		return accountId;
	}
	public void setAccountId(long accountId) {
		this.accountId = accountId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getLoginPassword() {
		return loginPassword;
	}
	public void setLoginPassword(String loginPassword) {
		this.loginPassword = loginPassword;
	}
	public String getSecretQuestion() {
		return secretQuestion;
	}
	public void setSecretQuestion(String secretQuestion) {
		this.secretQuestion = secretQuestion;
	}
	public String getSecretQuestionAnswer() {
		return secretQuestionAnswer;
	}
	public void setSecretQuestionAnswer(String secretQuestionAnswer) {
		this.secretQuestionAnswer = secretQuestionAnswer;
	}
	public String getTransactionPassword() {
		return transactionPassword;
	}
	public void setTransactionPassword(String transactionPassword) {
		this.transactionPassword = transactionPassword;
	}
	public String getLockStatus() {
		return lockStatus;
	}
	public void setLockStatus(String lockStatus) {
		this.lockStatus = lockStatus;
	}
	
	
	public UserBean(long accountId, int userId, String loginPassword,
			String secretQuestion, String secretQuestionAnswer,
			String transactionPassword, String lockStatus) {
		super();
		this.accountId = accountId;
		this.userId = userId;
		this.loginPassword = loginPassword;
		this.secretQuestion = secretQuestion;
		this.secretQuestionAnswer = secretQuestionAnswer;
		this.transactionPassword = transactionPassword;
		this.lockStatus = lockStatus;
	}
	
	
	
	
	
	public UserBean(int userId, String loginPassword) {
		super();
		this.userId = userId;
		this.loginPassword = loginPassword;
		
	}
	@Override
	public String toString() {
		return "UserBean [accountId=" + accountId + ", userId=" + userId
				+ ", loginPassword=" + loginPassword + ", secretQuestion="
				+ secretQuestion + ", secretQuestionAnswer="
				+ secretQuestionAnswer + ", transactionPassword="
				+ transactionPassword + ", lockStatus=" + lockStatus + "]";
	}
	public UserBean(int userId) {
		super();
		this.userId = userId;
	}
	public UserBean(String secretQuestion, String secretQuestionAnswer) {
		super();
		this.secretQuestion = secretQuestion;
		this.secretQuestionAnswer = secretQuestionAnswer;
	}
	public UserBean(long accountId) {
		super();
		this.accountId = accountId;
	}
	
	
	
	
	


}
