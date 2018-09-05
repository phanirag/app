package com.app.view;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.view.document.AbstractPdfView;

import com.app.model.Vendor;
import com.lowagie.text.Document;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;


public class VendorPdfView extends AbstractPdfView {

	@Override
	protected void buildPdfDocument(Map<String, Object> map, Document doc,
			PdfWriter pw, HttpServletRequest req, HttpServletResponse res)
			throws Exception {
		res.addHeader("content-Disposition", "attachment;filename=Vendor.pdf");
		@SuppressWarnings("unchecked")
		List<Vendor> vens=(List<Vendor>) map.get("vens");
		
		Paragraph p=new Paragraph("Welcome to the Vendor Pdf");
		
		PdfPTable t=new PdfPTable(8);
		t.addCell("ID");
		t.addCell("Code");
		t.addCell("Name");
		t.addCell("Type");
		t.addCell("Address");
		t.addCell("ID Type");
		t.addCell("ID Number");
		t.addCell("Note");
		
		for(Vendor v:vens){
			t.addCell(v.getVenId()+" ");
			t.addCell(v.getVenCode());
			t.addCell(v.getVenName());
			t.addCell(v.getVenType());
			t.addCell(v.getVenAddr());
			t.addCell(v.getIdType());
			t.addCell(v.getIdNum());
			t.addCell(v.getDsc());
		}
		doc.add(p);
		doc.add(t);
		doc.add(new Paragraph(new Date().toString()));
	}
}
