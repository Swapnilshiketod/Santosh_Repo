
package com.example.demo.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

import com.fasterxml.jackson.annotation.JsonFormat;


@Entity
@Table(name= "investmentloan")
//@Inheritance(strategy = InheritanceType.JOINED)
//@PrimaryKeyJoinColumn(name = "InvestmentAccountId")
public class InvestmentLoan
extends InvestmentAccount
implements Serializable
{

    final static long serialVersionUID = 7486498919833175661L;
    /**
     * Unique identifier for this loan
     * 
     */
   // @Id
    @Column(name= "LoanId")
    private String loanId;
    /**
     * Description
     * 
     */
    @Column(name= "LoanDescription")
    private String loanDescription;
    /**
     * Initial loan balance amount
     * 
     */
    @Column(name= "InitialLoanBalance")
    private Double initialLoanBalance;
    /**
     * Start date of the loan
     * 
     */
    @Column(name= "LoanStartDate")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date loanStartDate;
    /**
     * Current loan principal balance amount
     * 
     */
    @Column(name= "CurrentLoanBalance")
    private Double currentLoanBalance;
    /**
     * Date and time of current loan balance
     * 
     */
    @Column(name= "DateAsOf")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date dateAsOf;
    /**
     * Loan annual interest rate for the loan
     * 
     */
    @Column(name= "LoanRate")
    private Double loanRate;
    /**
     * Loan payment amount
     * 
     */
    @Column(name= "LoanPaymentAmount")
    private Double loanPaymentAmount;
    /**
     * Loan Payment Frequency
     * 
     */
    @Enumerated(EnumType.STRING) 
    @Column(name= "LoanPaymentFrequency")
    private LoanPaymentFrequency loanPaymentFrequency;
    /**
     * Initial number of loan payments
     * 
     */
    @Column(name= "LoanPaymentInitial")
    private Double loanPaymentInitial;
    /**
     * Remaining number of loan payments
     * 
     */
    @Column(name= "LoanPaymentsRemaining")
    private Long loanPaymentsRemaining;
    /**
     * Expected loan end date
     * 
     */
    @Column(name= "LoanMaturityDate")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date loanMaturityDate;
    /**
     * Total interest paid to date on this loan
     * 
     */
    @Column(name= "LoanInterestToDate")
    private Double loanInterestToDate;
    /**
     * Total projected interest to be paid on this loan
     * 
     */
    @Column(name= "LoanTotalProjectedInterest")
    private Double loanTotalProjectedInterest;
    /**
     * The next payment date for the loan
     * 
     */
    @Column(name= "LoanNextPaymentDate")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date loanNextPaymentDate;

    /**
     * Creates a new InvestmentLoan.
     * 
     */
    public InvestmentLoan() {
        super();
    }

    /**
     * Creates a new InvestmentLoan.
     * 
     */
    public InvestmentLoan(String loanId, String loanDescription, Double initialLoanBalance, Date loanStartDate, Double currentLoanBalance, Date dateAsOf, Double loanRate, Double loanPaymentAmount, LoanPaymentFrequency loanPaymentFrequency, Double loanPaymentInitial, Long loanPaymentsRemaining, Date loanMaturityDate, Double loanInterestToDate, Double loanTotalProjectedInterest, Date loanNextPaymentDate) {
        super();
        this.loanId = loanId;
        this.loanDescription = loanDescription;
        this.initialLoanBalance = initialLoanBalance;
        this.loanStartDate = loanStartDate;
        this.currentLoanBalance = currentLoanBalance;
        this.dateAsOf = dateAsOf;
        this.loanRate = loanRate;
        this.loanPaymentAmount = loanPaymentAmount;
        this.loanPaymentFrequency = loanPaymentFrequency;
        this.loanPaymentInitial = loanPaymentInitial;
        this.loanPaymentsRemaining = loanPaymentsRemaining;
        this.loanMaturityDate = loanMaturityDate;
        this.loanInterestToDate = loanInterestToDate;
        this.loanTotalProjectedInterest = loanTotalProjectedInterest;
        this.loanNextPaymentDate = loanNextPaymentDate;
    }

    /**
     * Returns the loanId.
     * 
     * @return
     *     loanId
     */
    public String getLoanId() {
        return loanId;
    }

    /**
     * Set the loanId.
     * 
     * @param loanId
     *     the new loanId
     */
    public void setLoanId(String loanId) {
        this.loanId = loanId;
    }

    /**
     * Returns the loanDescription.
     * 
     * @return
     *     loanDescription
     */
    public String getLoanDescription() {
        return loanDescription;
    }

    /**
     * Set the loanDescription.
     * 
     * @param loanDescription
     *     the new loanDescription
     */
    public void setLoanDescription(String loanDescription) {
        this.loanDescription = loanDescription;
    }

    /**
     * Returns the initialLoanBalance.
     * 
     * @return
     *     initialLoanBalance
     */
    public Double getInitialLoanBalance() {
        return initialLoanBalance;
    }

    /**
     * Set the initialLoanBalance.
     * 
     * @param initialLoanBalance
     *     the new initialLoanBalance
     */
    public void setInitialLoanBalance(Double initialLoanBalance) {
        this.initialLoanBalance = initialLoanBalance;
    }

    /**
     * Returns the loanStartDate.
     * 
     * @return
     *     loanStartDate
     */
    public Date getLoanStartDate() {
        return loanStartDate;
    }

    /**
     * Set the loanStartDate.
     * 
     * @param loanStartDate
     *     the new loanStartDate
     */
    public void setLoanStartDate(Date loanStartDate) {
        this.loanStartDate = loanStartDate;
    }

    /**
     * Returns the currentLoanBalance.
     * 
     * @return
     *     currentLoanBalance
     */
    public Double getCurrentLoanBalance() {
        return currentLoanBalance;
    }

    /**
     * Set the currentLoanBalance.
     * 
     * @param currentLoanBalance
     *     the new currentLoanBalance
     */
    public void setCurrentLoanBalance(Double currentLoanBalance) {
        this.currentLoanBalance = currentLoanBalance;
    }

    /**
     * Returns the dateAsOf.
     * 
     * @return
     *     dateAsOf
     */
    public Date getDateAsOf() {
        return dateAsOf;
    }

    /**
     * Set the dateAsOf.
     * 
     * @param dateAsOf
     *     the new dateAsOf
     */
    public void setDateAsOf(Date dateAsOf) {
        this.dateAsOf = dateAsOf;
    }

    /**
     * Returns the loanRate.
     * 
     * @return
     *     loanRate
     */
    public Double getLoanRate() {
        return loanRate;
    }

    /**
     * Set the loanRate.
     * 
     * @param loanRate
     *     the new loanRate
     */
    public void setLoanRate(Double loanRate) {
        this.loanRate = loanRate;
    }

    /**
     * Returns the loanPaymentAmount.
     * 
     * @return
     *     loanPaymentAmount
     */
    public Double getLoanPaymentAmount() {
        return loanPaymentAmount;
    }

    /**
     * Set the loanPaymentAmount.
     * 
     * @param loanPaymentAmount
     *     the new loanPaymentAmount
     */
    public void setLoanPaymentAmount(Double loanPaymentAmount) {
        this.loanPaymentAmount = loanPaymentAmount;
    }

    /**
     * Returns the loanPaymentFrequency.
     * 
     * @return
     *     loanPaymentFrequency
     */
    public LoanPaymentFrequency getLoanPaymentFrequency() {
        return loanPaymentFrequency;
    }

    /**
     * Set the loanPaymentFrequency.
     * 
     * @param loanPaymentFrequency
     *     the new loanPaymentFrequency
     */
    public void setLoanPaymentFrequency(LoanPaymentFrequency loanPaymentFrequency) {
        this.loanPaymentFrequency = loanPaymentFrequency;
    }

    /**
     * Returns the loanPaymentInitial.
     * 
     * @return
     *     loanPaymentInitial
     */
    public Double getLoanPaymentInitial() {
        return loanPaymentInitial;
    }

    /**
     * Set the loanPaymentInitial.
     * 
     * @param loanPaymentInitial
     *     the new loanPaymentInitial
     */
    public void setLoanPaymentInitial(Double loanPaymentInitial) {
        this.loanPaymentInitial = loanPaymentInitial;
    }

    /**
     * Returns the loanPaymentsRemaining.
     * 
     * @return
     *     loanPaymentsRemaining
     */
    public Long getLoanPaymentsRemaining() {
        return loanPaymentsRemaining;
    }

    /**
     * Set the loanPaymentsRemaining.
     * 
     * @param loanPaymentsRemaining
     *     the new loanPaymentsRemaining
     */
    public void setLoanPaymentsRemaining(Long loanPaymentsRemaining) {
        this.loanPaymentsRemaining = loanPaymentsRemaining;
    }

    /**
     * Returns the loanMaturityDate.
     * 
     * @return
     *     loanMaturityDate
     */
    public Date getLoanMaturityDate() {
        return loanMaturityDate;
    }

    /**
     * Set the loanMaturityDate.
     * 
     * @param loanMaturityDate
     *     the new loanMaturityDate
     */
    public void setLoanMaturityDate(Date loanMaturityDate) {
        this.loanMaturityDate = loanMaturityDate;
    }

    /**
     * Returns the loanInterestToDate.
     * 
     * @return
     *     loanInterestToDate
     */
    public Double getLoanInterestToDate() {
        return loanInterestToDate;
    }

    /**
     * Set the loanInterestToDate.
     * 
     * @param loanInterestToDate
     *     the new loanInterestToDate
     */
    public void setLoanInterestToDate(Double loanInterestToDate) {
        this.loanInterestToDate = loanInterestToDate;
    }

    /**
     * Returns the loanTotalProjectedInterest.
     * 
     * @return
     *     loanTotalProjectedInterest
     */
    public Double getLoanTotalProjectedInterest() {
        return loanTotalProjectedInterest;
    }

    /**
     * Set the loanTotalProjectedInterest.
     * 
     * @param loanTotalProjectedInterest
     *     the new loanTotalProjectedInterest
     */
    public void setLoanTotalProjectedInterest(Double loanTotalProjectedInterest) {
        this.loanTotalProjectedInterest = loanTotalProjectedInterest;
    }

    /**
     * Returns the loanNextPaymentDate.
     * 
     * @return
     *     loanNextPaymentDate
     */
    public Date getLoanNextPaymentDate() {
        return loanNextPaymentDate;
    }

    /**
     * Set the loanNextPaymentDate.
     * 
     * @param loanNextPaymentDate
     *     the new loanNextPaymentDate
     */
    public void setLoanNextPaymentDate(Date loanNextPaymentDate) {
        this.loanNextPaymentDate = loanNextPaymentDate;
    }

    public int hashCode() {
        return new HashCodeBuilder().append(loanId).append(loanDescription).append(initialLoanBalance).append(loanStartDate).append(currentLoanBalance).append(dateAsOf).append(loanRate).append(loanPaymentAmount).append(loanPaymentFrequency).append(loanPaymentInitial).append(loanPaymentsRemaining).append(loanMaturityDate).append(loanInterestToDate).append(loanTotalProjectedInterest).append(loanNextPaymentDate).toHashCode();
    }

    public boolean equals(Object other) {
        if (other == null) {
            return false;
        }
        if (other == this) {
            return true;
        }
        if (this.getClass()!= other.getClass()) {
            return false;
        }
        InvestmentLoan otherObject = ((InvestmentLoan) other);
        return new EqualsBuilder().append(loanId, otherObject.loanId).append(loanDescription, otherObject.loanDescription).append(initialLoanBalance, otherObject.initialLoanBalance).append(loanStartDate, otherObject.loanStartDate).append(currentLoanBalance, otherObject.currentLoanBalance).append(dateAsOf, otherObject.dateAsOf).append(loanRate, otherObject.loanRate).append(loanPaymentAmount, otherObject.loanPaymentAmount).append(loanPaymentFrequency, otherObject.loanPaymentFrequency).append(loanPaymentInitial, otherObject.loanPaymentInitial).append(loanPaymentsRemaining, otherObject.loanPaymentsRemaining).append(loanMaturityDate, otherObject.loanMaturityDate).append(loanInterestToDate, otherObject.loanInterestToDate).append(loanTotalProjectedInterest, otherObject.loanTotalProjectedInterest).append(loanNextPaymentDate, otherObject.loanNextPaymentDate).isEquals();
    }

    public String toString() {
        return new ToStringBuilder(this).append("loanId", loanId).append("loanDescription", loanDescription).append("initialLoanBalance", initialLoanBalance).append("loanStartDate", loanStartDate).append("currentLoanBalance", currentLoanBalance).append("dateAsOf", dateAsOf).append("loanRate", loanRate).append("loanPaymentAmount", loanPaymentAmount).append("loanPaymentFrequency", loanPaymentFrequency).append("loanPaymentInitial", loanPaymentInitial).append("loanPaymentsRemaining", loanPaymentsRemaining).append("loanMaturityDate", loanMaturityDate).append("loanInterestToDate", loanInterestToDate).append("loanTotalProjectedInterest", loanTotalProjectedInterest).append("loanNextPaymentDate", loanNextPaymentDate).toString();
    }

}
