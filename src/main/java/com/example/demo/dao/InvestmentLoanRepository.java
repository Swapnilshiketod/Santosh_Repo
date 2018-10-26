package com.example.demo.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.model.InvestmentLoan;

public interface InvestmentLoanRepository extends JpaRepository<InvestmentLoan, String> {

	@Query(value = " select * " + " from account a, accountdescriptor ad, investmentaccount i, investmentloan l"
			+ " where l.LoanId= :loanId" + " and l.InvestmentAccountId = i.InvestmentAccountId"
			+ " and i.AccountMasterId = a.AccountMasterId"
			+ " and a.AccDescriptorId = ad.AccountDescriptorId", nativeQuery = true)
	InvestmentLoan fetchByLoanId(@Param(value = "loanId") String loanId);

}
