package com.app.controller;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.app.model.Document;
import com.app.service.IDocumentService;

@Controller
public class DocumentController {
	@Autowired
	private IDocumentService service;
	
	//1. show Document Page
	@RequestMapping("/showDocs")
	public String showDocs(ModelMap map){
		List<Object[]> obs=service.getDocsIdAndName();
		map.addAttribute("docs", obs);
		return "Documents";
	}
	
	//2. Upload Doc
	@RequestMapping(value="/uploadDoc",method=RequestMethod.POST)
	public String uploadDocument(
			@RequestParam("fileOb")CommonsMultipartFile cmf)
	{
		if(cmf!=null){
			//create model class obj
			Document doc=new Document();
			doc.setFileId(doc.getFileId());
			doc.setFileName(cmf.getOriginalFilename());
			doc.setFileData(cmf.getBytes());
			service.saveDocument(doc);
		}
		
		return "redirect:showDocs";
	}
	
	
	//3. Download Doc
	@RequestMapping("/downloadDoc")
	public void downloadDocument(
			@RequestParam("docId")int fileId,
			HttpServletResponse res	)
	{
		//1. goto DB , get model class obj
		Document doc=service.getDocumentById(fileId);
		//2. add Header in HttpServletRes
		res.addHeader("Content-Disposition", "attachment;filename="+doc.getFileName());
		
		try {
			//3. copy data to HttpServResp Body (OS)
			FileCopyUtils.copy(doc.getFileData(), res.getOutputStream());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
}
