package com.app.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name="ventab")
public class Vendor {
	@Id
	@Column(name="venid")
	@SequenceGenerator(name="ven",sequenceName="Ven_seq")
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="ven") //Ven_seq - starts with 3500000
	private int venId;
	
	@NotEmpty(message="Vendor Code cannot be empty")
	@Column(name="vencode")
	private String venCode;
	
	@Size(min=2,max=20,message="Please Enter UserName(2-20)")
	@Column(name="venname")
	private String venName;
	
	@Column(name="ventype")
	private String venType;
	
	@NotEmpty(message="Vendor Address Cannot be Empty")
	@Column(name="venaddr")
	private String venAddr;
	
	@Column(name="idtype")
	private String idType;
	
	@NotEmpty(message="Id Number Cannot be null")
	@Column(name="idnum")
	private String idNum;
	
	@NotEmpty(message="enter dsc")
	@Column(name="dsc")
	private String dsc;
	
	public Vendor() {
		super();
	}
	
	public Vendor(int venId) {
		super();
		this.venId = venId;
	}

	public Vendor(int venId, String venCode, String venName, String venType,
			String venAddr, String idType, String idNum, String dsc) {
		super();
		this.venId = venId;
		this.venCode = venCode;
		this.venName = venName;
		this.venType = venType;
		this.venAddr = venAddr;
		this.idType = idType;
		this.idNum = idNum;
		this.dsc = dsc;
	}
	public int getVenId() {
		return venId;
	}
	public void setVenId(int venId) {
		this.venId = venId;
	}
	public String getVenCode() {
		return venCode;
	}
	public void setVenCode(String venCode) {
		this.venCode = venCode;
	}
	public String getVenName() {
		return venName;
	}
	public void setVenName(String venName) {
		this.venName = venName;
	}
	public String getVenType() {
		return venType;
	}
	public void setVenType(String venType) {
		this.venType = venType;
	}
	public String getVenAddr() {
		return venAddr;
	}
	public void setVenAddr(String venAddr) {
		this.venAddr = venAddr;
	}
	public String getIdType() {
		return idType;
	}
	public void setIdType(String idType) {
		this.idType = idType;
	}
	public String getIdNum() {
		return idNum;
	}
	public void setIdNum(String idNum) {
		this.idNum = idNum;
	}
	public String getDsc() {
		return dsc;
	}
	public void setDsc(String dsc) {
		this.dsc = dsc;
	}
	@Override
	public String toString() {
		return "Vendor [venId=" + venId + ", venCode=" + venCode + ", venName="
				+ venName + ", venType=" + venType + ", venAddr=" + venAddr
				+ ", idType=" + idType + ", idNum=" + idNum + ", dsc=" + dsc
				+ "]";
	}
	
	
}
