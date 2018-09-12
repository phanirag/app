package com.app.view;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.web.servlet.view.document.AbstractExcelView;

import com.app.model.Item;
import com.app.model.Order;

public class OrderExeclView extends AbstractExcelView{

	@Override
	protected void buildExcelDocument(Map<String, Object> map,
			HSSFWorkbook book, HttpServletRequest req, HttpServletResponse res)
			throws Exception {
		res.addHeader("content-Disposition", "attachment;filename=Item.xls");
		@SuppressWarnings("unchecked")
		List<Order> Order=(List<Order>) map.get("Order");
		HSSFSheet sheet= book.createSheet("Order");
		setHead(sheet);
		setBody(sheet,Order);
	}
	
	private void setHead(HSSFSheet sheet){
	int rownum=0;
	HSSFRow row=sheet.createRow(rownum);
	row.createCell(0).setCellValue("ID");
	row.createCell(1).setCellValue("Code");
	row.createCell(2).setCellValue("Cost");
	row.createCell(3).setCellValue("ItemName");
	row.createCell(4).setCellValue("CustomerId");
	}
	
	private void setBody(HSSFSheet sheet, List<Order> order) {
		int rownum=1;
		for(Order I:order){ 
			HSSFRow row=sheet.createRow(rownum++);
			row.createCell(0).setCellValue(I.getOrderId());
			row.createCell(1).setCellValue(I.getOrderCode());
			row.createCell(2).setCellValue(I.getOrderCost());
			row.createCell(3).setCellValue(I.getiName());
			row.createCell(4).setCellValue(I.getCustId().getCustId());
		}
	}
}
