package com.example.demo.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.InvestmentLoanRepository;
import com.example.demo.model.InvestmentLoan;
import com.example.demo.service.InvestmentLoanService;


@Service
public class InvestmentLoanServiceImpl implements InvestmentLoanService {

	@Autowired
	private InvestmentLoanRepository investmentLoanRepository;
	
	@Override
	public InvestmentLoan fetchByLoanId(String loanId) {
		// TODO Auto-generated method stub
		return investmentLoanRepository.fetchByLoanId(loanId);
	}

	/*@Override
	public int isLoanIdExists(String loanId) {
		// TODO Auto-generated method stub
		return investmentLoanRepository.isLoanIdExists(loanId);
	}*/


	
	
	
}
