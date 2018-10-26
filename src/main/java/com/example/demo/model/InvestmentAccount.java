
package com.example.demo.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name= "investmentaccount")
//@Inheritance(strategy = InheritanceType.JOINED)
//@PrimaryKeyJoinColumn(name = "AccountMasterId")
public class InvestmentAccount
    extends Account
    implements Serializable
{

    final static long serialVersionUID = 7160959584412481669L;
	
    /**
     * As-of date for balances
     * 
     */
    @JsonIgnore
    @Column(name= "BalanceAsOf")
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ssXXX")
    private Date balanceAsOf;
    /**
     * Total current value of all investments
     * 
     */ 
    @JsonIgnore
    @Column(name= "CurrentValue")
    private Double currentValue;
    
    
    
    /*@Column(name= "InvestmentLoans")
    @ElementCollection(targetClass=InvestmentLoan.class)
    private List<InvestmentLoan> investmentLoans = new ArrayList<InvestmentLoan>();*/
    
   // @Id
    @JsonIgnore
    @Column(name = "InvestmentAccountId")
    private Double investmentAccountId;

    public Double getInvestmentAccountId() {
		return investmentAccountId;
	}

	public void setInvestmentAccountId(Double investmentAccountId) {
		this.investmentAccountId = investmentAccountId;
	}

	/**
     * Creates a new InvestmentAccount.
     * 
     */
    public InvestmentAccount() {
        super();
    }

    /**
     * Creates a new InvestmentAccount.
     * 
     */
    public InvestmentAccount(String accountId, AccountType accountType, String displayName, String description, AccountStatus accountStatus, String parentAccountId, String accountNumber, Double interestRate, Date balanceAsOf, Double currentValue, /*List<InvestmentLoan> investmentLoans,*/ Double accountDescriptorId,Double accountMasterId,Double investmentAccountId) {
        //super(accountId, accountType, displayName, description, accountStatus, parentAccountId, accountNumber, interestRate, accountDescriptorId,accountMasterId);
    	super();
        this.balanceAsOf = balanceAsOf;
        this.currentValue = currentValue;
        //this.investmentLoans = investmentLoans;
        this.investmentAccountId = investmentAccountId;
    }

    /**
     * Returns the balanceAsOf.
     * 
     * @return
     *     balanceAsOf
     */
    public Date getBalanceAsOf() {
        return balanceAsOf;
    }

    /**
     * Set the balanceAsOf.
     * 
     * @param balanceAsOf
     *     the new balanceAsOf
     */
    public void setBalanceAsOf(Date balanceAsOf) {
        this.balanceAsOf = balanceAsOf;
    }

    /**
     * Returns the currentValue.
     * 
     * @return
     *     currentValue
     */
    public Double getCurrentValue() {
        return currentValue;
    }

    /**
     * Set the currentValue.
     * 
     * @param currentValue
     *     the new currentValue
     */
    public void setCurrentValue(Double currentValue) {
        this.currentValue = currentValue;
    }

    /**
     * Returns the investmentLoans.
     * 
     * @return
     *     investmentLoans
     */
 /*   public List<InvestmentLoan> getInvestmentLoans() {
        return investmentLoans;
    }

    *//**
     * Set the investmentLoans.
     * 
     * @param investmentLoans
     *     the new investmentLoans
     *//*
    public void setInvestmentLoans(List<InvestmentLoan> investmentLoans) {
        this.investmentLoans = investmentLoans;
    }*/

    public int hashCode() {
        return new HashCodeBuilder().appendSuper(super.hashCode()).append(balanceAsOf).append(currentValue)/*.append(investmentLoans)*/.toHashCode();
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
        InvestmentAccount otherObject = ((InvestmentAccount) other);
        return new EqualsBuilder().appendSuper(super.equals(otherObject)).append(balanceAsOf, otherObject.balanceAsOf).append(currentValue, otherObject.currentValue)/*.append(investmentLoans, otherObject.investmentLoans)*/.isEquals();
    }

    public String toString() {
        return new ToStringBuilder(this).appendSuper(super.toString()).append("balanceAsOf", balanceAsOf).append("currentValue", currentValue)/*.append("investmentLoans", investmentLoans)*/.toString();
    }

}
