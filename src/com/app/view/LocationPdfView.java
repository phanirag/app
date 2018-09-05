package com.app.view;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.view.document.AbstractPdfView;

import com.app.model.Location;
import com.lowagie.text.Document;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

public class LocationPdfView extends AbstractPdfView {

	@Override
	protected void buildPdfDocument(Map<String, Object> map, Document doc,
			PdfWriter pw, HttpServletRequest req, HttpServletResponse res)
			throws Exception {
		
		res.addHeader("Content-Disposition", "attachment;filename=LOCATIONS.pdf");
		
		//1. read data from model map
		@SuppressWarnings("unchecked")
		List<Location> locs=(List<Location>) map.get("locs");
		
		//2. create elements
		//paragraph
		Paragraph p=new Paragraph("Welcome to Locations PDF File!!");
		
		
		//table with heading data
		PdfPTable table=new PdfPTable(5);
		table.addCell("ID");
		table.addCell("NAME");
		table.addCell("CODE");
		table.addCell("TYPE");
		table.addCell("NOTE");
		//JDK 1.5
		for(Location loc:locs){
			table.addCell(loc.getLocId()+"");
			table.addCell(loc.getLocName());
			table.addCell(loc.getLocCode());
			table.addCell(loc.getLocType());
			table.addCell(loc.getLocDesc());
		}
		
		
		//3. add elements to document
		doc.add(p);
		doc.add(table);
		doc.add(new Paragraph("-=-=-=-=-==--=-"));
		doc.add(new Paragraph(new Date().toString()));
		
		
	}

	
}
