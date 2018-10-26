
package com.example.demo.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name= "accountdescriptor")
//@PrimaryKeyJoinColumn(name = "AccountDescriptorId")
public class AccountDescriptor implements Serializable
{

    final static long serialVersionUID = 7160959584412481669L;
    /**
     * Long-term persistent identity of the account.Not an account number.This identity must be unique to the owning institution.
     * 
     */
    @Column(name= "AccountId")
    private String accountId;
    
    @JsonIgnore
    @Enumerated(EnumType.STRING)
    @Column(name= "AccountType")
    private AccountType accountType;
    /**
     * Account identity to display to customer
     * 
     */
    @Column(name= "DisplayName")
    private String displayName;
    /**
     * Description of account
     * 
     */
    @JsonIgnore
    @Column(name= "Description")
    private String description;
    /**
     * Account status
     * 
     */
    @JsonIgnore
    @Enumerated(EnumType.STRING)
    @Column(name= "Status")
    private AccountStatus accountStatus;
    
    @Id
    @JsonIgnore
    @Column(name = "AccountDescriptorId")
    private Double accountDescriptorId;
    
    
    @JsonIgnore
    @Column(name = "CustomerId")
    private String customerId;
    

    public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public Double getAccountDescriptorId() {
		return accountDescriptorId;
	}

	public void setAccountDescriptorId(Double accountDescriptorId) {
		this.accountDescriptorId = accountDescriptorId;
	}

	/**
     * Creates a new AccountDescriptor.
     * 
     */
    public AccountDescriptor() {
        super();
    }

    /**
     * Creates a new AccountDescriptor.
     * 
     */
    public AccountDescriptor(String accountId, AccountType accountType, String displayName, String description, AccountStatus accountStatus,Double accountDescriptorId ) {
        super();
        this.accountId = accountId;
        this.accountType = accountType;
        this.displayName = displayName;
        this.description = description;
        this.accountStatus = accountStatus;
        this.accountDescriptorId = accountDescriptorId;
    }

    /**
     * Returns the accountId.
     * 
     * @return
     *     accountId
     */
    public String getAccountId() {
        return accountId;
    }

    /**
     * Set the accountId.
     * 
     * @param accountId
     *     the new accountId
     */
    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    /**
     * Returns the accountType.
     * 
     * @return
     *     accountType
     */
    public AccountType getAccountType() {
        return accountType;
    }

    /**
     * Set the accountType.
     * 
     * @param accountType
     *     the new accountType
     */
    public void setAccountType(AccountType accountType) {
        this.accountType = accountType;
    }

    /**
     * Returns the displayName.
     * 
     * @return
     *     displayName
     */
    public String getDisplayName() {
        return displayName;
    }

    /**
     * Set the displayName.
     * 
     * @param displayName
     *     the new displayName
     */
    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    /**
     * Returns the description.
     * 
     * @return
     *     description
     */
    public String getDescription() {
        return description;
    }

    /**
     * Set the description.
     * 
     * @param description
     *     the new description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Returns the accountStatus.
     * 
     * @return
     *     accountStatus
     */
    public AccountStatus getAccountStatus() {
        return accountStatus;
    }

    /**
     * Set the accountStatus.
     * 
     * @param accountStatus
     *     the new accountStatus
     */
    public void setAccountStatus(AccountStatus accountStatus) {
        this.accountStatus = accountStatus;
    }

    public int hashCode() {
        return new HashCodeBuilder().append(accountId).append(accountType).append(displayName).append(description).append(accountStatus).toHashCode();
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
        AccountDescriptor otherObject = ((AccountDescriptor) other);
        return new EqualsBuilder().append(accountId, otherObject.accountId).append(accountType, otherObject.accountType).append(displayName, otherObject.displayName).append(description, otherObject.description).append(accountStatus, otherObject.accountStatus).isEquals();
    }

    public String toString() {
        return new ToStringBuilder(this).append("accountId", accountId).append("accountType", accountType).append("displayName", displayName).append("description", description).append("accountStatus", accountStatus).toString();
    }

}
