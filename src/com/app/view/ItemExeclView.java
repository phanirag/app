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

public class ItemExeclView extends AbstractExcelView{

	@Override
	protected void buildExcelDocument(Map<String, Object> map,
			HSSFWorkbook book, HttpServletRequest req, HttpServletResponse res)
			throws Exception {
		res.addHeader("content-Disposition", "attachment;filename=Item.xls");
		@SuppressWarnings("unchecked")
		List<Item> Item=(List<Item>) map.get("Item");
		HSSFSheet sheet= book.createSheet("Item");
		setHead(sheet);
		setBody(sheet,Item);
	}
	
	private void setHead(HSSFSheet sheet){
	int rownum=0;
	HSSFRow row=sheet.createRow(rownum);
	row.createCell(0).setCellValue("ID");
	row.createCell(1).setCellValue("Name");
	row.createCell(2).setCellValue("Cost");
	row.createCell(3).setCellValue("CustomerId");
	}
	
	private void setBody(HSSFSheet sheet, List<Item> Item) {
		int rownum=1;
		for(Item I:Item){ 
			HSSFRow row=sheet.createRow(rownum++);
			row.createCell(0).setCellValue(I.getItemId());
			row.createCell(1).setCellValue(I.getItemName());
			row.createCell(2).setCellValue(I.getItemCost());
			row.createCell(3).setCellValue(I.getCustId());
		}
	}
}
