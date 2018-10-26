package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import com.example.demo.model.InvestmentLoan;

public interface InvestmentLoanService {

	InvestmentLoan fetchByLoanId(String loanId);
	
	
	
}
