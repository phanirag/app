package com.app.view;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.view.document.AbstractPdfView;

import com.app.model.Item;
import com.lowagie.text.Document;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;


public class ItemPdfView extends AbstractPdfView {

	@Override
	protected void buildPdfDocument(Map<String, Object> map, Document doc,
			PdfWriter pw, HttpServletRequest req, HttpServletResponse res)
			throws Exception {
		res.addHeader("content-Disposition", "attachment;filename=Item.pdf");
		@SuppressWarnings("unchecked")
		List<Item> Item=(List<Item>) map.get("Item");
		
		Paragraph p=new Paragraph("Welcome to the Item Pdf");
		
		PdfPTable t=new PdfPTable(4);
		t.addCell("Item ID");
		t.addCell("Name");
		t.addCell("Cost");
		t.addCell("CustId");
		
		for(Item I:Item){
			t.addCell(I.getItemId()+" ");
			t.addCell(I.getItemName());
			t.addCell(I.getItemCost()+" ");
			t.addCell(I.getCustId()+" ");
		}
		doc.add(p);
		doc.add(t);
		doc.add(new Paragraph(new Date().toString()));
	}
}
