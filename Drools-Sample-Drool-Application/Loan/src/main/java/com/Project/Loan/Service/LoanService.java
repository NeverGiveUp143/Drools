package com.Project.Loan.Service;

import org.kie.api.runtime.KieSession;

import com.Project.Loan.Config.DroolsConfig;
import com.Project.Loan.Models.Loan;

public class LoanService {

	public void getLoanApprovalStatus(Loan loan) {
		DroolsConfig config = new DroolsConfig();
		KieSession kieSession = config.getKieSession("LoanSession");
		org.kie.api.runtime.rule.Agenda agenda = kieSession.getAgenda();
		if (agenda != null) {
			agenda.getAgendaGroup("CIBILScoreCheck").setFocus();
		}		
		kieSession.insert(loan);		
		kieSession.fireAllRules();		
		if (agenda != null) {
			agenda.getAgendaGroup("EligibilityRules").setFocus();
		}		
		kieSession.insert(loan);		
		kieSession.fireAllRules();
		if (agenda != null) {
			agenda.getAgendaGroup("LoanStatusUpdate").setFocus();
		}		
		kieSession.insert(loan);		
		kieSession.fireAllRules();
		kieSession.dispose();	
	}

	
}