package com.Project.Loan.Models;

public class Loan {

	private Integer loanApplicationId;
	private String applicantName;
	private String loanType;
	private Integer CIBILScore;
	private Integer age;
	private Integer loanAmount;
	private boolean valid;
	private String loanApplicationStatus;

	public Loan(Integer loanApplicationId, String applicantName, String loanType, Integer CIBILScore, Integer age,
			Integer loanAmount, boolean valid, String loanApplicationStatus) {
		this.loanApplicationId = loanApplicationId;
		this.applicantName = applicantName;
		this.loanType = loanType;
		this.CIBILScore = CIBILScore;
		this.age = age;
		this.loanAmount = loanAmount;
		this.valid = valid;
		this.loanApplicationStatus = loanApplicationStatus;
	}

	public Integer getLoanApplicationId() {
		return loanApplicationId;
	}

	public void setLoanApplicationId(Integer loanApplicationId) {
		this.loanApplicationId = loanApplicationId;
	}

	public String getApplicantName() {
		return applicantName;
	}

	public void setApplicantName(String applicantName) {
		this.applicantName = applicantName;
	}

	public String getLoanType() {
		return loanType;
	}

	public void setLoanType(String loanType) {
		this.loanType = loanType;
	}

	public Integer getCIBILScore() {
		return CIBILScore;
	}

	public void setCIBILScore(Integer cIBILScore) {
		CIBILScore = cIBILScore;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public Integer getLoanAmount() {
		return loanAmount;
	}

	public void setLoanAmount(Integer loanAmount) {
		this.loanAmount = loanAmount;
	}

	public String getLoanApplicationStatus() {
		return loanApplicationStatus;
	}

	public void setLoanApplicationStatus(String loanApplicationStatus) {
		this.loanApplicationStatus = loanApplicationStatus;
	}

	public boolean isValid() {
		return valid;
	}

	public void setValid(boolean valid) {
		this.valid = valid;
	}

}