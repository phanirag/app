package com.app.util;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;
import org.springframework.stereotype.Component;

@Component
public class LocationUtil {

	public void generatePie(String path,List<Object[]> list){
		//1. convert List to Dataset 
		DefaultPieDataset dataset=new DefaultPieDataset();
		for(Object[] ob:list){
			dataset.setValue(ob[0].toString(), new Double(ob[1].toString()));
		}
		//2. convert DS to JFreeChart
		JFreeChart chart=ChartFactory.createPieChart3D("Location Report", dataset, true, true, false);
		
		//3. generate Image using ChartUtils
		try {
			ChartUtilities.saveChartAsJPEG(new File(path+"/LocPieA.jpg"), chart, 250, 250);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public void generateBarChart(String path,List<Object[]> list){
		//1. create DataSet
		DefaultCategoryDataset dataset=new DefaultCategoryDataset();
		for(Object[] ob:list){
			dataset.setValue(new Double(ob[1].toString()), ob[0].toString() , "");
		}
		//2. convert dataset to JFreeChart
		JFreeChart chart=ChartFactory.createBarChart3D("Location Report", "Location Type", "COUNT", dataset);
		//3. convert to images
		try {
			ChartUtilities.saveChartAsJPEG(new File(path+"/LocBarB.jpg"), chart, 250,250);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	
}





