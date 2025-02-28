package com.drools.OrderLocation.controllers;

import java.util.Optional;

import org.apache.http.HttpStatus;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.drools.OrderLocation.models.Constants;
import com.drools.OrderLocation.models.orderRequest;
import com.drools.OrderLocation.models.orderResponse;
import com.drools.OrderLocation.services.OrderlocationService;

@RestController
public class OrderLocationController {

	@Autowired
	OrderlocationService service;

	@Autowired
	KieContainer kieContainer;

	@PostMapping("/getMakeLocation")
	public ResponseEntity<orderResponse<orderRequest>> orderNow(@RequestBody orderRequest orderRequest) {
		orderResponse<orderRequest> response = null;
		KieSession kieSession = null;
		try {
			String groupType = Optional.ofNullable(orderRequest.getGroupType()).orElse(null);
			if (groupType != null && groupType != "") {
				String generatedDRL = service.generateDRLFromSpreadsheet(Constants.LOCATION_RULES);
				kieSession = service.createKieSession(generatedDRL);
				service.setAgendaFocus(kieSession, groupType);
				kieSession.insert(orderRequest);
				int firedRules = kieSession.fireAllRules();
				if (firedRules == 1) {
					response = new orderResponse<orderRequest>(Constants.SUCEESSRESPONSE);
					response.setHttpStatus(HttpStatus.SC_OK);
					response.data = orderRequest;
				} else {
					response = new orderResponse<orderRequest>(Constants.BADREQUEST);
					response.setHttpStatus(HttpStatus.SC_BAD_REQUEST);
					response.setMessage(Constants.BADREQUEST);
				}
			} else {
				response = new orderResponse<orderRequest>(Constants.BADREQUEST);
				response.setHttpStatus(HttpStatus.SC_BAD_REQUEST);
				response.setMessage(Constants.BADREQUEST);
			}
			kieSession.dispose();
			return ResponseEntity.status(response.httpStatus).body(response);
		} catch (Exception exception) {
			response = new orderResponse<orderRequest>(Constants.INTERNALSERVERERROR);
			response.setHttpStatus(HttpStatus.SC_INTERNAL_SERVER_ERROR);
			response.setMessage(Constants.INTERNALSERVERERROR);
			return ResponseEntity.status(HttpStatus.SC_INTERNAL_SERVER_ERROR).body(response);
		}

	}

}
