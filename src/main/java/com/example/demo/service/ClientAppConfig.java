package com.example.demo.service;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

@Configuration
public class ClientAppConfig {
	@Bean
	public Jaxb2Marshaller marshaller() {
		Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
		marshaller.setContextPath("bank_web_service");
		return marshaller;
	}

	@Bean
	public BankCatalogClient productCatalogClient(Jaxb2Marshaller marshaller) {
		BankCatalogClient client = new BankCatalogClient();
		client.setDefaultUri("http://34.236.109.151:8000/ws/bankdetails.wsdl");
		client.setMarshaller(marshaller);
		client.setUnmarshaller(marshaller);
		return client;
	}
}
