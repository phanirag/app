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
@Table(name="loctab")
public class Location {
	@Id
	@Column(name="lid")
	/*@SequenceGenerator(name="loc",sequenceName="Loc_seq")
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="loc") //Loc_seq -starts with  2000000*/
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int locId;
	
	@Size(min=2,max=20,message="Please Enter UserName(2-20)")
	@Column(name="lname")
	private String locName;
	
	@NotEmpty(message="please enter the location code")
	@Column(name="lcode")
	private String locCode;
	
	@Column(name="ltype")
	private String locType;

	@NotEmpty(message="Location Description Cannot be Empty")
	@Column(name="ldsc")
	private String locDesc;
	
	//alt+shift+S,O(DeselectAll>OK)
	public Location() {
	}
	//alt+shift+S,O(DeselectAll, select Id>OK)
	public Location(int locId) {
		this.locId = locId;
	}
	//alt+shift+S,O(SelectAll>OK)
	public Location(int locId, String locName, String locCode, String locType,
			String locDesc) {
		this.locId = locId;
		this.locName = locName;
		this.locCode = locCode;
		this.locType = locType;
		this.locDesc = locDesc;
	}
	//---setter/getters
	public int getLocId() {
		return locId;
	}
	public void setLocId(int locId) {
		this.locId = locId;
	}
	public String getLocName() {
		return locName;
	}
	public void setLocName(String locName) {
		this.locName = locName;
	}
	public String getLocCode() {
		return locCode;
	}
	public void setLocCode(String locCode) {
		this.locCode = locCode;
	}
	public String getLocType() {
		return locType;
	}
	public void setLocType(String locType) {
		this.locType = locType;
	}
	public String getLocDesc() {
		return locDesc;
	}
	public void setLocDesc(String locDesc) {
		this.locDesc = locDesc;
	}
	//toString
	@Override
	public String toString() {
		return "Location [locId=" + locId + ", locName=" + locName
				+ ", locCode=" + locCode + ", locType=" + locType
				+ ", locDesc=" + locDesc + "]";
	}
	
}