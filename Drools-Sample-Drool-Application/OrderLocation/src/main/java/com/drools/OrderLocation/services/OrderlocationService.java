package com.drools.OrderLocation.services;

import org.drools.decisiontable.InputType;
import org.drools.decisiontable.SpreadsheetCompiler;
import org.kie.api.KieBase;
import org.kie.api.KieServices;
import org.kie.api.io.Resource;
import org.kie.api.io.ResourceType;
import org.kie.api.runtime.KieSession;
import org.kie.internal.io.ResourceFactory;
import org.kie.internal.utils.KieHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.drools.OrderLocation.models.Constants;

@Service
public class OrderlocationService {

	
	@Autowired
	KieServices kieServices;

	public String generateDRLFromSpreadsheet(String excelPath) {
		String generatedDRL = "";
		try {
			SpreadsheetCompiler compiler = new SpreadsheetCompiler();
			generatedDRL = compiler.compile(ResourceFactory.newClassPathResource(excelPath), InputType.XLS);
		} catch (Exception ex) {
			
		}
		return generatedDRL;
	}

	public KieSession createKieSession(String generatedDRL) {
		KieHelper kieHelper = null;
		KieBase kieBase = null;
		try {
			kieHelper = new KieHelper();
			byte[] b1 = generatedDRL.getBytes();
			Resource resource1 = kieServices.getResources().newByteArrayResource(b1);
			kieHelper.addResource(resource1, ResourceType.DRL);
			kieBase = kieHelper.build();
		} catch (Exception ex) {
			
		}
		return kieBase.newKieSession();

	}

	public void setAgendaFocus(KieSession kieSession, String groupType) {
		org.kie.api.runtime.rule.Agenda agenda = kieSession.getAgenda();
		if (groupType.equalsIgnoreCase(Constants.ORGANIZATION1)) {
			agenda.getAgendaGroup(Constants.ORGANIZATION1).setFocus();
		} else if (groupType.equalsIgnoreCase(Constants.ORGANIZATION2)) {
			agenda.getAgendaGroup(Constants.ORGANIZATION2).setFocus();
		}
	}
}
