package com.app.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.IDocumentDao;
import com.app.model.Document;

@Transactional
@Repository
public class DocumentDaoImpl implements IDocumentDao {
	@Autowired
	private HibernateTemplate ht;
	
	@Override
	public int saveDocument(Document doc) {
		return (Integer) ht.save(doc);
	}

	
	@Override
	public List<Object[]> getDocsIdAndName() {
		String hql="select fileId,fileName from com.app.model.Document";
		@SuppressWarnings("unchecked")
		List<Object[]> obs=ht.find(hql);
		return obs;
	}

	@Override
	public Document getDocumentById(int fileId) {
		return ht.get(Document.class, fileId);
	}

}





