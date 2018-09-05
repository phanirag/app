package com.app.view;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.web.servlet.view.document.AbstractExcelView;

import com.app.model.Customer;

public class CustomerExeclView extends AbstractExcelView{

	@Override
	protected void buildExcelDocument(Map<String, Object> map,
			HSSFWorkbook book, HttpServletRequest req, HttpServletResponse res)
			throws Exception {
		res.addHeader("content-Disposition", "attachment;filename=Customer.xls");
		@SuppressWarnings("unchecked")
		List<Customer> locs=(List<Customer>) map.get("cust");
		HSSFSheet sheet= book.createSheet("cust");
		setHead(sheet);
		setBody(sheet,locs);
	}
	
	private void setHead(HSSFSheet sheet){
	int rownum=0;
	HSSFRow row=sheet.createRow(rownum);
	row.createCell(0).setCellValue("ID");
	row.createCell(1).setCellValue("Name");
	row.createCell(2).setCellValue("Email");
	row.createCell(3).setCellValue("Type");
	row.createCell(4).setCellValue("Address");
	row.createCell(5).setCellValue("Password");
	row.createCell(6).setCellValue("Token");
	}
	
	private void setBody(HSSFSheet sheet, List<Customer> cust) {
		int rownum=1;
		for(Customer c:cust){
			HSSFRow row=sheet.createRow(rownum++);
			row.createCell(0).setCellValue(c.getCustId());
			row.createCell(1).setCellValue(c.getCustName());
			row.createCell(2).setCellValue(c.getCustEmail());
			row.createCell(3).setCellValue(c.getCustType());
			row.createCell(4).setCellValue(c.getCustAddr());
			row.createCell(4).setCellValue(c.getPassword());
			row.createCell(4).setCellValue(c.getAccToken());
		}
	}
}
