package com.example.demo.service;

import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;

import com.google.gson.Gson;

import bank_web_service.GetBankDetailsRequest;
import bank_web_service.GetBankDetailsResponse;

public class BankCatalogClient extends WebServiceGatewaySupport {

	public GetBankDetailsResponse getBankById(String id) {
		GetBankDetailsRequest request = new GetBankDetailsRequest();
		request.setCustomerId(id);
		GetBankDetailsResponse response = (GetBankDetailsResponse) getWebServiceTemplate()
				.marshalSendAndReceive(request, new SoapActionCallback("http://34.236.109.151:8000/ws/"));

		Gson json = new Gson();
		System.out.println("Customer Details------------>"+json.toJson(response).toString());
		return response;
	}
}