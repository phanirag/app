package com.app.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;


@Entity
@Table(name="CUST_TAB")
public class Customer {
	@Id
	@Column(name="cid")
	@SequenceGenerator(name="cust",sequenceName="cust_seq")
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="cust") //cust_seq - starts with 500000
	private int custId;
	
	@Size(min=2,max=20,message="Please Enter UserName(2-20)")
	@Column(name="cname")
	private String custName;
	
	@Email(message="Enter Valid Email")
	@Column(name="email")
	private String custEmail;
	
	@Column(name="ctype")
	private String custType;

	@NotEmpty(message="Customer address cannot be Empty")
	@Column(name="caddr")
	private String custAddr;
	
	@Column(name="pwd")
	private String password;
	
	@Column(name="token")
	private String accToken;
	
	public Customer() {
		super();
	}
		
	public Customer(int custId) {
		this.custId = custId;
	}
	
	

	public Customer(int custId, String custName, String custEmail,
			String custType, String custAddr, String password, String accToken) {
		this.custId = custId;
		this.custName = custName;
		this.custEmail = custEmail;
		this.custType = custType;
		this.custAddr = custAddr;
		this.password = password;
		this.accToken = accToken;
	}

	@Override
	public String toString() {
		return "Customer [custId=" + custId + ", custName=" + custName
				+ ", custEmail=" + custEmail + ", custType=" + custType
				+ ", custAddr=" + custAddr + ", password=" + password
				+ ", accToken=" + accToken + "]";
	}
	public int getCustId() {
		return custId;
	}
	public void setCustId(int custId) {
		this.custId = custId;
	}
	public String getCustName() {
		return custName;
	}
	public void setCustName(String custName) {
		this.custName = custName;
	}
	public String getCustEmail() {
		return custEmail;
	}
	public void setCustEmail(String custEmail) {
		this.custEmail = custEmail;
	}
	public String getCustType() {
		return custType;
	}
	public void setCustType(String custType) {
		this.custType = custType;
	}
	public String getCustAddr() {
		return custAddr;
	}
	public void setCustAddr(String custAddr) {
		this.custAddr = custAddr;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getAccToken() {
		return accToken;
	}
	public void setAccToken(String accToken) {
		this.accToken = accToken;
	}
	
	
}
