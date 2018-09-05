
package com.app.view;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.view.document.AbstractPdfView;

import com.app.model.Customer;
import com.lowagie.text.Document;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;


public class CustomerPdfView extends AbstractPdfView {

	@Override
	protected void buildPdfDocument(Map<String, Object> map, Document doc,
			PdfWriter pw, HttpServletRequest req, HttpServletResponse res)
			throws Exception {
		res.addHeader("content-Disposition", "attachment;filename=CUST.pdf");
		@SuppressWarnings("unchecked")
		List<Customer> cust=(List<Customer>) map.get("cust");
		
		Paragraph p=new Paragraph("Welcome to the Customer Pdf");
		
		PdfPTable t=new PdfPTable(7);
		t.addCell("ID");
		t.addCell("Name");
		t.addCell("Email");
		t.addCell("Type");
		t.addCell("Address");
		t.addCell("Password");
		t.addCell("Token");
		
		for(Customer c:cust){
			t.addCell(c.getCustId()+" ");
			t.addCell(c.getCustName());
			t.addCell(c.getCustEmail());
			t.addCell(c.getCustType());
			t.addCell(c.getCustAddr());
			t.addCell(c.getPassword());
			t.addCell(c.getAccToken());
		}
		doc.add(p);
		doc.add(t);
		doc.add(new Paragraph(new Date().toString()));
	}
}
