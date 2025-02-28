package com.Project.Loan;

import com.Project.Loan.Models.Loan;
import com.Project.Loan.Service.LoanService;

public class App {
    public static void main(String[] args) {
    	LoanService loanService = new LoanService();
    	Loan personalLoan = new Loan(1,"Venkatesh","Personal",869,6,241000,true,"In-Progress");
    	loanService.getLoanApprovalStatus(personalLoan); 
    }
}
