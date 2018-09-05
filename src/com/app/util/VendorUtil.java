package com.app.util;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Component;
import org.springframework.ui.ModelMap;

@Component
public class VendorUtil {

	@Autowired
	private HibernateTemplate ht;
	
	public List<String> getVendorTypes(){
		return Arrays.asList("CONTRACT","FULLTIME","PARTTIME");
	}
	
	public List<String> getVendorIdTypes(){
		return Arrays.asList("PAN","AADHAR","VOTERID","OTHERS");
	}
	
	
	public void addUiComponents(ModelMap map){
		map.addAttribute("venTypesList", getVendorTypes());
		map.addAttribute("venIdTypesList", getVendorIdTypes());
	}
	
	public void generatePie(String path,List<Object[]> list){
		//convert List type to dataset type
		DefaultPieDataset dataset=new DefaultPieDataset();
		for(Object[] ob:list){
			dataset.setValue(ob[0].toString(),new Double(ob[1].toString()));
		}
		//convert dataset to Jfreechart object using chartfactory
		JFreeChart chart=ChartFactory.createPieChart3D("Vendor Pie Report", dataset,true,true,false);
		//Generate Image using Chartutilities
		try {
			ChartUtilities.saveChartAsJPEG(new File(path+"/Venpie1.jpg"), chart, 300, 300);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void generateBar(String path,List<Object[]> list){
		DefaultCategoryDataset dataset=new DefaultCategoryDataset();
		for(Object[] ob:list){
			dataset.setValue(new Double(ob[1].toString()), ob[0].toString(), " ");
		}
		JFreeChart chart=ChartFactory.createBarChart3D("Vendor Bar Report", "Vendor Type", "COUNT", dataset);
		
		try {
			ChartUtilities.saveChartAsJPEG(new File(path+"/VenBar1.jpg"), chart, 300, 300);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	
	
	
}
