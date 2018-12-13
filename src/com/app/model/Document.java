package com.app.model;

import java.util.Arrays;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


@Entity
@Table(name="doctab")
public class Document {
	@Id
	@Column(name="fid")
	/*@SequenceGenerator(name="doc",sequenceName="Doc_seq")
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="doc") //Doc_seq -starts with 1000000*/
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int fileId;
	@Column(name="fname")
	private String fileName;
	@Lob  //BLOB
	@Column(name="fdata")
	private byte[] fileData;
	
	public Document() {
		super();
	}
	public int getFileId() {
		return fileId;
	}
	public void setFileId(int fileId) {
		this.fileId = fileId;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public byte[] getFileData() {
		return fileData;
	}
	public void setFileData(byte[] fileData) {
		this.fileData = fileData;
	}
	@Override
	public String toString() {
		return "Document [fileId=" + fileId + ", fileName=" + fileName
				+ ", fileData=" + Arrays.toString(fileData) + "]";
	}
	
	
}
