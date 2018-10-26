
package com.example.demo.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name= "account")
//@Inheritance(strategy = InheritanceType.JOINED)
//@PrimaryKeyJoinColumn(name = "AccountDescriptorId")
public class Account
    extends AccountDescriptor
    implements Serializable
{

    final static long serialVersionUID = 7160959584412481669L;
    /**
     * Long-term persistent identity of the parent account.
     * 
     */
    @JsonIgnore
    @Column(name= "ParentAccountId")
    private String parentAccountId;
    /**
     * Account number
     * 
     */
    @JsonIgnore
    @Column(name= "AccountNumber")
    private String accountNumber;
    /**
     * Interest Rate of Account
     * 
     */
    @JsonIgnore
    @Column(name= "InterestRate")
    private Double interestRate;
    
    //@Id
    @JsonIgnore
    @Column(name = "AccountMasterId")
    private Double accountMasterId;
   

    public Double getAccountMasterId() {
		return accountMasterId;
	}

	public void setAccountMasterId(Double accountMasterId) {
		this.accountMasterId = accountMasterId;
	}

	/**
     * Creates a new Account.
     * 
     */
    public Account() {
        super();
    }

    /**
     * Creates a new Account.
     * 
     */
    public Account(String accountId, AccountType accountType, String displayName, String description, AccountStatus accountStatus, String parentAccountId, String accountNumber, Double interestRate, Double accountDescriptorId, Double accountMasterId) {
      //  super(accountId, accountType, displayName, description, accountStatus, accountDescriptorId);
    	super();
        this.parentAccountId = parentAccountId;
        this.accountNumber = accountNumber;
        this.interestRate = interestRate;
        this.accountMasterId=accountMasterId;
    }

    /**
     * Returns the parentAccountId.
     * 
     * @return
     *     parentAccountId
     */
    public String getParentAccountId() {
        return parentAccountId;
    }

    /**
     * Set the parentAccountId.
     * 
     * @param parentAccountId
     *     the new parentAccountId
     */
    public void setParentAccountId(String parentAccountId) {
        this.parentAccountId = parentAccountId;
    }

    /**
     * Returns the accountNumber.
     * 
     * @return
     *     accountNumber
     */
    public String getAccountNumber() {
        return accountNumber;
    }

    /**
     * Set the accountNumber.
     * 
     * @param accountNumber
     *     the new accountNumber
     */
    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    /**
     * Returns the interestRate.
     * 
     * @return
     *     interestRate
     */
    public Double getInterestRate() {
        return interestRate;
    }

    /**
     * Set the interestRate.
     * 
     * @param interestRate
     *     the new interestRate
     */
    public void setInterestRate(Double interestRate) {
        this.interestRate = interestRate;
    }

    public int hashCode() {
        return new HashCodeBuilder().appendSuper(super.hashCode()).append(parentAccountId).append(accountNumber).append(interestRate).toHashCode();
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
        Account otherObject = ((Account) other);
        return new EqualsBuilder().appendSuper(super.equals(otherObject)).append(parentAccountId, otherObject.parentAccountId).append(accountNumber, otherObject.accountNumber).append(interestRate, otherObject.interestRate).isEquals();
    }

    public String toString() {
        return new ToStringBuilder(this).appendSuper(super.toString()).append("parentAccountId", parentAccountId).append("accountNumber", accountNumber).append("interestRate", interestRate).toString();
    }

}
