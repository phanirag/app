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
public class CustomerUtil {

	public void generatePie(String path,List<Object[]> list){
		//convert List type to dataset type
		DefaultPieDataset dataset=new DefaultPieDataset();
		for(Object[] ob:list){
			dataset.setValue(ob[0].toString(),new Double(ob[1].toString()));
		}
		//convert dataset to Jfreechart object using chartfactory
		JFreeChart chart=ChartFactory.createPieChart3D("Customer Pie Report", dataset,true,true,false);
		//Generate Image using Chartutilities
		try {
			ChartUtilities.saveChartAsJPEG(new File(path+"/custpie1.jpg"), chart, 300, 300);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void generateBar(String path,List<Object[]> list){
		DefaultCategoryDataset dataset=new DefaultCategoryDataset();
		for(Object[] ob:list){
			dataset.setValue(new Double(ob[1].toString()), ob[0].toString(), " ");
		}
		JFreeChart chart=ChartFactory.createBarChart3D("Customer Bar Report", "Customer Type", "COUNT", dataset);
		
		try {
			ChartUtilities.saveChartAsJPEG(new File(path+"/custBar1.jpg"), chart, 300, 300);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
