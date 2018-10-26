
package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.ampq.SimpleRpcProducerRabbitApplication;
import com.example.demo.exception.BadRequestException;
import com.example.demo.exception.CustomizedResponseEntityExceptionHandler;
import com.example.demo.exception.LoanIdNotFoundException;
import com.example.demo.model.InvestmentLoan;
import com.example.demo.service.BankCatalogClient;
import com.example.demo.service.InvestmentLoanService;

/**
 * No description (Generated with springmvc-raml-parser v.2.0.0)
 * 
 */
@RestController
@RequestMapping(value = "/api/v1/dda", produces = "application/json")
@Validated
public class LoanIdController {

	@Autowired
	private InvestmentLoanService investmentLoanService;

	@Autowired
	private SimpleRpcProducerRabbitApplication simpleRpcProducerRabbitApplication;

	@Autowired
	private BankCatalogClient bankCatalogClient;

	/**
	 * Get investment loan information from Loan Id
	 * 
	 */

	@RequestMapping(value = "/investments/loans/{loanId}", method = RequestMethod.GET)
	public ResponseEntity<?> getInvestmentLoanByLoanId(@PathVariable String loanId) {

		boolean isLoanIdExist = investmentLoanService.fetchByLoanId(loanId) == null ? true : false;

		String special = "[!@#$%&*()_+=|<>?{}\\[\\]~-]";

		try {
			if ((!(loanId.matches("\\d+"))) || loanId.matches(special)) {

				throw new BadRequestException("Bad Request");
			} else if (isLoanIdExist == true) {
				throw new LoanIdNotFoundException("Not Found Loan Id");
			}

			else {

				simpleRpcProducerRabbitApplication.sendMessage(investmentLoanService.fetchByLoanId(loanId));
				bankCatalogClient.getBankById(investmentLoanService.fetchByLoanId(loanId).getCustomerId());
				return ResponseEntity.ok(investmentLoanService.fetchByLoanId(loanId));
			}
		} catch (LoanIdNotFoundException le) {

			return new CustomizedResponseEntityExceptionHandler().handleLoanAccountNotFoundException(le);

		} catch (BadRequestException bd) {

			return new CustomizedResponseEntityExceptionHandler().forBadRequest(bd);

		} catch (Exception ec) {

			return new CustomizedResponseEntityExceptionHandler().handleAllExceptions(ec);

		}
	}

}
