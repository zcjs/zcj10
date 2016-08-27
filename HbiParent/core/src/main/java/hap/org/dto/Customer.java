package hap.org.dto;


import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;

import com.hand.hap.core.annotation.MultiLanguage;
import com.hand.hap.mybatis.annotation.Condition;
import com.hand.hap.system.dto.BaseDTO;

@MultiLanguage
@Table(name = "hap_ar_customers")
public class Customer extends BaseDTO{
	
@Id
@Column	
@GeneratedValue(strategy=GenerationType.IDENTITY)
private Long customerId;

@Column
@NotEmpty
private String customerNumber;

@Column
@NotEmpty
private String customerName;

@Column
@NotEmpty
private Long companyId;

@Column
@NotEmpty
@Condition(exclude = true)
private String enabledFlag;



public Long getCustomerId() {
	return customerId;
}

public void setCustomerId(Long customerId) {
	this.customerId = customerId;
}

public String getCustomerNumber() {
	return customerNumber;
}

public void setCustomerNumber(String customerNumber) {
	this.customerNumber = customerNumber;
}

public String getCustomerName() {
	return customerName;
}

public void setCustomerName(String customerName) {
	this.customerName = customerName;
}

public Long getCompanyId() {
	return companyId;
}

public void setCompanyId(Long companyId) {
	this.companyId = companyId;
}

public String getEnabledFlag() {
	return enabledFlag;
}

public void setEnabledFlag(String enabledFlag) {
	this.enabledFlag = enabledFlag;
}





}
