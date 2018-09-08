package com.app.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name="USERS_TAB")
public class User {

	@Id
	@SequenceGenerator(name="usr",sequenceName="Usr_seq")
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="usr") //Usr_seq - starts with 3000000
	@Column(name="u_Id")
	private int userId;
	
	@Size(min=2,max=20,message="Please Enter UserName(2-20)")
	@Column(name="u_Name")
	private String userName;
	
	//@Email(message="Enter Valied Email Address")
	//@NotEmpty(message="Enter the Email Address")
	@Column(name="u_Email")
	private String userEmail;

	//@Pattern(regexp="(^$|[0-9]{10})",message="enter valid mobile number")
	@Digits(integer=10,fraction=0,message="Enter Valied Mobile Number")
	@Column(name="u_Contact")
	private String userContact;
	
	@Column(name="u_Pwd")
	private String userPwd;
	
	@NotEmpty(message="User Address Cannot be Empty")
	@Column(name="u_Address")
	private String userAddress;
	
	public User() {
		super();
	}

	public User(int userId) {
		this.userId = userId;
	}

	

	public User(int userId, String userName, String userEmail,
			String userContact, String userPwd, String userAddress) {
		this.userId = userId;
		this.userName = userName;
		this.userEmail = userEmail;
		this.userContact = userContact;
		this.userPwd = userPwd;
		this.userAddress = userAddress;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getUserContact() {
		return userContact;
	}

	public void setUserContact(String userContact) {
		this.userContact = userContact;
	}

	public String getUserPwd() {
		return userPwd;
	}

	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}

	public String getUserAddress() {
		return userAddress;
	}

	public void setUserAddress(String userAddress) {
		this.userAddress = userAddress;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", userName=" + userName
				+ ", userEmail=" + userEmail + ", userContact=" + userContact
				+ ", userPwd=" + userPwd + ", userAddress=" + userAddress + "]";
	}

	
	
	
}
