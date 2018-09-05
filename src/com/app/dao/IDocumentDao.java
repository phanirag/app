package com.app.dao;

import java.util.List;

import com.app.model.Document;

public interface IDocumentDao {

	public int saveDocument(Document doc);
	public List<Object[]> getDocsIdAndName();
	public Document getDocumentById(int fileId);
	
	
	
	
	
	

}
